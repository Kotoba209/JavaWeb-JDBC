package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("name = " + name);

        UserDao ud = new UserDaoImpl();

        if (ud.login(name, pwd)) {
            req.setAttribute("message", "欢迎用户" + name); // 拿到jsp页面传来的参数
            req.getRequestDispatcher("/success.jsp").forward(req, resp); // 转发到成功页面
        } else {
            resp.sendRedirect("index.jsp"); // 重定向到首页
        }
    }
}
