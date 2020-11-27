package com.myshop.test;

import com.myshop.dao.OrderDao;
import com.myshop.dao.impl.OrderDaoImpl;
import com.myshop.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        int status = orderDao.saveOrder(new Order("ididid2", new Date(), new BigDecimal(12), 2));
        if ( status != -1 ){
            System.out.println("新增成功！");
        } else {
            System.out.println("新增失败！");
        }
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        if (orders != null){
            System.out.println("查询成功！");
            for (Order order: orders){
                System.out.println(order);
            }
        }else {
            System.out.println("查询失败");
        }
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(2);
        if (orders != null){
            System.out.println("查询成功！");
            for (Order order: orders){
                System.out.println(order);
            }
        }else {
            System.out.println("查询失败或者订单为空");
        }
    }
}