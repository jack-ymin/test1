package com.sz.dingdan.model;


public class TOrders {
    private Integer did;
    private String identifier;
    private String uname;
    private String address;
    private String tele;
    private String dstate;
    private Float dtotal;
    private String dremark;

    public TOrders() {
    }

    public TOrders(String uname, String address, String tele, String dstate, Float dtotal, String dremark) {
        this.uname = uname;
        this.address = address;
        this.tele = tele;
        this.dstate = dstate;
        this.dtotal = dtotal;
        this.dremark = dremark;
    }

    public TOrders(Integer did, String identifier, String uname, String address, String tele, String dstate, Float dtotal, String dremark) {
        this.did = did;
        this.identifier = identifier;
        this.uname = uname;
        this.address = address;
        this.tele = tele;
        this.dstate = dstate;
        this.dtotal = dtotal;
        this.dremark = dremark;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getDstate() {
        return dstate;
    }

    public void setDstate(String dstate) {
        this.dstate = dstate;
    }

    public Float getDtotal() {
        return dtotal;
    }

    public void setDtotal(Float dtotal) {
        this.dtotal = dtotal;
    }

    public String getDremark() {
        return dremark;
    }

    public void setDremark(String dremark) {
        this.dremark = dremark;
    }

    @Override
    public String toString() {
        return "TOrders{" +
                "did=" + did +
                ", identifier='" + identifier + '\'' +
                ", uname='" + uname + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", dstate='" + dstate + '\'' +
                ", dtotal=" + dtotal +
                ", dremark='" + dremark + '\'' +
                '}';
    }
}
