package com.aaa.greendaotest.dbhelper;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.aaa.greendaotest.greendao.DaoMaster;
import com.aaa.greendaotest.greendao.DaoSession;
import com.aaa.greendaotest.dbhelper.base.DataBaseHelper;



public abstract class DatabaseManager {
    private DataBaseHelper devOpenHelper;
    private SQLiteDatabase database;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public DatabaseManager(@NonNull DataBaseHelper dataBaseHelper) {
        devOpenHelper = dataBaseHelper;
        database = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    public DataBaseHelper getOpenHelper() {
        return devOpenHelper;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
