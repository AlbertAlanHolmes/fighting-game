package com.mypro.model;

import com.mypro.base.graphics.Bitmap;

public class BackGround extends DrawableAdapter{
	private Bitmap background;
	public void setCurrentPic(Bitmap background){
		this.background = background;
	}
	
	public Bitmap getCurrentPic() {
		return background;
	}

	public int getPicWidth() {
		return background.getWidth();
	}

	public int getPicHeight() {
		return background.getHeight();
	}

}
