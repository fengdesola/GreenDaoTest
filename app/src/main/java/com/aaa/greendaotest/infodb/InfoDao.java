package com.aaa.greendaotest.infodb;

import com.aaa.greendaotest.infodb.entity.Student;
import com.aaa.greendaotest.infodb.entity.Teacher;
import com.aaa.greendaotest.dbhelper.base.OperatorHelper;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class InfoDao {
    
    InfoDBManager dbManager;
    
    private static class Holder {
        private static InfoDao singleton = new InfoDao();

    }

    public static InfoDao getSingleton(){
        return Holder.singleton;
    }
    private InfoDao(){
        dbManager = InfoDBManager.getInstance();
    }
    
    public void del(){
        OperatorHelper.deleteAll(dbManager, Student.class);
        OperatorHelper.deleteAll(dbManager, Teacher.class);
    }
    
    
    public void insertStudent(ArrayList<Student> data){
        if(data == null) return;

        OperatorHelper.insert(dbManager, Student.class, data);
    }
    public void insertStudent(Student data){
        if(data == null) return;

        OperatorHelper.insert(dbManager, data);
    }
    
    public ArrayList<Student> queryStudent(){
        QueryBuilder<Student> builder = dbManager.getDaoSession().getStudentDao().queryBuilder();
        List<Student> query = OperatorHelper.query(dbManager, builder);
        if(query == null){
            return null;
        }
        return new ArrayList<>(query);
    }
    public void insertTeacher(ArrayList<Teacher> data){
        if(data == null) return;

        OperatorHelper.insert(dbManager, Teacher.class, data);
    }
    
    public ArrayList<Teacher> queryTeacher(){
        QueryBuilder<Teacher> builder = dbManager.getDaoSession().getTeacherDao().queryBuilder();
        List<Teacher> query = OperatorHelper.query(dbManager, builder);
        if(query == null){
            return null;
        }
        return new ArrayList<>(query);
    }
}
