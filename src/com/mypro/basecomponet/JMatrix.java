package com.mypro.basecomponet;

import java.awt.geom.AffineTransform;

import com.mypro.base.graphics.Matrix;

public class JMatrix implements Matrix{
	public AffineTransform trans = new AffineTransform();
	public void reset() {
	
	}

	public void setTranslate(float x, float y) {		
		trans.setToTranslation(x, y);
	}

	public void preScale(float x, float y) {
		trans.scale(x, y);
		
	}

	public void preRotate(float angle, float x, float y) {
		trans.rotate(Math.toRadians(angle), x, y);
		
	}

}
