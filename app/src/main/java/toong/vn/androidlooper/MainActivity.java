package toong.vn.androidlooper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SampleLooper sampleLooper = new SampleLooper();
        sampleLooper.start();
        findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    final int finalI = i;
                    sampleLooper.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(Thread.currentThread().getName(), "start run: " + finalI);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i(Thread.currentThread().getName(), "finished run: " + finalI);
                        }
                    });
                }
            }
        });

        findViewById(R.id.button_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // currently when use it, it will throw InterruptedException
                //                sampleLooper.interrupt();
            }
        });

        findViewById(R.id.button_start_second_activity).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //                a.interrupt();
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        finish();
                    }
                });
    }
}
