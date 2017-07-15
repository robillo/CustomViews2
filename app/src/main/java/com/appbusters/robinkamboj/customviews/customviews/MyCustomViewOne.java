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
import android.view.View;

import com.appbusters.robinkamboj.customviews.R;

public class MyCustomViewOne extends View{

    private static final int SQUARE_SIZE = 100;
    private Rect mRectSquare;
    private Paint mPaintSquare, mPaintCircle;
    private int mSquareSize;
    private int mSquareColor;

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

        float cx, cy, radius;
        radius = 100f;
        cx = getWidth() - radius - 50f;
        cy = mRectSquare.top + (mRectSquare.height()/2);

        canvas.drawRect(mRectSquare, mPaintSquare);
        canvas.drawCircle(cx, cy, radius, mPaintCircle);
    }
}
