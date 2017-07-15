package com.appbusters.robinkamboj.customviews.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomViewOne extends View{

    private static final int SQUARE_SIZE = 100;
    private Rect mRectSquare;
    private Paint mPaintSquare;

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
        mPaintSquare = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mRectSquare.left = 10;
        mRectSquare.top = 10;
        mRectSquare.right = mRectSquare.left + SQUARE_SIZE;
        mRectSquare.bottom = mRectSquare.top + SQUARE_SIZE;

        mPaintSquare.setColor(Color.GREEN);

        canvas.drawRect(mRectSquare, mPaintSquare);
    }
}
