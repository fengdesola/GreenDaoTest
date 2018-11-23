package com.aaa.greendaotest;

import android.app.Application;

import com.aaa.greendaotest.info2db.Info2DBManager;
import com.aaa.greendaotest.infodb.InfoDBManager;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        
        App.init(this);

        InfoDBManager.getInstance();
        Info2DBManager.getInstance();
    }

}
