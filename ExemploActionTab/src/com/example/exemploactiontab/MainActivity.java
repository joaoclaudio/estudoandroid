package com.example.exemploactiontab;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// O método setContentView() não é usado, será utilizado o container root
		// android.R.id.content como container para cada fragment
		
		// Prepara a Action Bar para utilizar tabs
		ActionBar actionBar = getActionBar();
		actionBar.setTitle("Navigation tab demo");
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab = actionBar.newTab()
				.setText("Artistas")
				.setTabListener(new TabListener<ArtistaFragment>(
						this, "artista", ArtistaFragment.class));
		actionBar.addTab(tab);
		
		tab = actionBar.newTab()
				.setText("Albuns")
				.setTabListener(new TabListener<AlbunsFragment>(
						this, "albuns", AlbunsFragment.class));
		actionBar.addTab(tab);
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
