package com.aaa.greendaotest;

import android.content.Context;

public class App {
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    public static void init(Context appContext) {
        App.appContext = appContext;
    }
    
}
