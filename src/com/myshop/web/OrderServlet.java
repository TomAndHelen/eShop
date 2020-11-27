package com.myshop.web;

import com.myshop.pojo.Cart;
import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;
import com.myshop.pojo.User;
import com.myshop.service.OrderService;
import com.myshop.service.impl.OrderServiceImpl;
import com.myshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{

    OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session域中的Cart和User对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");

        //获取用户id，从而保存订单
        Integer id = user.getId();
        orderService.createOrder(cart, id);

        //回显
        req.getRequestDispatcher("/pages/cart/checkoutSuccess.jsp").forward(req,resp);
    }

    /**
     * 查看所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有订单信息并保存在request域中
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders",orders);

        //回显
        req.getRequestDispatcher("/pages/manager/showOrders.jsp").forward(req,resp);
    }

    /**
     * 查看个人订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取int类型的用户id，并根据此id获取用户所有订单，得到一个Order数组
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        List<Order> orders = orderService.showMyOrders(id);

        //将得到的数组保存到request域中
        req.setAttribute("orders",orders);

        //回显
        req.getRequestDispatcher("/pages/user/myOrders.jsp").forward(req,resp);
    }

    /**
     * 查看订单详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取orderId，并根据此orderId获取此orderId对应的订单项数组
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetails(orderId);

        //将获取到的数组保存到request域中
        req.setAttribute("orderItems", orderItems);

        //回显
        req.getRequestDispatcher("/pages/common/orderDetails.jsp").forward(req,resp);

    }

}
