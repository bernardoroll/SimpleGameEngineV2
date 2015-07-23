package com.book.simplegameengine_v2;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;

public class SGEntity {
	
	public enum DebugDrawingStyle {
		FILLED,
		OUTLINE
	}
	
	private String mCategory;
	protected int mDebugColor = Color.RED;
	private DebugDrawingStyle mDebugDrawingStyle = DebugDrawingStyle.FILLED;
	protected PointF mDimensions = new PointF();
	private int mId;
	private boolean mIsActive = true;
	protected PointF mPosition= new PointF();
	private SGWorld mWorld;
	
	protected RectF mBBoxPadding = new RectF();
	protected RectF mBoundingBox = new RectF();
	
	public SGEntity(SGWorld world, int id, String category, PointF position, PointF dimensions) {
		mWorld = world;
		mId = id;
		mCategory = category;
		mPosition.set(position);
		mDimensions.set(dimensions);
		_updateBoundingBox();
	}
	
	public SGEntity(PointF position, PointF dimensions) {
		mPosition.set(position);
		mDimensions.set(dimensions);
		_updateBoundingBox();
	}
	
	public void move(float offsetX, float offsetY) {
		mPosition.x += offsetX;
		mPosition.y += offsetY;
		_updateBoundingBox();
	}
	
	public void step(float elapsedTimeInSeconds) { }
	
	public String getCategory() {
		return mCategory;
	}
	
	public int getDebugColor() {
		return mDebugColor;
	}
	
	public DebugDrawingStyle getDebugDrawingStyle() {
		return mDebugDrawingStyle;
	}
	
	public PointF getDimensions() {
		return mDimensions;
	}
	
	public int getId() {
		return mId;
	}
	
	public PointF getPosition() {
		return mPosition;
	}
	
	public SGWorld getWorld() {
		return mWorld;
	}
	
	public boolean isActive() {
		return mIsActive;
	}
	
	public void setDebugColor(int color) {
		mDebugColor = color;
	}
	
	public void setDebugDrawingStyle(DebugDrawingStyle drawingStyle) {
		mDebugDrawingStyle = drawingStyle;
	}
	
	public void setDimensions(float x, float y) {
		mDimensions.set(x, y);
	}
	
	public void setDimensions(PointF dimensions) {
		mDimensions.set(dimensions);;
	}
	
	public void setIsActive(boolean isActive) {
		mIsActive = isActive;
	}
	
	public void setPosition(float x, float y) {
		mPosition.set(x, y);
		_updateBoundingBox();
	}
	
	public void setPosition(PointF position) {
		mPosition.set(position);
		_updateBoundingBox();
	}
	
	private void _updateBoundingBox() {
		mBoundingBox.set(mPosition.x + mBBoxPadding.left, mPosition.y + mBBoxPadding.top, 
				(mPosition.x + mDimensions.x) - mBBoxPadding.right, 
				(mPosition.y + mDimensions.y) - mBBoxPadding.bottom);
	}
	
	public void setBBoxPadding(RectF padding) {
		mBBoxPadding.set(padding);
		_updateBoundingBox();
	}
	
	public RectF getBoundingBox() {
		return mBoundingBox;
	}
	
	public RectF getBBoxPadding() {
		return mBBoxPadding;
	}
	
	public boolean colisionTest(RectF r2) {		
		return mWorld.collisionTest(mBoundingBox, r2);		
	}

}
