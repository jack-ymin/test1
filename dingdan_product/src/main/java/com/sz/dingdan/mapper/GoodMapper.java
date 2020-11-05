package com.sz.dingdan.mapper;

import com.sz.dingdan.model.Goods;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface GoodMapper extends Mapper<Goods> {
}
