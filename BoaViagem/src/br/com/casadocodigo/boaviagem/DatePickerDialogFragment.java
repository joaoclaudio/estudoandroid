package br.com.casadocodigo.boaviagem;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DatePickerDialogFragment extends DialogFragment {
	private int year;
	private int month;
	private int day;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use de current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH);
		this.day = c.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(),
				(GastoActivity) getActivity(), year, month, day);
	}
}
