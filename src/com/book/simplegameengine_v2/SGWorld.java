package com.book.simplegameengine_v2;

import android.graphics.Point;
import android.graphics.RectF;

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
	
	public boolean collisionTest(RectF R1, RectF R2) {
		return R1.left < R2.right &&
				R1.right > R2.left &&
				R1.top < R2.bottom &&
				R1.bottom > R2.top;
	}

}
