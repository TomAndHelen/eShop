package com.myshop.dao.impl;

import com.myshop.dao.GoodDao;
import com.myshop.pojo.Good;

import java.sql.SQLClientInfoException;
import java.util.List;

public class GoodDaoImpl extends BaseDao implements GoodDao {
    @Override
    public int addGood(Good good) {
        String sql = "insert into t_good(`name`, `price`, `sales`, `stock`) values(?,?,?,?)";
        return update(sql, good.getName(), good.getPrice(), good.getSales(), good.getStock());
    }

    @Override
    public int deleteGoodById(int id) {
        String sql = "delete from t_good where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateGood(Good good) {
        String sql = "update t_good set `name` = ?, `price` = ?, `sales` =?, `stock` =? where `id` =?";
        return update(sql, good.getName(), good.getPrice(), good.getSales(),good.getStock(), good.getId());
    }

    @Override
    public Good queryGoodById(Integer id) {
        String sql  = "select * from t_good where `id` = ?";
        return queryForOne(Good.class, sql, id);
    }

    @Override
    public List<Good> queryGoods() {
        String sql = "select * from t_good";
        return queryForList(Good.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_good";

        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Good> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`, `name`, `price`, `sales`, `stock` from t_good limit ?,?";
        return queryForList(Good.class, sql, begin, pageSize);
    }
}
