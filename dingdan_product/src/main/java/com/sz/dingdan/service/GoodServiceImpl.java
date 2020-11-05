package com.sz.dingdan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.dingdan.mapper.GoodMapper;
import com.sz.dingdan.model.Goods;
import com.sz.dingdan.model.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodServiceImpl implements  IGoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public PageBean<Goods> getAllGoods(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize); //开始分页
        List<Goods> list=goodMapper.selectAll();
        Page<Goods> plist= (Page<Goods>) list;
        PageBean<Goods> pb=new PageBean<>(
                plist.getTotal(),plist.getResult(),
                plist.getPageSize(),plist.getPages(),plist.getPageNum()
        );
        return pb;
    }

    @Override
    public Goods getGood(int sid) {
        //存入redis中
        //判断redis中是否存在
        if (redisTemplate.opsForValue().get("sid"+sid)==null){
            redisTemplate.opsForValue().set("sid"+sid,goodMapper.selectByPrimaryKey(sid));
        }
        Goods goods= (Goods) redisTemplate.opsForValue().get("sid"+sid);
        return goods;
    }
}
