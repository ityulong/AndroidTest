package xaircraft.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.CheckBox;

import xaircraft.androidtest.TestFragment.FragmentOne;
import xaircraft.androidtest.Theme.MyInflaterFactory;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater();
        MyInflaterFactory factory = new MyInflaterFactory();
        inflater.setFactory(factory);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_custom_seekbar);
    }
}
