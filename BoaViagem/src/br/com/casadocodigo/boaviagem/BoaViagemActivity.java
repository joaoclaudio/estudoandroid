package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BoaViagemActivity extends Activity {

	private EditText usuario;
	private EditText senha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		usuario = (EditText) findViewById(R.id.usuario);
		senha = (EditText) findViewById(R.id.senha);
	}

	public void entrarOnClick(View view) {

		String usuarioInformado = usuario.getText().toString();
		String senhaInformada = senha.getText().toString();

		if ("leitor".equals(usuarioInformado) && 
				"1234".equals(senhaInformada)) {
			
			startActivity(new Intent(this,DashboardActivity.class));
			
		} else {
			
			String mensagemErro = getString(R.string.erro_autenticacao);
			Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT);
			toast.show();
		}

	}

}
