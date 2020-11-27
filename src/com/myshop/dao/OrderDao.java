package com.myshop.dao;

import com.myshop.pojo.Order;

import java.util.List;

public interface OrderDao {

    public int saveOrder(Order order);

    public List<Order> queryOrders();

    public List<Order> queryOrdersByUserId(int userId);
}
