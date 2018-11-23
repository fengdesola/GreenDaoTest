package com.aaa.greendaotest.dbhelper.base;

import android.content.Context;

import com.aaa.greendaotest.greendao.DaoMaster;

public abstract class DataBaseHelper extends DaoMaster.OpenHelper {
    public DataBaseHelper(Context context, String name) {
        super(context, name);
    }

//    @Override
//    public void onUpgrade(Database db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);
//        Log.d("tag", "DataBaseHelper;onUpgrade;oldVersion=" + oldVersion
//                + ",newVersion=" + newVersion);
//        MigrationHelper.getInstance().migrate(db, StudentDao.class, TeacherDao.class);
//    }
}
