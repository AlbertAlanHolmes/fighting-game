package com.mypro.model;

import com.mypro.base.graphics.Bitmap;

/**
 * Ë®²¨ÎÆ
 */
public class WaterRipple extends DrawableAdapter{
	private Bitmap[] ripple;
	private int currentId;
	public WaterRipple(Bitmap[] ripple){
		this.ripple = ripple;
	}
	
	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}

	public Bitmap getCurrentPic() {
		return ripple[currentId];
	}

	public int getPicWidth() {
		return getCurrentPic().getWidth();
	}

	public int getPicHeight() {
		return getCurrentPic().getHeight();
	}

}
