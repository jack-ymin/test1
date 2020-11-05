package com.sz.dingdan.service;

import com.sz.dingdan.model.TOrders;

public interface IOrderService {
    int addOrders(TOrders tOrders);

    TOrders getone(int did);
}
