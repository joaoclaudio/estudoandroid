package br.estudo.audioplayer;

import org.xml.sax.Parser;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.IntToString;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button play, stop, pause;

		play = (Button) findViewById(R.id.play);
		stop = (Button) findViewById(R.id.stop);
		pause = (Button) findViewById(R.id.pause);

		play.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MediaPlayer mp = MediaPlayer.create(MainActivity.this,
						R.raw.song);
				mp.start();																																		
				int duracao = mp.getDuration();
				int parte = duracao / 10;																																																																																																																																																								
				int atual = mp.getCurrentPosition();
				TextView tx = (TextView)findViewById(R.id.texto);																																																				
				//tx.setText(getString(atual));
				while (true) {
					if (atual==parte)																																																																																																																																																																																							{
						tx.setText(Integer.toString(atual));
					}
				}
			}
		});

		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MediaPlayer mp = MediaPlayer.create(MainActivity.this,
						R.raw.song);
				if (mp.isPlaying()) {
					mp.stop();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
