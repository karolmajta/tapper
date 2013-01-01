package com.karolmajta.tapper.model;

import java.util.Date;
import java.util.Random;

public class FourPlayerBoard implements ITapBoard {

	private int width;
	private int height;
	private Orientation orientation;
	
	private long lastTimeScheduled;
	private Random rGen;
	
	private int [] scores = new int [4];

	public FourPlayerBoard(int width, int height, Orientation orientation) {
		this.width = width;
		this.height = height;
		this.orientation = orientation;
		Date date = new java.util.Date();
		this.rGen = new Random();
		this.lastTimeScheduled = date.getTime() + rGen.nextInt(5000);
	}


	@Override
	public boolean tap(float x, float y) {
		int playerIndex = 0;
		if (x < width/2 && y < height/2) {
			playerIndex = 0;
		} else if (x >= width/2 && y < height/2) {
			playerIndex = 1;
		} else if (x < width/2 && y >= height/2) {
			playerIndex = 2;
		} else {
			playerIndex = 3;
		}
		if (!isActive()) {
			if (scores[playerIndex] > 0) { 
				scores[playerIndex] -= 1;
			}
			return false;
		} else {
			int newDelta = rGen.nextInt(1000*2) + 1000;
			Date date = new java.util.Date();
			lastTimeScheduled = date.getTime() + newDelta;
			scores[playerIndex] += 1;
			return true;
		}
	}


	@Override
	public int[] getScores() {
		return scores;
	}


	@Override
	public boolean isActive() {
		Date date = new java.util.Date();
		if (date.getTime() < lastTimeScheduled) {
			return false;
		} else {
			return true;
		}
	}
	
	public int [] getDimensions() {
		return new int [] {width, height};
	}
}
