package toong.vn.androidlooper;

import android.os.Handler;
import android.os.Looper;

class SampleLooper extends Thread {
    private Handler handler;
    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler();
        Looper.loop();
    }

    public Handler getHandler() {
        return handler;
    }
}