package com.youche.ycsaas.app;

import android.app.Application;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc
 */

public class App extends Application {
    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

    public static App getAppContext() {
        return sApp;
    }
}
