package com.sz.dingdan.controller;

import com.sz.dingdan.model.Resolut;
import com.sz.dingdan.model.TUser;
import com.sz.dingdan.service.IUserSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserSrevice iUserSrevice;

    @RequestMapping("/login")
    public Resolut login(@RequestBody TUser tUser){
        return iUserSrevice.getUser(tUser);
    }

    @RequestMapping("/list")
    public List<TUser> list(){
        return iUserSrevice.getAllUser();
    }
}
