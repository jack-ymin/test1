package com.sz.dingdan.service;


import com.sz.dingdan.model.Resolut;
import com.sz.dingdan.model.TUser;

import java.util.List;

public interface IUserSrevice {
    Resolut getUser(TUser tUser);

    List<TUser> getAllUser();
}
