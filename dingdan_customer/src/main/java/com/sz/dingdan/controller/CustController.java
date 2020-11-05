package com.sz.dingdan.controller;

import com.sz.dingdan.client.OrdClient;
import com.sz.dingdan.client.ProClient;
import com.sz.dingdan.client.UserClient;
import com.sz.dingdan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/cut")
public class CustController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProClient proClient;

    @Autowired
    private OrdClient ordClient;

    @RequestMapping("/user/login")
    public int login(TUser tUser,HttpServletResponse response){
        Resolut resolut=userClient.login(tUser);
        if (resolut.getRr()>0){
            //如果登录成功,把token存入cookie中去
            String token=resolut.getMsg();
            Cookie cookie=new Cookie("mytoken",token);
            //设置cookie生命周期
            cookie.setPath("/"); //表示所有路径都可以生产cookie
            cookie.setMaxAge(60*15);
            response.addCookie(cookie);
        }
        return resolut.getRr();
    }

    @RequestMapping("/pro/list")
    public PageBean<Goods> list(int pageIndex, int pageSize){
        return proClient.list(pageIndex,pageSize);
    }

    @RequestMapping("/pro/good/{sid}")
    public Goods getGood(@PathVariable("sid") int sid){
        return proClient.getGood(sid);
    }

    @RequestMapping("/ord/shop/{sid}")
    public Resolut shop(@PathVariable("sid") int sid){
        return ordClient.shop(sid);
    }

    @RequestMapping("/ord/myshop")
    public Cart myshop(){
        return ordClient.myshop();
    }

    @RequestMapping("/ord/myorder")
    public MyOrder myorder(){
        return ordClient.myorder();
    }

    @RequestMapping("/ord/addorder")
    public Resolut addorder(String uname,String address,String tele,String remark){
        return ordClient.addorder(uname,address,tele,remark);
    }

    @RequestMapping("/ord/mybye")
    public TOrders mybye(int did){
        return ordClient.mybye(did);
    }
}
