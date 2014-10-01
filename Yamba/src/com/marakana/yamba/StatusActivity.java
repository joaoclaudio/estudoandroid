package com.marakana.yamba;

import android.app.Activity;
import android.os.Bundle;

public class StatusActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.new_activity_status);

		if (savedInstanceState == null) {
			StatusFragment fragment = new StatusFragment();
			getFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, fragment,
							fragment.getClass().getSimpleName()).commit();
		}
	}
}
