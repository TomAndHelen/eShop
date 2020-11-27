package com.myshop.web;

import com.myshop.pojo.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendMailServlet extends BaseServlet{
    protected void send(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com"); //设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol","smtp"); //邮件发送协议
        prop.setProperty("mail.smtp.auth","true"); //需要验证用户名和密码

        //关于QQ邮箱,还要设置SSL加密,加上以下代码
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactory",sf);

        //使用JavaMail发送邮件的5个步骤

        // 1.创建定义整个应用程序所需要的环境信息的Session对象
        //(QQ才用,其他邮箱不用)
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名,授权码(我们上面开通时获取的字符串)
                return new PasswordAuthentication("840165852@qq.com", "mrblcacxdxuzbffa");
            }
        });

        //开启Session的debug模式,这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        // 2.通过session得到transport对象
        Transport ts = session.getTransport();
        // 3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com","840165852@qq.com","mrblcacxdxuzbffa");

        //4. 创建邮件(需要传递session)
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress("840165852@qq.com"));

        //指明邮件的收件人,现在收件人是一样的,那就是自己给自己发
        User user = (User) req.getSession().getAttribute("user");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

        //邮件的标题
        message.setSubject("感谢您在我的商城下单");

        //邮件的文本内容(简单的邮件内容)====>这里对应我们普通文本的发送
        message.setContent("<h1 style='color:red'>你好,感谢</h1>","text/html;charset=UTF-8");
        message.saveChanges();


        //5.发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        //6.关闭连接
        ts.close();
        System.out.println("发送邮件成功");

//        resp.sendRedirect(req.getHeader("Referer"));
        resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
    }
}
