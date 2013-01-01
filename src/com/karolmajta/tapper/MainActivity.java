package com.karolmajta.tapper;

import com.karolmajta.tapper.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	public static final String TAG = "MainActivity";
	
	private Intent launchGameActivity;
	private Intent launchInstructionsActivity;
	private Intent launchOptionsActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		launchGameActivity = new Intent(this, GameActivity.class);
		launchInstructionsActivity = new Intent(this, InstructionsActivity.class);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		startActivity(launchOptionsActivity);
		return true;
	}

	public void twoPlayerGame(View view) {
		launchGameActivity.putExtra("players", 2);
		startActivity(launchGameActivity);
	}

	public void fourPlayerGame(View view) {
		Intent i = launchGameActivity.putExtra("players", 4);
		startActivity(launchGameActivity);
	}
	
	public void onInstructionsClick(View view) {
		startActivity(launchInstructionsActivity);
	}
}