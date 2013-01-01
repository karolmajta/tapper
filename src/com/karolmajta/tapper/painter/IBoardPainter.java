package com.karolmajta.tapper.painter;

import processing.core.PApplet;

import com.karolmajta.tapper.model.ITapBoard;
import com.karolmajta.tapper.model.TwoPlayerBoard;

public interface IBoardPainter {

	public void paint(PApplet p,ITapBoard board);
	
}
