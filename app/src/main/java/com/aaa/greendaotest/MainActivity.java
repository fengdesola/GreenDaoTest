package com.aaa.greendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aaa.greendaotest.info2db.Info2Dao;
import com.aaa.greendaotest.info2db.entity.Student2;
import com.aaa.greendaotest.info2db.entity.Teacher2;
import com.aaa.greendaotest.infodb.InfoDao;
import com.aaa.greendaotest.infodb.entity.Student;
import com.aaa.greendaotest.infodb.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnInsertTeacher).setOnClickListener(this);
        findViewById(R.id.btnInsertStudent).setOnClickListener(this);
        findViewById(R.id.btnQueryTeacher).setOnClickListener(this);
        findViewById(R.id.btnQueryStudent).setOnClickListener(this);
        findViewById(R.id.btnInsertBoth).setOnClickListener(this);
        findViewById(R.id.btnQueryBoth).setOnClickListener(this);
        findViewById(R.id.btnInsertQueryBoth).setOnClickListener(this);
        findViewById(R.id.btnBoth).setOnClickListener(this);
        findViewById(R.id.btnInsertTeacher2).setOnClickListener(this);
        findViewById(R.id.btnInsertStudent2).setOnClickListener(this);
        findViewById(R.id.btnQueryTeacher2).setOnClickListener(this);
        findViewById(R.id.btnQueryStudent2).setOnClickListener(this);
        findViewById(R.id.btnInsertBoth2).setOnClickListener(this);
        findViewById(R.id.btnQueryBoth2).setOnClickListener(this);
        findViewById(R.id.btnInsertQueryBoth2).setOnClickListener(this);
        findViewById(R.id.btnBoth).setOnClickListener(this);
        findViewById(R.id.btnDel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsertTeacher:
                insertTeacher();
                break;
            case R.id.btnInsertStudent:
                insertStudent();
                break;
            case R.id.btnQueryTeacher:
                queryTeacher();
                break;
            case R.id.btnQueryStudent:
                queryStudent();
                break;
            case R.id.btnInsertBoth:
                insertTeacher();
                insertStudent();
                break;
            case R.id.btnQueryBoth:
                queryStudent();
                queryTeacher();
                break;
            case R.id.btnInsertQueryBoth:
                insertTeacher();
                queryTeacher();
                break;
                //////////////////////////////////
            case R.id.btnInsertTeacher2:
                insertTeacher2();
                break;
            case R.id.btnInsertStudent2:
                insertStudent2();
                break;
            case R.id.btnQueryTeacher2:
                queryTeacher2();
                break;
            case R.id.btnQueryStudent2:
                queryStudent2();
                break;
            case R.id.btnInsertBoth2:
                insertTeacher2();
                insertStudent2();
                break;
            case R.id.btnQueryBoth2:
                queryStudent2();
                queryTeacher2();
                break;
            case R.id.btnInsertQueryBoth2:
                insertTeacher2();
                queryTeacher2();
                break;
            case R.id.btnBoth:
                insertStudent();
                queryStudent();
                insertTeacher2();
                queryTeacher2();
                break;
            case R.id.btnDel:
               del();
               queryStudent();
                break;

        }
    }
    
    public void del(){
        new Thread(){
            @Override
            public void run() {
                InfoDao dao = InfoDao.getSingleton();
                dao.del();
                Info2Dao dao2 = Info2Dao.getSingleton();
                dao2.del();
            }
        }.start();
    }


    private void queryTeacher() {
        for(int i = 0 ; i< 3; i++)
            new Thread(){
                @Override
                public void run() {
                    InfoDao dao = InfoDao.getSingleton();
                    List<Teacher> teachers = dao.queryTeacher();
                    System.out.println("t=="+teachers);
                }
            }.start();
    }
    private void queryStudent() {
        for(int i = 0 ; i< 6; i++)
            new Thread(){
                @Override
                public void run() {
                    InfoDao dao = InfoDao.getSingleton();
                    List<Student> students = dao.queryStudent();
                    System.out.println("s=="+students.size());
                }
            }.start();
    }

    public void insertStudent(){
        for(int i =0 ; i < 1; i++){
            new Thread(){
                @Override
                public void run() {
                    InfoDao dao = InfoDao.getSingleton();
                    dao.insertStudent(getStudentList());
//                    dao.insertStudent(new Student(null, "sola", 18));
                    System.out.println(Thread.currentThread().getId() + "====S");
                }
            }.start();
        }
    }

    private ArrayList<Student> getStudentList() {
        ArrayList<Student> list = new ArrayList<>();
        for(int i =0; i < 100000; i++) {
            list.add(new Student(null, "s11", 11));
//            list.add(new Student(null, "s22", 22));
        }
        return list;
    }
    

    private void insertTeacher() {

        for(int i =0 ; i < 3; i++){
            new Thread(){
                @Override
                public void run() {
                    InfoDao dao = InfoDao.getSingleton();
                    dao.insertTeacher(getTeacherList());
                    System.out.println(Thread.currentThread().getId() + "====T");
                }
            }.start();
        }
    }

    private ArrayList<Teacher> getTeacherList() {
        ArrayList<Teacher> list = new ArrayList<>();
        list.add(new Teacher(null, "t11", "11"));
        list.add(new Teacher(null, "t22", "22"));
        return list;
    }
    
    
    
    ////////////////////////////////////////////////////////////
    
    private void queryTeacher2() {
        for(int i = 0 ; i< 3; i++)
            new Thread(){
                @Override
                public void run() {
                    Info2Dao dao = Info2Dao.getSingleton();
                    List<Teacher2> teachers = dao.queryTeacher();
                    System.out.println("t2=="+teachers);
                }
            }.start();
    }
    private void queryStudent2() {
        for(int i = 0 ; i< 3; i++)
            new Thread(){
                @Override
                public void run() {
                    Info2Dao dao = Info2Dao.getSingleton();
                    List<Student2> students = dao.queryStudent();
                    System.out.println("s2=="+students);
                }
            }.start();
    }

    public void insertStudent2(){
        for(int i =0 ; i < 3; i++){
            new Thread(){
                @Override
                public void run() {
                    Info2Dao dao = Info2Dao.getSingleton();
                    dao.insertStudent(getStudent2List());
                    System.out.println(Thread.currentThread().getId() + "====S2");
                }
            }.start();
        }
    }

    private ArrayList<Student2> getStudent2List() {
        ArrayList<Student2> list = new ArrayList<>();
        list.add(new Student2(null, "s11", 11));
        list.add(new Student2(null, "s22", 22));
        return list;
    }

    private void insertTeacher2() {

        for(int i =0 ; i < 3; i++){
            new Thread(){
                @Override
                public void run() {
                    Info2Dao dao = Info2Dao.getSingleton();
                    dao.insertTeacher(getTeacher2List());
                    System.out.println(Thread.currentThread().getId() + "====T2");
                }
            }.start();
        }
    }

    private ArrayList<Teacher2> getTeacher2List() {
        ArrayList<Teacher2> list = new ArrayList<>();
        list.add(new Teacher2(null, "t11", "11"));
        list.add(new Teacher2(null, "t22", "22"));
        return list;
    }
}
