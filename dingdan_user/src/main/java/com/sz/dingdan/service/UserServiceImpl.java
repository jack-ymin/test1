package com.sz.dingdan.service;

import com.sz.dingdan.common.JwtUtils;
import com.sz.dingdan.common.MD5;
import com.sz.dingdan.mapper.UserMapper;
import com.sz.dingdan.model.Resolut;
import com.sz.dingdan.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserSrevice{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MD5 md5;

    @Override
    public Resolut getUser(TUser tUser) {
        //生成token并存入redis并设置时间
        Resolut resolut=null;
        tUser.setUpwd(md5.getMD5ofStr(tUser.getUpwd()));
        TUser tUser1=userMapper.selectOne(tUser);
        if (tUser1!=null){
            String jwtToken= jwtUtils.createJwt(tUser.getUname(), "getUser");
            resolut=new Resolut(1,jwtToken,tUser1);
            redisTemplate.opsForValue().set(jwtToken,tUser1,900,TimeUnit.SECONDS);
            redisTemplate.opsForValue().set("tuser",tUser1,900,TimeUnit.SECONDS);
        }else {
            resolut=new Resolut(0,"登录失败","登录失败");
        }
        return resolut;
    }

    @Override
    public List<TUser> getAllUser() {
        return userMapper.selectAll();
    }
}
