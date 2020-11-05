package com.sz.dingdan.model;

public class Resolut {
    private Integer rr;
    private String msg;
    private Object data;

    public Resolut() {
    }

    public Resolut(Integer rr, String msg, Object data) {
        this.rr = rr;
        this.msg = msg;
        this.data = data;
    }

    public Integer getRr() {
        return rr;
    }

    public void setRr(Integer rr) {
        this.rr = rr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Resolut{" +
                "rr=" + rr +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
