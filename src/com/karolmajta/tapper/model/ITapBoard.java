package com.karolmajta.tapper.model;

public interface ITapBoard {
	public boolean tap(float x, float y);
	public int [] getScores();
	public boolean isActive();
	public int[] getDimensions();
}
