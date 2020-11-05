package com.sz.dingdan.service;

import com.sz.dingdan.mapper.OrdersMapper;
import com.sz.dingdan.model.TOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public int addOrders(TOrders tOrders) {
        return ordersMapper.insertSelective(tOrders);
    }

    @Override
    public TOrders getone(int did) {
        return ordersMapper.selectByPrimaryKey(did);
    }
}
