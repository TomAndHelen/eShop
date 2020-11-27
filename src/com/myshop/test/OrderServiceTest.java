package com.myshop.test;

import com.myshop.pojo.Cart;
import com.myshop.pojo.CartItem;
import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;
import com.myshop.service.OrderService;
import com.myshop.service.impl.OrderServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        CartItem cartItem1 = new CartItem(1, "商品1", new BigDecimal(20), 1, new BigDecimal(20));
        CartItem cartItem2 = new CartItem(2, "商品2", new BigDecimal(29.5), 1, new BigDecimal(29.5));
        CartItem cartItem3 = new CartItem(3, "商品3", new BigDecimal(39.5), 1,  new BigDecimal(39.5));
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        orderService.createOrder(cart, 1);
    }

    @Test
    public void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void showMyOrders() {
        List<Order> orders = orderService.showMyOrders(2);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void showOrderDetails() {

        List<OrderItem> items = orderService.showOrderDetails("");
        for (OrderItem item : items) {
            System.out.println(item);
        }

    }
}