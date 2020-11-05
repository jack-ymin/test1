package com.sz.dingdan.mapper;


import com.sz.dingdan.model.TUser;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserMapper extends Mapper<TUser> {
}
