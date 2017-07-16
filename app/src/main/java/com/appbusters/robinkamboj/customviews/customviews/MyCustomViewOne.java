package com.appbusters.robinkamboj.customviews.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import com.appbusters.robinkamboj.customviews.R;

public class MyCustomViewOne extends View{

    private static final int SQUARE_SIZE = 100;
    private Rect mRectSquare;
    private Paint mPaintSquare, mPaintCircle;
    private int mSquareSize;
    private int mSquareColor;
    private float mCircleX, mCircleY, mCircleRadius = 100f;
    boolean mDownTouch = false;

    public MyCustomViewOne(Context context) {
        super(context);

        init(null);
    }

    public MyCustomViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public MyCustomViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    @SuppressLint("NewApi")
    public MyCustomViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    /****************************************************************************/

    private void init(@Nullable AttributeSet set){
        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setColor(Color.DKGRAY);

        if(set == null)
            return;

        TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.MyCustomViewOne);
        mSquareSize = typedArray.getDimensionPixelSize(R.styleable.MyCustomViewOne_square_size, mSquareSize);
        mSquareColor = typedArray.getColor(R.styleable.MyCustomViewOne_square_color, Color.GREEN);
        typedArray.recycle();

        mPaintSquare.setColor(mSquareColor);
    }

    public void swapColor(){
        mPaintSquare.setColor(mPaintSquare.getColor() == mSquareColor ? Color.DKGRAY : mSquareColor);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;

        if(mCircleX == 0f || mCircleY == 0f){
            mCircleX = getWidth()/2;
            mCircleY = getHeight()/2;
        }

        canvas.drawRect(mRectSquare, mPaintSquare);
        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, mPaintCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mDownTouch = true;    //for accessibility
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
                float x,y;
                x = event.getX();
                y = event.getY();
                if(mRectSquare.left<x && mRectSquare.right>x){
                    if(mRectSquare.top<y && mRectSquare.bottom>y){
                        mCircleRadius+=10f;
                        postInvalidate();
                    }
                }

                return true;
            }
            case MotionEvent.ACTION_UP:{
                if(mDownTouch){
                    mDownTouch = false;
                    performClick(); // Call this method to handle the response, and
                    // thereby enable accessibility services to
                    // perform this action for a user who cannot
                    // click the touchscreen.
                    return true;
                }
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                double dx, dy;
                float x,y;
                x = event.getX();
                y = event.getY();

                dx = Math.pow(x - mCircleX, 2);
                dy = Math.pow(y - mCircleY, 2);
                if((dx + dy) < Math.pow(mCircleRadius, 2)){
                    //TOUCHED
                    mCircleX = x;
                    mCircleY = y;

                    postInvalidate();

                    return true;
                }

                return true;
            }
        }
        return value;
    }



    @Override
    public boolean performClick() {
        // Calls the super implementation, which generates an AccessibilityEvent
        // and calls the onClick() listener on the view, if any
        super.performClick();

        // Handle the action for the custom click here

        return true;
    }
}
