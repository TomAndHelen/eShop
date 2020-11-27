package com.myshop.dao.impl;

import com.myshop.dao.OrderDao;
import com.myshop.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`orderId`, `createTime`, `price`, `userId`) values(?,?,?,?)";

        return update(sql,order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {

        String sql = "select * from t_order order by orderId";

        return queryForList(Order.class, sql);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "select * from t_order where `userId` = ? order by orderId";

        return queryForList(Order.class, sql, userId);
    }
}
