package com.sz.dingdan.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//新建一个购物车的实体类
public class Cart {
    private Map<Integer,CartItem> map=new HashMap<>();
    private float total; //总金额
    private int sum; //总数量

    public Cart(Map<Integer, CartItem> map, float total, int sum) {
        this.map = map;
        this.total = total;
        this.sum = sum;
    }

    public Cart() {
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
        int m=0;
        float f=0;
        Collection<CartItem> values = map.values();
        for (CartItem value : values) {
            f=f+value.getXiaoji();
            m=m+value.getNum();
        }
        this.sum=m;
        this.total=f;
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", total=" + total +
                ", sum=" + sum +
                '}';
    }
}
