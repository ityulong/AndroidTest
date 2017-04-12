package xaircraft.androidtest.Listview;


import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import xaircraft.androidtest.BaseActivity;
import xaircraft.androidtest.R;

public class MyListViewActivity extends BaseActivity {
    private ListView mls;
    private MyAdapter mAdapter;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_listview);
        mls = (ListView) findViewById(R.id.ls_test);
    }

    @Override
    protected void initData() {
        List<String> mdata = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mdata.add("通道" + i);
        }
        mAdapter = new MyAdapter(this, mdata);
        mls.setAdapter(mAdapter);
    }
}
