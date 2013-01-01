package com.karolmajta.tapper.painter;

import processing.core.PApplet;

import com.karolmajta.tapper.model.ITapBoard;

public class FourPlayerBoardPainter implements IBoardPainter {

	@Override
	public void paint(PApplet p, ITapBoard board) {
		int w = board.getDimensions()[0];
		int h = board.getDimensions()[1];

		// draw line
		p.stroke(0xffededed);
		p.strokeWeight(3);
		p.line(0, h/2, w, h/2);
		p.line(w/2, 0, w/2, h);
		// draw circle
		p.fill(0xff000000);
		p.ellipse(w/2, h/2, PApplet.min(w,h)/5+20, PApplet.min(w,h)/5+20);
		// draw scores
		p.fill(0xffededed);
		p.textAlign(PApplet.CENTER);
		p.textSize(32);
		p.fill(0xff33DAFD);
		p.text(Integer.toString(board.getScores()[0]), w/4, h/4);
		p.fill(0xffF012BD);
		p.text(Integer.toString(board.getScores()[1]), 3*w/4, h/4);
		p.fill(0xffFFFF66);
		p.text(Integer.toString(board.getScores()[2]), w/4, 3*h/4);
		p.fill(0xff9999FF);
		p.text(Integer.toString(board.getScores()[3]), 3*w/4, 3*h/4);
		// draw green circle if board is ready for tapping
		if (board.isActive()) {
			p.noStroke();
			p.fill(0xff00ff00);
			p.ellipse(
				(float)w/2,
				(float)h/2,
				(float)PApplet.min(w,h)/5,
				(float)PApplet.min(w,h)/5
			);
		}
	}

}
