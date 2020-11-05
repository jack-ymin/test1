package com.sz.dingdan.model;


import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_goods")
public class Goods {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer sid;
    private String sname;
    private Float sprice;
    private String sshop;
    private String simg;

    public Goods() {
    }

    public Goods(Integer sid, String sname, Float sprice, String sshop, String simg) {
        this.sid = sid;
        this.sname = sname;
        this.sprice = sprice;
        this.sshop = sshop;
        this.simg = simg;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Float getSprice() {
        return sprice;
    }

    public void setSprice(Float sprice) {
        this.sprice = sprice;
    }

    public String getSshop() {
        return sshop;
    }

    public void setSshop(String sshop) {
        this.sshop = sshop;
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sprice=" + sprice +
                ", sshop='" + sshop + '\'' +
                ", simg='" + simg + '\'' +
                '}';
    }
}
