package xaircraft.androidtest.Listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xaircraft.androidtest.R;

/**
 * Created by chenyulong on 16/5/30.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> mdata;
    private Context mContext;


    public MyAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mdata = data;
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolderView holderView = null;
        if (convertView == null) {
            holderView = new MyHolderView();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_myadapter, parent, false);
            holderView.mtv = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holderView);
        }else{
            holderView = (MyHolderView) convertView.getTag();
        }
        holderView.mtv.setText(mdata.get(position));
        return convertView;
    }

    public static class MyHolderView{
        public TextView mtv;
    }
}
