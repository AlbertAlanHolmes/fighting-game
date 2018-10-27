package com.mypro.model;

import com.mypro.base.graphics.Canvas;
import com.mypro.base.graphics.Matrix;
import com.mypro.base.graphics.Paint;
import com.mypro.basecomponet.JMatrix;
import com.mypro.model.interfaces.Drawable;

public abstract class DrawableAdapter implements Drawable{
	private Matrix matrix = new JMatrix();
	
	public Matrix getPicMatrix() {
		return matrix;
	}

	public void onDraw(Canvas canvas, Paint paint) {
		canvas.drawBitmap(this.getCurrentPic(),
				this.getPicMatrix(), paint);		
	}

	
}
