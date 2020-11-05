package com.sz.dingdan.controller;


import com.sz.dingdan.model.*;
import com.sz.dingdan.service.IOrderDetailService;
import com.sz.dingdan.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ord")
public class OrderController {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IOrderDetailService iOrderDetailService;

    //加入购物车的功能
    @RequestMapping("/shop/{sid}")
    public Resolut shop(@PathVariable("sid") int sid){
        //从redis中取出商品信息
        Goods goods= (Goods) redisTemplate.opsForValue().get("sid"+sid);
        Cart cart=new Cart(); //定义一个空的购物车
        Map<Integer,CartItem> map=new HashMap<>(); //定义一个空的集合
        //根据foods写入一个菜
        CartItem item=new CartItem(goods.getSid(),goods.getSname(),goods.getSprice(),goods.getSshop(),goods.getSimg(),1,goods.getSprice());
        TUser tUser= (TUser) redisTemplate.opsForValue().get("tuser");
        //1第一次购物
        if (redisTemplate.opsForValue().get("goods"+tUser.getUid())==null){
            map.put(sid,item); //把购买的小项目写入购物车集合中
            cart.setMap(map); //把购物车集合写入购物车中
            redisTemplate.opsForValue().set("goods"+tUser.getUid(),cart); //把购物车放到redis中
        }else {
            //2第二次购物或多次购物
            Cart cart1= (Cart) redisTemplate.opsForValue().get("goods"+tUser.getUid());
            map=cart1.getMap(); //获取map
            //3 分两种情况,此购物过,数量加1,如果没有购买过,放进去
            if (map.containsKey(sid)) {
                //数量+1
                CartItem cartItem = map.get(sid); //取出集合中的value
                cartItem.setNum(cartItem.getNum()+1);
            }else {
                map.put(sid,item);
            }
            cart.setMap(map);
            redisTemplate.opsForValue().set("goods"+tUser.getUid(),cart); //把购物车放到redis中
        }
        return new Resolut(1,"添加购物车成功",cart);
    }

    @RequestMapping("/myshop")
    public Cart myshop(){
        //从redis中取出购物车
        TUser tUser= (TUser) redisTemplate.opsForValue().get("tuser");
        Cart cart= (Cart) redisTemplate.opsForValue().get("goods"+tUser.getUid());
        return cart;
    }

    @RequestMapping("/myorder")
    public MyOrder myorder(){
        TUser tUser= (TUser) redisTemplate.opsForValue().get("tuser");
        Cart cart= (Cart) redisTemplate.opsForValue().get("goods"+tUser.getUid());
        return new MyOrder(tUser.getUname(),tUser.getAddress(),tUser.getTele(),cart.getMap(),cart.getTotal(),cart.getSum());
    }

    @RequestMapping("/addorder")
    public Resolut addorder(String uname,String address,String tele,String remark){
        TUser tUser= (TUser) redisTemplate.opsForValue().get("tuser");
        Cart cart= (Cart) redisTemplate.opsForValue().get("goods"+tUser.getUid());
        TOrders tOrders=new TOrders(uname,address,tele,"待支付",cart.getTotal(),remark);
        iOrderService.addOrders(tOrders); //添加订单号
        int did=tOrders.getDid(); //得到ID
        String identifier=iOrderService.getone(did).getIdentifier(); //得到订单号
        Collection<CartItem> values = cart.getMap().values(); //遍历map
        for (CartItem value : values) {
            OrderDetails orderDetails=new OrderDetails(value.getSid(),identifier,value.getNum(),value.getXiaoji());
            iOrderDetailService.addOrderDetails(orderDetails); //添加订单详情表
        }
        //清空redis中的购物车
        redisTemplate.delete("goods"+tUser.getUid());
        return new Resolut(did,identifier,cart.getTotal());
    }

    @RequestMapping("/mybye")
    public TOrders mybye(int did){
        return iOrderService.getone(did);
    }
}
