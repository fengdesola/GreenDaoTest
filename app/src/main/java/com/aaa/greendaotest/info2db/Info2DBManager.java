package com.aaa.greendaotest.info2db;

import android.support.annotation.NonNull;

import com.aaa.greendaotest.App;
import com.aaa.greendaotest.dbhelper.DatabaseManager;
import com.aaa.greendaotest.dbhelper.base.DataBaseHelper;

public class Info2DBManager extends DatabaseManager {

    private static class Holder {
        private static Info2DBManager singleton = new Info2DBManager(new Info2DbHelper(App.getAppContext()));

    }


    public static Info2DBManager getInstance(){
        return Holder.singleton;
    }
    
    private Info2DBManager(@NonNull DataBaseHelper dataBaseHelper) {
        super(dataBaseHelper);
    }
}
