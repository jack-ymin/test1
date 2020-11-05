package com.sz.dingdan.controller;


import com.sz.dingdan.model.Goods;
import com.sz.dingdan.model.PageBean;
import com.sz.dingdan.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
public class ProductController {

    @Autowired
    private IGoodService iGoodService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/list")
    public PageBean<Goods> list(@RequestParam("pageIndex") int pageIndex,@RequestParam("pageSize") int pageSize){
        return iGoodService.getAllGoods(pageIndex,pageSize);

    }

    @RequestMapping("/good/{sid}")
    public Goods getgood(@PathVariable("sid") int sid){
        return iGoodService.getGood(sid);
    }
}
