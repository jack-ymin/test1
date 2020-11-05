package com.sz.dingdan.mapper;

import com.sz.dingdan.model.TOrders;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface OrdersMapper extends Mapper<TOrders> {
}
