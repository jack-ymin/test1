package com.sz.dingdan.model;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_orderdetails")
public class OrderDetails {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer xid;
    private Integer sid;
    private String identifier;
    private Integer xsize;
    private Float xiaoji;

    public OrderDetails() {
    }

    public OrderDetails(Integer sid, String identifier, Integer xsize, Float xiaoji) {
        this.sid = sid;
        this.identifier = identifier;
        this.xsize = xsize;
        this.xiaoji = xiaoji;
    }

    public OrderDetails(Integer xid, Integer sid, String identifier, Integer xsize, Float xiaoji) {
        this.xid = xid;
        this.sid = sid;
        this.identifier = identifier;
        this.xsize = xsize;
        this.xiaoji = xiaoji;
    }

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getXsize() {
        return xsize;
    }

    public void setXsize(Integer xsize) {
        this.xsize = xsize;
    }

    public Float getXiaoji() {
        return xiaoji;
    }

    public void setXiaoji(Float xiaoji) {
        this.xiaoji = xiaoji;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "xid=" + xid +
                ", sid=" + sid +
                ", identifier='" + identifier + '\'' +
                ", xsize=" + xsize +
                ", xiaoji=" + xiaoji +
                '}';
    }
}
