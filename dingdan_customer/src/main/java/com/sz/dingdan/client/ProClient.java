package com.sz.dingdan.client;

import com.sz.dingdan.model.Goods;
import com.sz.dingdan.model.PageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "dingdan-product")
public interface ProClient {

    @RequestMapping("/pro/list")
    PageBean<Goods> list(@RequestParam("pageIndex") int pageIndex,@RequestParam("pageSize")int pageSize);

    @RequestMapping("/pro/good/{sid}")
    Goods getGood(@PathVariable("sid") int sid);

}
