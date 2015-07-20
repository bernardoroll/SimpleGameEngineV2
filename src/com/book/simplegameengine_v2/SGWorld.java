package com.book.simplegameengine_v2;

import android.graphics.Point;

public class SGWorld {
	
	private Point mDimensions;
	
	public SGWorld(Point worldDimensions) {
		mDimensions = new Point(worldDimensions);
	}
	
	public void step(float elapsedTimeInSeconds) { }
	
	public void setup() { }
	
	public Point getDimensions() { 
		return mDimensions;
	}

}
