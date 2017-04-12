package xaircraft.androidtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.View;

/**
 * Created by chenyulong on 15/11/5.
 */
public class ProgressPie extends View {

    private int mMax;
    private int mProgress;

    private boolean mShowText;
    private int mTextSize = 15;
    private int mTextColor = Color.BLACK;
    private int mTextPosition = POSITION_CENTER;

    private int mColor;
    private boolean mShowBorder;
    private int mBorderColor;

    public static final int POSITION_LEFT = 1;
    public static final int POSITION_CENTER = 2;
    public static final int POSITION_RIGHT = 3;


    private TextPaint mTextPaint;
    private Paint mPiePaint;

    private int width;
    private int height;
    private RectF rectF = new RectF();
    private Rect mBounds = new Rect();


    public ProgressPie(Context context) {
        this(context, null);
    }

    public ProgressPie(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressPie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProgressPie, 0, 0);
        try {
            mMax = typedArray.getInteger(R.styleable.ProgressPie_max, 100);
            mProgress = typedArray.getInteger(R.styleable.ProgressPie_progress, 0);
            if (mProgress > mMax) {
                mProgress = mMax;
            }
            mShowText = typedArray.getBoolean(R.styleable.ProgressPie_showText, false);
            if (mShowText) {
                mTextSize = typedArray.getInteger(R.styleable.ProgressPie_textSize, 15);
                mTextColor = typedArray.getColor(R.styleable.ProgressPie_textColor, Color.BLACK);
                mTextPosition = typedArray.getInteger(R.styleable.ProgressPie_textPosition, POSITION_CENTER);
            }
            mColor = typedArray.getColor(R.styleable.ProgressPie_color, Color.BLUE);
            mShowBorder = typedArray.getBoolean(R.styleable.ProgressPie_showBorder, true);
            if (mShowBorder) {
                mBorderColor = typedArray.getColor(R.styleable.ProgressPie_borderColor, Color.GRAY);
            }


        }finally {
            typedArray.recycle();
        }
        init();
    }

    private void init() {
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);

        mPiePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int mWidthSize = MeasureSpec.getSize(widthMeasureSpec);

        int mHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int mHeightSize = MeasureSpec.getSize(heightMeasureSpec);

        int lastWidth = 0;
        int lastHeight = 0;

        if (mWidthMode == MeasureSpec.EXACTLY) {
            lastWidth = mHeightSize;
        }else {
            CharSequence str = String.valueOf(mMax);
            lastWidth = getTextSize(str,mTextPaint) << 1;
        }
        lastHeight = lastWidth;

        if (width > 0) {
            this.width = lastWidth;
            this.height = lastHeight;
            rectF.set(0f, 0f, width, height);
        }
        setMeasuredDimension(lastWidth,lastHeight);
    }

    private int getTextSize(CharSequence str, TextPaint mTextPaint) {
        mTextPaint.getTextBounds(str.toString(), 0, str.length(), mBounds);
        return mBounds.width();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPiePaint.setColor(mColor);
        mPiePaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, 180, 360 * getmProgress() / getmMax(), true, mPiePaint);
        if (mShowBorder) {
            mPiePaint.setColor(mBorderColor);
            mPiePaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, 180, 360*getmProgress()/getmMax(), true, mPiePaint );
        }
        if ( mShowText ) {
            String text = String.valueOf(getmProgress());
            mTextPaint.getTextBounds(text, 0, text.length(), mBounds);
            int textWidth = mBounds.width();
            int textHeight = mBounds.height();
            switch (mTextPosition) {
                case POSITION_LEFT:
                    canvas.drawText(text, width/2 - textWidth, height/2 + textHeight/2, mTextPaint);
                    break;
                case POSITION_CENTER:
                    canvas.drawText(text, width/2 - textWidth/2, height/2 + textHeight/2, mTextPaint);
                    break;
                case POSITION_RIGHT:
                    canvas.drawText(text, width/2, height/2 + textHeight/2, mTextPaint);
                    break;
            }
        }
    }

    public int getmMax() {
        return mMax;
    }

    public void setmMax(int mMax) {
        this.mMax = mMax;
    }

    public int getmProgress() {
        return mProgress;
    }

    public void setmProgress(int mProgress) {
        this.mProgress = mProgress;
    }

    public int getmTextSize() {
        return mTextSize;
    }

    public void setmTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getmTextPosition() {
        return mTextPosition;
    }

    public void setmTextPosition(int mTextPosition) {
        this.mTextPosition = mTextPosition;
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    public int getmBorderColor() {
        return mBorderColor;
    }

    public void setmBorderColor(int mBorderColor) {
        this.mBorderColor = mBorderColor;
    }
}
