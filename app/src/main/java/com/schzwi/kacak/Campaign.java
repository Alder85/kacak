package com.schzwi.kacak;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class Campaign extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new KacakView(this));
    }

}

class KacakView extends View {

    private Drawable playerImage;
    private float currPosX;
    private float currPosY;

    private float mLastTouchX;
    private float mLastTouchY;

    private int offFactor = 5;
    private int speed = 5;

    private int wallLeft = 250;
    private int wallRight = 750;
    private int wallTop = 500;
    private int wallBottom = 1000;

    private int playerSize = 50;
    public KacakView(Context context) {
        this(context, null, 0);

        playerImage = getResources().getDrawable(R.drawable.ace_of_spades);
        playerImage.setBounds(0, 0, playerSize, playerSize);
    }

    public KacakView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final float x = ev.getX();
        final float y = ev.getY();
        mLastTouchX = x;
        mLastTouchY = y;
        invalidate();

        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();



        Paint red = new Paint();
        red.setColor(Color.BLUE);
        canvas.drawRect(wallLeft, wallTop, wallRight, wallBottom, red);

        updatePlayerPos(canvas);

    }


    public void updatePlayerPos(Canvas canvas) {
        Rect potatoeImageBounds = playerImage.getBounds();
        currPosX = potatoeImageBounds.left;
        currPosY = potatoeImageBounds.top;
        int x = (int)currPosX;
        int y = (int)currPosY;
        if(x < mLastTouchX - offFactor)
            x += speed;
        if(x > mLastTouchX + offFactor)
            x -= speed;
        if(y < mLastTouchY - offFactor)
            y += speed;
        if(y > mLastTouchY + offFactor)
            y -= speed;

       // x = fixX(x, y);
       // y = fixY(x, y);
        playerImage.draw(canvas);
        playerImage.setBounds(x, y, x + playerSize, y + playerSize);
        canvas.restore();

        currPosX = x;
        currPosY = y;
    }
    /*
    public boolean inWall(int x, int y) {
        if(x > wallLeft && x < wallRight && y > wallTop && y < wallBottom)
            return true;
        return false;
    }
    public int fixX(int x, int y) {
        if(inWall(x, y)) {
            if(y > wallTop + 10 || y < wallBottom - 10) {
                fixY(x, y);
                return x;
            }
            int half = wallRight - wallLeft;
            if(x < half)
                x = wallLeft - 1;
            else
                x = wallRight + 1;
            return x;
        }
        return x;
    }

    public int fixY(int x, int y) {
        if(inWall(x, y)) {
            int half = wallBottom - wallTop;
            if(y < half)
                y = wallTop - 1;
            else
                y = wallBottom + 1;
            return y;
        }
        return y;
    }
     */
}