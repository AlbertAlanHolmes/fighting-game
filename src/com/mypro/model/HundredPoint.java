package com.mypro.model;

import com.mypro.base.graphics.Bitmap;
/**
 * ∏ﬂ∑÷œ‘ æ
 */
public class HundredPoint extends DrawableAdapter{
	private Bitmap[] imgs;
	private int currentPicId;
	public HundredPoint(Bitmap[] imgs){
		this.imgs = imgs;
	}
	public int getActPicLength(){
		return imgs.length;
	}
	public void setCurrentPicId(int currentPicId){
		this.currentPicId = currentPicId;
	}
	
	public Bitmap getCurrentPic() {
		return imgs[currentPicId];
	}

	public int getPicWidth() {
		return getCurrentPic().getWidth();
	}

	public int getPicHeight() {
		return getCurrentPic().getHeight();
	}

}
