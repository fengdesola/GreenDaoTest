package com.aaa.greendaotest.info2db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Teacher2 {
    @Id(autoincrement = true)
    private Long id;

    private String name;
    private String address;


    @Generated(hash = 1014689003)
    public Teacher2(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Generated(hash = 487655263)
    public Teacher2() {
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
        sb.append("id=").append(id).append("  name=").append(name).append("  addr=").append(address);
        return sb.toString();
    }
}
