package xaircraft.androidtest.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenyulong on 16/5/27.
 */
public class MyCustomView extends View {
    private final static int defaultWidth = 500;
    private final static int defaultHeight = 500;

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCustomView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }
    private int measureWidth(int widthMeasureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        switch (specMode){
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                result = Math.min(defaultWidth, specSize);
                break;
        }
        return result;

    }
    private int measureHeight(int hegihtMeasureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(hegihtMeasureSpec);
        int specSize = MeasureSpec.getSize(hegihtMeasureSpec);
        switch (specMode){
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                result = Math.min(defaultHeight, specSize);
                break;
        }
        return result;
    }
}
