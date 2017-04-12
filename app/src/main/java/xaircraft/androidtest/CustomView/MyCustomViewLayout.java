package xaircraft.androidtest.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenyulong on 16/7/11.
 */
public class MyCustomViewLayout extends ViewGroup {
    public MyCustomViewLayout(Context context) {
        this(context, null);
    }

    public MyCustomViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //当viewGroup为wrap_content的时候的长宽由子view的最大长宽和决定
        int wWidth = 0;
        int wHeight = 0;

        int lSize = 0;
        int rSize = 0;
        int tSize = 0;
        int bSize = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int cWidth = childView.getWidth();
            int cHeight = childView.getHeight();
            MarginLayoutParams cParam = (MarginLayoutParams) childView.getLayoutParams();

            if(i==0||i==1){
                tSize = tSize + cWidth + cParam.leftMargin + cParam.rightMargin;
            }
            if (i == 1 || i == 3) {
                rSize = rSize + cHeight + cParam.topMargin + cParam.bottomMargin;
            }
            if (i == 0 || i == 2) {
                lSize = lSize + cHeight + cParam.topMargin + cParam.bottomMargin;
            }
            if (i == 2 || i == 3) {
                bSize = bSize + cWidth + cParam.leftMargin + cParam.rightMargin;
            }
        }

        wWidth = Math.max(tSize, bSize);
        wHeight = Math.max(lSize, rSize);

        setMeasuredDimension(modeWidth == MeasureSpec.EXACTLY ? sizeWidth : wWidth,
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight: wHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int widthSize = 0;
        int heightSize = 0;
        MarginLayoutParams params = null;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            widthSize = childView.getWidth();
            heightSize = childView.getHeight();
            params = (MarginLayoutParams) childView.getLayoutParams();
            int top = 0;
            int left = 0;
            int right = 0;
            int bottom = 0;
            switch (i) {
                case 0:
                    top = params.topMargin;
                    left = params.leftMargin;
                    break;
                case 1:
                    top = params.topMargin;
                    left = getWidth() - widthSize - params.rightMargin;
                    break;
                case 2:
                    top = getHeight() - heightSize - params.bottomMargin;
                    left = params.leftMargin;
                    break;
                case 3:
                    top = getHeight() - heightSize - params.bottomMargin;
                    left = getWidth() - widthSize - params.rightMargin;
                    break;
            }
            right = left + widthSize;
            bottom = top + heightSize;
            childView.layout(left, top, right, bottom);
        }
    }



}
