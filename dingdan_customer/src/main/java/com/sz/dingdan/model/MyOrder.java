package com.sz.dingdan.model;

import java.util.HashMap;
import java.util.Map;

public class MyOrder {
    private String uname;
    private String address;
    private String tele;
    private Map<Integer,CartItem> map=new HashMap<>();
    private float total; //总金额
    private int sum; //总数量

    public MyOrder() {
    }

    public MyOrder(String uname, String address, String tele, Map<Integer, CartItem> map, float total, int sum) {
        this.uname = uname;
        this.address = address;
        this.tele = tele;
        this.map = map;
        this.total = total;
        this.sum = sum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "uname='" + uname + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", map=" + map +
                ", total=" + total +
                ", sum=" + sum +
                '}';
    }
}
