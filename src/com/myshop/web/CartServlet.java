package com.myshop.web;

import com.myshop.pojo.Cart;
import com.myshop.pojo.CartItem;
import com.myshop.pojo.Good;
import com.myshop.service.GoodService;
import com.myshop.service.impl.GoodServiceImpl;
import com.myshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    private GoodService goodService = new GoodServiceImpl();

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品id，并根据此商品id获取查找到对应的Good对象
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Good good = goodService.queryGoodById(id);

        //生成对应的购物车项对象
        CartItem cartItem = new CartItem(good.getId(), good.getName(), good.getPrice(), 1, good.getPrice());

        //从session域中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            //若还不存在购物车对象，则生成一个购物车对象，并将其放入session域
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        //往购物车对象中插入购物车项对象
        cart.addItem(cartItem);
//        System.out.println(cart);
        //回显
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 删除购物车中商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取购物车项id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

//        获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //从购物车中删除对应的购物车项
        cart.deleteItem(id);

        //回显
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        获取购物车对象

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //清空购物车
        cart.clear();

        //回显
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车项对象的id以及更新后的count
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //更新购物车项信息
        cart.updateCount(id, count);

        //回显
        resp.sendRedirect(req.getHeader("Referer"));

    }
}
