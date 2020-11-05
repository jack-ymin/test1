package com.sz.dingdan.mytest;

import com.sz.dingdan.model.TUser;
import com.sz.dingdan.service.IUserSrevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IUserSrevice iUserSrevice;

    @Test
    public void aaa(){
        System.out.println(iUserSrevice.getUser(new TUser("易敏","123")));
    }
}
