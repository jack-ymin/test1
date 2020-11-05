package com.sz.dingdan.service;

import com.sz.dingdan.mapper.OrderDetailsMapper;
import com.sz.dingdan.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Override
    public int addOrderDetails(OrderDetails orderDetails) {
        return orderDetailsMapper.insertSelective(orderDetails);
    }
}
