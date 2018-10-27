package com.mypro.model;

import com.mypro.base.graphics.Bitmap;

/**
 * ���
 */
public class Gold extends DrawableAdapter{
	private Bitmap[] gold;
	private int currentPicId;
	//�Ƿ񲥷Ž�Ҷ���
	private boolean playGoldPicAct;
	/**
	 * ��ҵĶ����߳�
	 */
	private Runnable goldActThread; 
	public Gold(Bitmap[] gold){
		this.gold = gold;
	}
	public void setCurrentPicId(int currentPicId){
		this.currentPicId = currentPicId;
	}
	public int getPicLength() {
		return gold.length;
	}
	
	public Bitmap getCurrentPic() {
		return gold[currentPicId];
	}

	public int getPicWidth() {
		return getCurrentPic().getWidth();
	}

	public int getPicHeight() {
		return getCurrentPic().getHeight();
	}
	public Runnable getGoldActThread() {
		return goldActThread;
	}
	public void setGoldActThread(Runnable goldActThread) {
		this.goldActThread = goldActThread;
	}
	public boolean isPlayGoldPicAct() {
		return playGoldPicAct;
	}
	public void setPlayGoldPicAct(boolean playGoldPicAct) {
		this.playGoldPicAct = playGoldPicAct;
	}
	
}