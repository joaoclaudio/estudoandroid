package com.example.de.vogella.android.locationapi.simple;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowLocationActivity extends Activity implements LocationListener {

	private TextView latitudeField;
	private TextView longitudeField;
	private LocationManager locationManager;
	private String provider;
	private boolean enabled;
	private String urlbase = "http://maps.googleapis.com/maps/api"
			+ "/staticmap?size=400x400&sensor=true&markers=color:red|%s,%s";
	private WebView mapa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_location);
		latitudeField = (TextView) findViewById(R.id.TextView02);
		longitudeField = (TextView) findViewById(R.id.TextView04);
		mapa = (WebView) findViewById(R.id.mapa);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		enabled = locationManager
				.isProviderEnabled(LocationManager.GPS_PROVIDER);
		Criteria criteria = new Criteria();
		//provider = locationManager.getBestProvider(criteria, false);
		provider = LocationManager.GPS_PROVIDER;
		Location location = locationManager.getLastKnownLocation(provider);

		// check if enabled and if not send user to the GSP settings
		// Better solution would be to display a dialog and suggesting to
		// go to the settings
		if (!enabled) {
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(intent);
			enabled = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);
		} else {

			if (location != null) {
				Toast.makeText(this,
						"Provider " + provider + " has been selected ",
						Toast.LENGTH_LONG).show();
				onLocationChanged(location);
			} else {
				latitudeField.setText("Location not available");
				longitudeField.setText("Location not available");
			}
		}

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(this, "Está no onResume()", Toast.LENGTH_SHORT).show();
		locationManager.requestLocationUpdates(provider, 1000*60*1, 1, this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_location, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		String latitudeStr = String.valueOf(location.getLatitude());
		String longitudeStr = String.valueOf(location.getLongitude());
		latitudeField.setText(latitudeStr);
		longitudeField.setText(longitudeStr);
		String url = String.format(urlbase, latitudeStr, longitudeStr);
		mapa.loadUrl(url);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();

	}
}
