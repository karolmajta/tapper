package com.karolmajta.tapper;

import processing.core.PApplet;

import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;

import com.karolmajta.tapper.model.FourPlayerBoard;
import com.karolmajta.tapper.model.ITapBoard;
import com.karolmajta.tapper.model.Orientation;
import com.karolmajta.tapper.model.TwoPlayerBoard;
import com.karolmajta.tapper.painter.FourPlayerBoardPainter;
import com.karolmajta.tapper.painter.IBoardPainter;
import com.karolmajta.tapper.painter.TwoPlayerBoardPainter;

public class GameActivity extends PApplet {
	
	private ITapBoard board;
	private IBoardPainter boardPainter;
	private SoundPool soundPool;
	private boolean soundLoaded;
	private int rightSound;
	private int wrongSound;
	private int playersCount;
	
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		this.playersCount = getIntent().getIntExtra("players", 2);
	}
	
	@Override
	public void setup() {
		if (playersCount == 2) {
			board = new TwoPlayerBoard(width, height, Orientation.PORTRAIT);
			boardPainter = new TwoPlayerBoardPainter();
		}
		
		if (playersCount == 4) {
			board = new FourPlayerBoard(width, height, Orientation.PORTRAIT);
			boardPainter = new FourPlayerBoardPainter();
		}
	
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundLoaded = false;
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
          @Override
          public void onLoadComplete(SoundPool soundPool, int sampleId,
              int status) {
            soundLoaded = true;
          }
        });
        rightSound = soundPool.load(this, com.karolmajta.tapper.R.raw.right , 1);
        wrongSound = soundPool.load(this, com.karolmajta.tapper.R.raw.wrong, 1);
		
        setVolumeControlStream(AudioManager.STREAM_MUSIC);  
        
		noStroke();
		smooth();
	}
	
	@Override
	public void draw() {
		background(0xff000000);
		boardPainter.paint(this, board);
	}
	
	@Override
	public void mousePressed() {
		 AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
            .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
            .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
		boolean tapRight = board.tap(mouseX, mouseY);
		if (soundLoaded && tapRight) {
			soundPool.play(rightSound, volume, volume, 1, 0, 1f);
		}
		if (soundLoaded && !tapRight) {
			soundPool.play(wrongSound, volume, volume, 1, 0, 1f);
		}
	}
}
