package com.sz.dingdan.protest;

import com.sz.dingdan.service.IGoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProTest {

    @Autowired
    private IGoodService iGoodService;

    @Test
    public void aaaa(){
        System.out.println(iGoodService.getAllGoods(1,2));
    }
}
