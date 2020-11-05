package com.sz.dingdan.model;


//购物车中,每个商品的购买信息
public class CartItem extends Goods {
    private int num=0; //购买单个商品的数量
    private float xiaoji;  //购买单个商品的小计, 数量*价格

    public CartItem() {
    }

    public CartItem(int num, float xiaoji) {
        this.num = num;
        this.xiaoji = xiaoji;
    }

    public CartItem(Integer sid, String sname, Float sprice, String sshop, String simg, int num, float xiaoji) {
        super(sid, sname, sprice, sshop, simg);
        this.num = num;
        this.xiaoji = xiaoji;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getXiaoji() {
        xiaoji=this.num*this.getSprice();
        return xiaoji;
    }

    public void setXiaoji(float xiaoji) {
        this.xiaoji = xiaoji;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "num=" + num +
                ", xiaoji=" + xiaoji +
                '}';
    }
}
