package com.sz.dingdan.model;


public class TUser {
    private Integer uid;
    private String uname;
    private String upwd;
    private String address;
    private String tele;

    public TUser() {
    }

    public TUser(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public TUser(Integer uid, String uname, String upwd, String address, String tele) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.address = address;
        this.tele = tele;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }
}
