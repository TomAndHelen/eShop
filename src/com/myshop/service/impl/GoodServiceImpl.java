package com.myshop.service.impl;

import com.myshop.dao.GoodDao;
import com.myshop.dao.impl.GoodDaoImpl;
import com.myshop.pojo.Good;
import com.myshop.pojo.Page;
import com.myshop.service.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {

    GoodDao goodDao = new GoodDaoImpl();

    @Override
    public void addGood(Good good) {
        goodDao.addGood(good);
    }

    @Override
    public void deleteGoodById(Integer id) {
        goodDao.deleteGoodById(id);
    }

    @Override
    public void updateGood(Good good) {
        goodDao.updateGood(good);
    }

    @Override
    public Good queryGoodById(Integer id) {

        return goodDao.queryGoodById(id);
    }

    @Override
    public List<Good> queryGoods() {
        return goodDao.queryGoods();
    }

    @Override
    public Page<Good> page(int pageNo, int pageSize) {

        //根据无参构造函数生成一个Page对象
        Page<Good> page = new Page<Good>();

        //设置page的五个参数
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pageTotalCount = goodDao.queryForPageTotalCount();
        page.setPageTatalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        //设置分页
        int begin = (pageNo -1) *pageSize;
        List<Good> items = goodDao.queryForPageItems(begin, pageSize);

//        将单页的信息设置为items属性
        page.setItems(items);

        //返回获取的page对象
        return page;

    }
}
