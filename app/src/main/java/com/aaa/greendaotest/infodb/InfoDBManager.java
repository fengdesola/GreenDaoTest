package com.aaa.greendaotest.infodb;

import android.support.annotation.NonNull;

import com.aaa.greendaotest.App;
import com.aaa.greendaotest.dbhelper.DatabaseManager;
import com.aaa.greendaotest.dbhelper.base.DataBaseHelper;

public class InfoDBManager extends DatabaseManager {

    private static class Holder {
        private static InfoDBManager singleton = new InfoDBManager(new InfoDbHelper(App.getAppContext()));

    }


    public static InfoDBManager getInstance(){
        return Holder.singleton;
    }
    
    private InfoDBManager(@NonNull DataBaseHelper dataBaseHelper) {
        super(dataBaseHelper);
    }
}
