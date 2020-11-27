package com.myshop.service;

import com.myshop.pojo.Good;
import com.myshop.pojo.Page;

import java.util.List;

public interface GoodService {
    public void addGood(Good good);

    public void deleteGoodById(Integer id);

    public void updateGood(Good good);

    public Good queryGoodById(Integer id);

    public List<Good> queryGoods();

    public Page<Good> page(int pageNo, int pageSize);
}
