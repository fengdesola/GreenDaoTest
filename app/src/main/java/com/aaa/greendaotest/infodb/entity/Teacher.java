package com.aaa.greendaotest.infodb.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Teacher {
    @Id(autoincrement = true)
    private Long id;

    private String name;
    private String address;
    private Boolean sex;

    public Teacher(Long id, String name, String address) {
        this(id, name, address, true);
    }

    @Generated(hash = 1630413260)
    public Teacher() {
    }

    @Generated(hash = 1395249469)
    public Teacher(Long id, String name, String address, Boolean sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id).append("  name=").append(name).append("  addr=").append(address).append("  sex=").append(sex);
        return sb.toString();
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

//    public boolean getSex() {
//        return this.sex;
//    }
//
//    public void setSex(boolean sex) {
//        this.sex = sex;
//    }
}
