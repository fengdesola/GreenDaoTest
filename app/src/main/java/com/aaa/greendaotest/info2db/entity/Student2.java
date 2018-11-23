package com.aaa.greendaotest.info2db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student2 {
    @Id(autoincrement = true)
    private Long id;

    private String name;
    private int age;
    private Boolean sex;


    public Student2(Long id, String name, int age) {
        this(id, name, age, true);
    }
    @Generated(hash = 1706727078)
    public Student2() {
    }




    @Generated(hash = 1334286520)
    public Student2(Long id, String name, int age, Boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }




    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id).append("  name=").append(name).append("  age=").append(age).append("  sex=").append(sex);
        return sb.toString();
    }
//    public boolean getSex() {
//        return this.sex;
//    }
//    public void setSex(boolean sex) {
//        this.sex = sex;
//    }




    public Boolean getSex() {
        return this.sex;
    }




    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    
}
