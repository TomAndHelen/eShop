package com.myshop.service;

import com.myshop.pojo.Cart;
import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public void createOrder(Cart cart, int userId);

    public List<Order> showAllOrders();

    public List<Order> showMyOrders(int userId);

    public List<OrderItem> showOrderDetails(String orderId);
}
