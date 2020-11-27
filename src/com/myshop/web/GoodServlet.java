package com.myshop.web;

import com.myshop.pojo.Good;
import com.myshop.pojo.Page;
import com.myshop.service.GoodService;
import com.myshop.service.impl.GoodServiceImpl;
import com.myshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodServlet extends BaseServlet{
    GoodService goodService = new GoodServiceImpl();

    /**
     * 新增商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据form中的信息生成对应的Good对象
        Good good = WebUtils.copyParamToBean(req.getParameterMap(), new Good());

        //保存该good对象
        goodService.addGood(good);

        //回显
        resp.sendRedirect(req.getContextPath()+"/goodServlet?action=page");
    }

    /**
     * 删除商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //通过id删除对应的商品
        goodService.deleteGoodById(id);

        resp.sendRedirect(req.getContextPath()+"/goodServlet?action=page");

    }

    /**
     * 商品修改请求处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //根据商品id查找到对应的Good对象
        Good good = goodService.queryGoodById(id);

        //将该该good对象放进request域中
        req.setAttribute("good",good);

        //回显
        req.getRequestDispatcher("/pages/manager/good_edit.jsp").forward(req,resp);
//        resp.sendRedirect(req.getContextPath()+"/pages/manager/good_edit.jsp");

    }

    /**
     * 更新商品信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void writeBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据form中的信息生成对应的Good对象
        Good good = WebUtils.copyParamToBean(req.getParameterMap(), new Good());

//        System.out.println(good);
        //更新对应的good的信息
        goodService.updateGood(good);

        //回显
        resp.sendRedirect(req.getContextPath()+ "/goodServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取pageNo，pageSize两个参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //根据以上两个参数得到对应的分页显示
        Page<Good> page = goodService.page(pageNo, pageSize);

        //设置分页选项中的url地址
        page.setUrl("goodServlet?action=page");

        //将page保存到request域中
        req.setAttribute("page", page);

        //回显
        req.getRequestDispatcher("/pages/manager/good_manager.jsp").forward(req,resp);
    }

    /**
     * 商品展示界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //除了url地址以及回显不同其余都与page函数相同

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Good> page = goodService.page(pageNo, pageSize);

        page.setUrl("goodServlet?action=show");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/user/showGoods.jsp").forward(req,resp);
    }
}
