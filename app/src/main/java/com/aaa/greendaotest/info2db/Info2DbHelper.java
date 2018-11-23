package com.aaa.greendaotest.info2db;

import android.content.Context;
import android.util.Log;

import com.aaa.greendaotest.dbhelper.base.DataBaseHelper;
import com.aaa.greendaotest.dbhelper.base.MigrationHelper;
import com.aaa.greendaotest.greendao.Student2Dao;
import com.aaa.greendaotest.greendao.Teacher2Dao;

import org.greenrobot.greendao.database.Database;

public class Info2DbHelper extends DataBaseHelper {
    
    public Info2DbHelper(Context context) {
        super(context, "info2.db");
    }
        @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("tag", "DataBaseHelper;onUpgrade;oldVersion=" + oldVersion
                + ",newVersion=" + newVersion);
        MigrationHelper.getInstance().migrate(db, Student2Dao.class, Teacher2Dao.class);
    }
}
