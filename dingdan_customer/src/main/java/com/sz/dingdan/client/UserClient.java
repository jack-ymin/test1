package com.sz.dingdan.client;

import com.sz.dingdan.model.Resolut;
import com.sz.dingdan.model.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "dingdan-user")
public interface UserClient {

    @RequestMapping("/user/login")
    Resolut login(@RequestBody TUser tUser);

}
