package com.sz.dingdan.client;
import com.sz.dingdan.model.Cart;
import com.sz.dingdan.model.MyOrder;
import com.sz.dingdan.model.Resolut;
import com.sz.dingdan.model.TOrders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "dingdan-order")
public interface OrdClient {

    @RequestMapping("/ord/shop/{sid}")
    Resolut shop(@PathVariable("sid") int sid);

    @RequestMapping("/ord/myshop")
    Cart myshop();

    @RequestMapping("/ord/myorder")
    MyOrder myorder();

    @RequestMapping("/ord/mybye")
    TOrders mybye(@RequestParam("did") int did);

    @RequestMapping("/ord/addorder")
    Resolut addorder(@RequestParam("uname") String uname,@RequestParam("address") String address,@RequestParam("tele") String tele,@RequestParam("remark") String remark);
}
