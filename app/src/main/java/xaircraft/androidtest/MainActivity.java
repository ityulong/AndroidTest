package xaircraft.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import xaircraft.androidtest.Theme.MyInflaterFactory;

public class MainActivity extends Activity {

    private Button btnFindUfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater();
        MyInflaterFactory factory = new MyInflaterFactory();
        inflater.setFactory(factory);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_custom_seekbar);
        btnFindUfo = (Button)findViewById(R.id.btn_find_ufo);
        btnFindUfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,getString(R.string.find_ufo),Toast.LENGTH_LONG).show();
            }
        });
    }
}
