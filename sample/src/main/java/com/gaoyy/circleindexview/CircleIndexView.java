package com.gaoyy.circleindexview;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;


/**
 * Created by gaoyy on 2016/9/28 0028.
 */
public class CircleIndexView extends View
{
    private static final String TAG = "CircleIndexView";

    //（灰）外圈画笔
    private Paint outPaint = new Paint();
    //（绿）内圈画笔
    private Paint inPaint = new Paint();
    //文字画笔
    private Paint middleTextPaint = new Paint();
    //外切矩形
    private RectF mRectF;

    //圆初始弧度
    private float startAngle = 135;
    //圆结束弧度
    private float sweepAngle = 270;

    int mCenter = 0;
    int mRadius = 0;

    private int pmValue;
    private String middleText = "N/A";
    private String bottomText = "";
    private int pmWidth;
    private int pmHeight;
    private float inSweepAngle;

    private float numberTextSize;
    private float middleTextSize;
    private float bottomTextSize;

    public float getNumberTextSize()
    {
        return numberTextSize;
    }

    public void setNumberTextSize(float numberTextSize)
    {
        this.numberTextSize = numberTextSize;
    }

    public float getMiddleTextSize()
    {
        return middleTextSize;
    }

    public void setMiddleTextSize(float middleTextSize)
    {
        this.middleTextSize = middleTextSize;
    }

    public float getBottomTextSize()
    {
        return bottomTextSize;
    }

    public void setBottomTextSize(float bottomTextSize)
    {
        this.bottomTextSize = bottomTextSize;
    }

    public String getMiddleText()
    {
        return middleText;
    }

    public void setMiddleText(String middleText)
    {
        this.middleText = middleText;
    }

    public int getPmValue()
    {
        return pmValue;
    }

    public void setPmValue(int pmValue)
    {
        this.pmValue = pmValue;
    }

    public int getPmWidth()
    {
        return pmWidth;
    }

    public void setPmWidth(int pmWidth)
    {
        this.pmWidth = pmWidth;
    }

    public int getPmHeight()
    {
        return pmHeight;
    }

    public void setPmHeight(int pmHeight)
    {
        this.pmHeight = pmHeight;
    }

    public float getInSweepAngle()
    {
        return inSweepAngle;
    }

    public void setInSweepAngle(float inSweepAngle)
    {
        this.inSweepAngle = inSweepAngle;
    }

    public String getBottomText()
    {
        return bottomText;
    }

    public void setBottomText(String bottomText)
    {
        this.bottomText = bottomText;
    }

    public CircleIndexView(Context context)
    {
        super(context);
        initPaint();
    }

    public CircleIndexView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initPaint();
        initParams(context, attrs);
    }

    public CircleIndexView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initPaint();
        initParams(context, attrs);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleIndexView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
        initParams(context, attrs);
    }

    /**
     * 初始化画笔
     */
    public void initPaint()
    {
        Log.i(TAG, "=====initPaint======");
        outPaint.setColor(getResources().getColor(R.color.circleindexview_out_gray));
        outPaint.setAntiAlias(true);
        outPaint.setStyle(Paint.Style.STROKE);
        outPaint.setStrokeCap(Paint.Cap.ROUND);
        outPaint.setStrokeWidth(12);

        inPaint.setColor(getResources().getColor(R.color.circleindexview_in_green));
        inPaint.setAntiAlias(true);
        inPaint.setStyle(Paint.Style.STROKE);
        inPaint.setStrokeCap(Paint.Cap.ROUND);
        inPaint.setStrokeWidth(12);

        middleTextPaint = new Paint();
        middleTextPaint.setTextAlign(Paint.Align.CENTER);
        middleTextPaint.setAntiAlias(true);
    }

    /**
     * 初始化View参数
     *
     * @param context
     * @param attrs
     */
    private void initParams(Context context, AttributeSet attrs)
    {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.circleindexview);
        middleText = ta.getString(R.styleable.circleindexview_middleText);
        bottomText = ta.getString(R.styleable.circleindexview_bottomText);
        middleTextSize = ta.getFloat(R.styleable.circleindexview_middleTextSize, 0.0f);
        bottomTextSize = ta.getFloat(R.styleable.circleindexview_middleTextSize, 0.0f);
        numberTextSize = ta.getFloat(R.styleable.circleindexview_numberTextSize, 0.0f);
        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Log.i(TAG, "===onDraw===");
        super.onDraw(canvas);

        mCenter = getPmWidth() / 2;
        mRadius = getPmWidth() / 2 - 50;

        Log.i(TAG, "mCenter：" + mCenter);
        Log.i(TAG, "mRadius：" + mRadius);

        mRectF = new RectF(mCenter - mRadius, mCenter - mRadius, mCenter
                + mRadius, mCenter + mRadius);

        Log.i(TAG, "x：" + (mCenter - mRadius) + "   x : " + (mCenter - mRadius) + "   y : " + (mCenter
                + mRadius) + "  y : " + (mCenter + mRadius));

        //外圆圈
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, outPaint);
        //内圆圈
        canvas.drawArc(mRectF, 135, getInSweepAngle(), false, inPaint);

        //中心数字
        middleTextPaint.setColor(getResources().getColor(R.color.circleindexview_in_green));
        middleTextPaint.setTextSize(getNumberTextSize());
        canvas.drawText(getPmValue() + "", getPmWidth() / 2, getPmHeight() / 2, middleTextPaint);

        //中心文字(etc. Pm25)
        middleTextPaint.setColor(getResources().getColor(R.color.circleindexview_sub_gray));
        middleTextPaint.setTextSize(getMiddleTextSize());
        canvas.drawText(getMiddleText(), getPmWidth() / 2, getPmHeight() / 2 + 40, middleTextPaint);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec)
    {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        switch (specMode)
        {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                result = 200;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(result, specSize);
                break;
        }
        setPmWidth(result);
        Log.e(TAG, "measureWidth===" + getPmWidth());
        return result;
    }

    private int measureHeight(int heightMeasureSpec)
    {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (specMode)
        {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                result = 200;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(result, specSize);
                break;
        }
        setPmHeight(result);
        Log.e(TAG, "measureHeight===" + getPmHeight());
        return result;
    }

    public void updateIndex(int value)
    {
        float inSweepAngle = sweepAngle * value / 100;
        ValueAnimator angleAnim = ValueAnimator.ofFloat(0f, inSweepAngle);
        ValueAnimator valueAnim = ValueAnimator.ofInt(0, value);
        angleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator)
            {
                float currentValue = (float) valueAnimator.getAnimatedValue();
                setInSweepAngle(currentValue);
                invalidate();
            }
        });
        valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator)
            {
                int currentValue = (int) valueAnimator.getAnimatedValue();
                setPmValue(currentValue);
                invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setStartDelay(150);
        animatorSet.playTogether(angleAnim, valueAnim);
        animatorSet.start();
    }
}
