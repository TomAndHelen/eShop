package com.myshop.test;

import com.myshop.pojo.Cart;
import com.myshop.pojo.CartItem;
import org.junit.Test;

import javax.sound.midi.Soundbank;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();

    @Test
    public void addItem() {
        CartItem cartItem1 = new CartItem(1, "商品1", new BigDecimal(20), 1, new BigDecimal(20));
        CartItem cartItem2 = new CartItem(2, "商品2", new BigDecimal(29.5), 1, new BigDecimal(29.5));
        CartItem cartItem3 = new CartItem(3, "商品3", new BigDecimal(39.5), 1,  new BigDecimal(39.5));
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        CartItem cartItem1 = new CartItem(1, "商品1", new BigDecimal(20), 1, new BigDecimal(20));
        CartItem cartItem2 = new CartItem(2, "商品2", new BigDecimal(29.5), 1, new BigDecimal(29.5));
        CartItem cartItem3 = new CartItem(3, "商品3", new BigDecimal(39.5), 1,  new BigDecimal(39.5));
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        CartItem cartItem1 = new CartItem(1, "商品1", new BigDecimal(20), 1, new BigDecimal(20));
        CartItem cartItem2 = new CartItem(2, "商品2", new BigDecimal(29.5), 1, new BigDecimal(29.5));
        CartItem cartItem3 = new CartItem(3, "商品3", new BigDecimal(39.5), 1,  new BigDecimal(39.5));
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        CartItem cartItem1 = new CartItem(1, "商品1", new BigDecimal(20), 1, new BigDecimal(20));
        CartItem cartItem2 = new CartItem(2, "商品2", new BigDecimal(29.5), 1, new BigDecimal(29.5));
        CartItem cartItem3 = new CartItem(3, "商品3", new BigDecimal(39.5), 1,  new BigDecimal(39.5));
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        System.out.println(cart);
        cart.updateCount(1, 3);
        System.out.println(cart);
    }
}