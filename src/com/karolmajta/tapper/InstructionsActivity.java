package com.karolmajta.tapper;

import com.karolmajta.tapper.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class InstructionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_instructions);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
}
