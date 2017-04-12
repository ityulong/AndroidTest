package xaircraft.androidtest.TestFragment;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;

import xaircraft.androidtest.R;
import xaircraft.androidtest.TestFragment.model.GpsMsg;

public class ThreadActivity extends Activity {
    private TextView tvBattery;
    private static Handler handler=new Handler();
    private GpsMsg msg;
    private int i = 0;
    private int m = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        msg = new GpsMsg();
        tvBattery = (TextView) findViewById(R.id.tv_system_battery);
        Thread batteryThread = new Thread(new BatteryRunnable());
        batteryThread.start();
        Thread idThread = new Thread(new IdRunnable());
        idThread.start();

        Thread getDataThread = new Thread(new GetDataRunnable());
        getDataThread.start();
    }

    public class BatteryRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                msg.setGpsName("第" + i + "个信息");
//                tvBattery.setText(i + "");
                System.out.println("m count:" + i);
            }
        }
    }

    public class IdRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                m++;
                msg.setId(m + "");
//                tvBattery.setText(i + "");
                System.out.println("m count:" + m);
            }
        }
    }

    public class GetDataRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvBattery.setText(msg.toString());
                    }
                });
//                tvBattery.setText(i + "");
                System.out.println("count:" + i);
            }
        }
    }

}
