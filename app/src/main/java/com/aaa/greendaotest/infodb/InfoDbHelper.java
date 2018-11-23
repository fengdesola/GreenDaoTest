package com.aaa.greendaotest.infodb;

import android.content.Context;
import android.util.Log;

import com.aaa.greendaotest.dbhelper.base.DataBaseHelper;
import com.aaa.greendaotest.dbhelper.base.MigrationHelper;
import com.aaa.greendaotest.greendao.StudentDao;
import com.aaa.greendaotest.greendao.TeacherDao;

import org.greenrobot.greendao.database.Database;

public class InfoDbHelper extends DataBaseHelper {
    
    public InfoDbHelper(Context context) {
        super(context, "info");
    }
        @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("tag", "DataBaseHelper;onUpgrade;oldVersion=" + oldVersion
                + ",newVersion=" + newVersion);
        MigrationHelper.getInstance().migrate(db, StudentDao.class, TeacherDao.class);
    }
}
