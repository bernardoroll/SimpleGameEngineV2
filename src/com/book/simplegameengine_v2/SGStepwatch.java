package com.book.simplegameengine_v2;

import android.os.SystemClock;

public class SGStepwatch 
{
	protected long		mCurrentTime;
	protected long		mLastTime;
	protected float		mTimeElapsed;
	
	protected float tick() 
	{
		if(mCurrentTime == 0) 
		{
			mLastTime = mCurrentTime = SystemClock.uptimeMillis();
		}
		else 
		{
	    	mCurrentTime = SystemClock.uptimeMillis();
		}
		
		mTimeElapsed = (mCurrentTime - mLastTime) / 1000.0f;
		mLastTime = mCurrentTime;
		
		return mTimeElapsed;
	}

}
