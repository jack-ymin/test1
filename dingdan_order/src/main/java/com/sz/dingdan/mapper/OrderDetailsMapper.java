package com.sz.dingdan.mapper;

import com.sz.dingdan.model.OrderDetails;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface OrderDetailsMapper extends Mapper<OrderDetails> {
}
