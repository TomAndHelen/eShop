package com.myshop.web;

import com.myshop.pojo.User;
import com.myshop.service.UserService;
import com.myshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{

    /**
     * 注册功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        UserService userService = new UserServiceImpl();
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        2、检查 验证码是否正确
        if (token!=null && token.equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
//                System.out.println("用户名[" + username + "]已存在!");
                req.setAttribute("msg","用户名["+username+"]已经存在");
//        跳回注册页面
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Service保存到数据库
                userService.registerUser(new User(null, username, password, email));
//
//        跳到注册成功页面
                req.getRequestDispatcher("/pages/user/registerSuccess.jsp").forward(req, resp);
            }
        } else {
//            System.out.println("验证码[" + code + "]错误");

            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }

    /**
     * 登录功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UserService userService = new UserServiceImpl();

        //获取request域中的账用户账号密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //生成一个拥有此账号密码的User对象，并检测该对象能否登录
        User loginUser = userService.loginUser(new User(null, username, password, null));
        if (loginUser == null){ //不能登录
            //设置错误信息
            req.setAttribute("msg", "用户名或者密码错误");
            //回显
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }else {  //能登录
            //将user信息保存到session域中
            req.getSession().setAttribute("user", loginUser);
            //回显
            req.getRequestDispatcher("/pages/user/loginSuccess.jsp").forward(req,resp);
        }
    }

    /**
     * 管理员登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void mlogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //除了在session域中多保存了一个admin以外，其余与login完全相同
        UserService userService = new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ( "admin".equals(username) && "admin".equals(password)){
            User loginUser = userService.loginUser(new User(null, username, password, null));
            req.getSession().setAttribute("user", loginUser);
            req.getSession().setAttribute("admin", 1);
            resp.sendRedirect(req.getContextPath()+ "/pages/user/loginSuccess.jsp");
            return;
        }else {
            req.setAttribute("msg", "管理员名或者密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp?admin=1").forward(req,resp);
        }
//        req.getRequestDispatcher("/pages/user/loginSuccess.jsp").forward(req,resp);

    }


    /**
     * 注销功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //        1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
        //        2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }

}
