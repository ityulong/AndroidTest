package xaircraft.androidtest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by chenyulong on 16/5/30.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();
}
