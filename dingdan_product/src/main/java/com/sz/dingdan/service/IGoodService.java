package com.sz.dingdan.service;


import com.sz.dingdan.model.Goods;
import com.sz.dingdan.model.PageBean;


public interface IGoodService {
    PageBean<Goods> getAllGoods(int pageIndex, int pageSize);

    Goods getGood(int sid);
}
