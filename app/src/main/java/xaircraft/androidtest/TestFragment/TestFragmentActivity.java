package xaircraft.androidtest.TestFragment;

import android.app.Activity;
import android.os.Bundle;

import xaircraft.androidtest.R;

/**
 * Created by chenyulong on 15/11/12.
 */
public class TestFragmentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.content, new FragmentOne(), "fragmentOne")
                .commit();
    }
}
