package com.aaa.greendaotest.info2db;

import com.aaa.greendaotest.dbhelper.base.OperatorHelper;
import com.aaa.greendaotest.info2db.entity.Student2;
import com.aaa.greendaotest.info2db.entity.Teacher2;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Info2Dao {
    Info2DBManager dbManager;
    
    private static class Holder {
        private static Info2Dao singleton = new Info2Dao();

    }

    public static Info2Dao getSingleton(){
        return Holder.singleton;
    }
    private Info2Dao(){
        dbManager = Info2DBManager.getInstance();
    }

    public void del(){
        OperatorHelper.deleteAll(dbManager, Student2.class);
        OperatorHelper.deleteAll(dbManager, Teacher2.class);
    }
    
    public void insertStudent(ArrayList<Student2> data){
        if(data == null) return;

        OperatorHelper.insert(dbManager, Student2.class, data);
    }
    
    public ArrayList<Student2> queryStudent(){
        QueryBuilder<Student2> builder = dbManager.getDaoSession().getStudent2Dao().queryBuilder();
        List<Student2> query = OperatorHelper.query(dbManager, builder);
        if(query == null){
            return null;
        }
        return new ArrayList<>(query);
    }
    public void insertTeacher(ArrayList<Teacher2> data){
        if(data == null) return;

        OperatorHelper.insert(dbManager, Teacher2.class, data);
    }
    
    public ArrayList<Teacher2> queryTeacher(){
        QueryBuilder<Teacher2> builder = dbManager.getDaoSession().getTeacher2Dao().queryBuilder();
        List<Teacher2> query = OperatorHelper.query(dbManager, builder);
        if(query == null){
            return null;
        }
        return new ArrayList<>(query);
    }
}
