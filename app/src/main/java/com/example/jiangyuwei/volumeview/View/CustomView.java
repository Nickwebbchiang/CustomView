package com.example.jiangyuwei.volumeview.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.jiangyuwei.volumeview.R;

/**
 * Created by jiangyuwei on 16/4/11.
 */
public class CustomView extends View {
    private int firstColor;
    private int secondColor;
    private int circleWidth;
    private int count;
    private int splitSize;
    private int currentCount;
    private Paint mPaint;
    private float xDown;
    private float xUp;
    private int center;
    private int radius;
    public CustomView(Context context, AttributeSet attrs){
        super(context,attrs,0);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView,0,0);
        int n = a.getIndexCount();
        for (int i=0;i<n;i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomView_firstColor:
                    firstColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.CustomView_secondColor:
                    secondColor = a.getColor(attr,Color.BLUE);
                    break;
                case R.styleable.CustomView_circleWidth:
                    circleWidth = a.getDimensionPixelSize(attr,(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomView_account:
                    count = a.getInt(attr,10);
                    break;
                case R.styleable.CustomView_splitSize:
                    splitSize = a.getInt(attr,10);
            }
        }
        a.recycle();
        mPaint = new Paint();
    }
    @Override
    public void onDraw(Canvas canvas){
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(circleWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        center = getWidth()/2;
        radius = center - circleWidth/2;
        drawOval(canvas,center,radius);


    }
    private void drawOval(Canvas canvas,int center,int radius){
        float itemSize = (360*1.0f-count*splitSize)/count;
        RectF oval = new RectF(center -radius,center-radius,center+radius,center+radius);
        mPaint.setColor(firstColor);
        for (int i=0;i<count;i++){
            canvas.drawArc(oval,i*(itemSize+splitSize),itemSize,false,mPaint);
        }
        mPaint.setColor(secondColor);
        for(int i=10;i<currentCount+10;i++){
            canvas.drawArc(oval,i*(itemSize+splitSize),itemSize,false,mPaint);
            if (currentCount==20){
                Toast.makeText(getContext(),"Already the Most",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void up(){
        currentCount++;
        invalidate();
    }
    public void down(){
        currentCount--;
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                xDown = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                xUp = event.getY();
                if (xUp>xDown){
                    down();
                }else{
                    up();
                }
        }
        return true;
    }
}
