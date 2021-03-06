package br.com.casadocodigo.boaviagem;

import java.util.Calendar;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class GastoActivity extends FragmentActivity implements
		OnDateSetListener {

	private int ano, mes, dia;
	private Button dataGasto;
	private Spinner categoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gasto);

		Calendar calendar = Calendar.getInstance();
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);

		dataGasto = (Button) findViewById(R.id.data);
		dataGasto.setText(dia + "/" + (mes + 1) + "/" + ano);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.categoria_gasto, android.R.layout.simple_spinner_item);
		categoria = (Spinner) findViewById(R.id.categoria);
		categoria.setAdapter(adapter);
	}

	public void selecionarData(View view) {
		// showDialog(view.getId());
		DatePickerDialogFragment newFragment = new DatePickerDialogFragment();
		newFragment.show(getSupportFragmentManager(), "datePicker");
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		dataGasto.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
	}

}
