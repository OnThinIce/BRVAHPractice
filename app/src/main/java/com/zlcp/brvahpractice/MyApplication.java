package com.zlcp.brvahpractice;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zlcp.brvahpractice.util.Utils;

/**
 * 作者：zl_freedom
 * 时间：2019/9/2 18:19
 * Note：
 */
public class MyApplication extends Application {
    private static MyApplication appContext;
    public static MyApplication getInstance(){
        return appContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Utils.init(this);
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }
    }
}
