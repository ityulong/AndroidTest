package xaircraft.androidtest.gesture;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import xaircraft.androidtest.R;

/**
 * Created by chenyulong on 16/6/23.
 */
public class GestureActivity extends Activity implements View.OnTouchListener,GestureDetector.OnGestureListener {
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_gesture);
        detector = new GestureDetector(this);
        findViewById(R.id.tv_test_gesture).setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return detector.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        Log.i("MyGesture", "onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i("MyGesture", "onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("MyGesture", "onSingleTapUp");

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("MyGesture", "onScroll");

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i("MyGesture", "onLongPress");


    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("MyGesture", "onFling");

        return false;
    }

}
