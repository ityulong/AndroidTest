package xaircraft.androidtest.TestFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xaircraft.androidtest.R;

/**
 * Created by chenyulong on 15/11/12.
 */
public class FragmentOne extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        view.findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTwo fragmentTwo = new FragmentTwo();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragmentTwo, "fragmentTwo")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
