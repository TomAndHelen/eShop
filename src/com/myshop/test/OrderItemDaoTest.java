package com.myshop.test;

import com.myshop.dao.OrderItemDao;
import com.myshop.dao.impl.OrderItemDaoImpl;
import com.myshop.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {

        int status = orderItemDao.saveOrderItem(new OrderItem(null, "Item1", 1, new BigDecimal(10), new BigDecimal(10), "ididid2"));
        if (status != -1){
            System.out.println("订单项保存成功");
        }else {
            System.out.println("保存失败");
        }

    }

    @Test
    public void queryOrderItemsByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("ididid2");
        if (orderItems != null){
            System.out.println("查询成功！");
            for (OrderItem orderItem : orderItems) {
                System.out.println(orderItem);
            }
        } else {
            System.out.println("查询失败");
        }

    }
}