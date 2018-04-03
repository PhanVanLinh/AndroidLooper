package toong.vn.androidlooper;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by PhanVanLinh on 02/04/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class AApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...

    }
}
