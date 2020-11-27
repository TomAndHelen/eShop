package com.myshop.service.impl;

import com.myshop.dao.GoodDao;
import com.myshop.dao.OrderDao;
import com.myshop.dao.OrderItemDao;
import com.myshop.dao.impl.GoodDaoImpl;
import com.myshop.dao.impl.OrderDaoImpl;
import com.myshop.dao.impl.OrderItemDaoImpl;
import com.myshop.pojo.*;
import com.myshop.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    GoodDao goodDao = new GoodDaoImpl();

    @Override
    public void createOrder(Cart cart, int userId) {

        Order order = new Order();
        order.setCreateTime(new Date());
        order.setOrderId(System.currentTimeMillis() + "" + userId);
        order.setPrice(cart.getTotalPrice());
        order.setUserId(userId);

        orderDao.saveOrder(order);

        Map<Integer, CartItem> items = cart.getItems();

        for (Map.Entry<Integer, CartItem>item: items.entrySet()){
            OrderItem orderItem = new OrderItem(null, item.getValue().getName(), item.getValue().getCount(), item.getValue().getPrice(), item.getValue().getTotalPrice(), order.getOrderId());
            orderItemDao.saveOrderItem(orderItem);

            Integer id = item.getValue().getId();
            Good good = goodDao.queryGoodById(id);
            good.setSales(good.getSales() + item.getValue().getCount());
            good.setStock(good.getStock() - item.getValue().getCount());

            goodDao.updateGood(good);

        }
        cart.clear();

    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public List<Order> showMyOrders(int userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public List<OrderItem> showOrderDetails(String orderId){
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }


}
