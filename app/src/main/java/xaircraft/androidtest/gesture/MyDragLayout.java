package xaircraft.androidtest.gesture;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import xaircraft.androidtest.R;

/**
 * Created by chenyulong on 16/6/23.
 */
public class MyDragLayout extends LinearLayout {
    private ViewDragHelper mViewDragHelper;
    private View mDragView1;
    private View mDragView2;
    public MyDragLayout(Context context) {
        this(context,null);
    }

    public MyDragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mDragView1 = findViewById(R.id.v_dragView1);
        mDragView2 = findViewById(R.id.v_dragView2);
    }

    public MyDragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return (child == mDragView1 || child == mDragView2);
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                final int leftBound = getPaddingLeft();
                final int rightPadding = getPaddingRight();
                final int rightBound = getWidth() - mDragView1.getWidth() - rightPadding;
                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
                Log.i("drag","left:" + left);
                return newLeft;
//                Log.i("drag","left:" + left);
//                return left;

            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                int topBound = getPaddingTop();
                int bottomPadding = getPaddingBottom();
                int bottomBound = getHeight() - mDragView1.getHeight() - bottomPadding;
                int newTop = Math.max(Math.min(bottomBound, top), topBound);
                Log.i("drag","top:" + top);
                return newTop;
            }

            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                super.onEdgeTouched(edgeFlags, pointerId);
                Log.i("edge","touch edge listener");
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                super.onEdgeDragStarted(edgeFlags, pointerId);
                mViewDragHelper.captureChildView(mDragView1, pointerId);
            }
        });
        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mViewDragHelper.processTouchEvent(ev);
        return true;
    }
}
