package xaircraft.androidtest.Animation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import xaircraft.androidtest.BaseActivity;
import xaircraft.androidtest.R;

public class AnimationActivity extends BaseActivity {

    private Button btnHide;
    private Button btnShow;
    private TextView tvAnimation;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_animation);
        btnHide = (Button) findViewById(R.id.btn_hide);
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float translation = tvAnimation.getTranslationY();
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimation, "translationY", translation, -tvAnimation.getHeight());
                animator.setDuration(1000);
                animator.start();
                Log.i("translation","translationY is:" + translation);

            }
        });
        btnShow = (Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float translation = tvAnimation.getTranslationY();
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimation, "translationY", translation, 0f);
                animator.setDuration(1000);
                animator.start();

            }
        });
        tvAnimation = (TextView) findViewById(R.id.tv_animation_test);
    }

    @Override
    protected void initData() {

    }


}
