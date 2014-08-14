package com.example.calculadora5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textViewRetorno;
	EditText operadorUm, operadorDois;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		operadorUm = (EditText) findViewById(R.id.operador_um);
		operadorDois = (EditText) findViewById(R.id.operador_dois);
		textViewRetorno = (TextView) findViewById(R.id.textview_retorno);

	}

	public void setRetorno(String value) {
		textViewRetorno.setText(value);
	}

	public void Calcular(String acao) {
		try {
			setRetorno(new Calculadora().execute(
					operadorUm.getText().toString(),
					operadorDois.getText().toString(), acao).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Somar(View view) {
		Calcular("1");
	}

	public void Subtrair(View view) {
		Calcular("2");
	}

	public void Multiplicar(View view) {
		Calcular("3");
	}

	public void Dividir(View view) {
		Calcular("4");
	}

}
