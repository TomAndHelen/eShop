package com.myshop.test;

import com.myshop.dao.GoodDao;
import com.myshop.dao.impl.GoodDaoImpl;
import com.myshop.pojo.Good;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import static org.junit.Assert.*;

public class GoodDaoTest {

    GoodDao goodDao = new GoodDaoImpl();
    @Test
    public void addGood() {
        int status = goodDao.addGood(new Good(null, "商品", new BigDecimal(5.5), 100, 200));
        if (status != -1){
            System.out.println("新增商品成功！");
        } else {
            System.out.println("新增商品失败");
        }
    }

    @Test
    public void deleteGoodById() {
        int status = goodDao.deleteGoodById(8);
        if (status != -1){
            System.out.println("删除商品成功！");
        } else {
            System.out.println("删除商品失败");
        }

    }

    @Test
    public void updateGood() {
        int status = goodDao.updateGood(new Good(15, "商品15",new BigDecimal(51), 100, 200));
        if (status != -1){
            System.out.println("修改商品成功！");
        } else {
            System.out.println("修改商品失败");
        }
    }

    @Test
    public void queryGoodById() {
        Good good = goodDao.queryGoodById(30);
        if(good != null){
            System.out.println("查找商品成功");
            System.out.println(good);
        } else {
            System.out.println("查找商品失败");
        }
    }

    @Test
    public void queryGoods() {
        List<Good> goods = goodDao.queryGoods();
        if (goods != null){
            System.out.println("查找所有商品成功");
            for (Good good : goods) {
                System.out.println(good);
            }
        } else {
            System.out.println("查找失败");
        }

    }
}