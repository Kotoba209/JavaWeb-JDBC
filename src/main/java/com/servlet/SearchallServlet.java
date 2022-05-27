package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

public class SearchallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userAll = ud.getUserAll();
        System.out.println("userAll = " + userAll + "all");
        System.out.println(userAll.get(0));
//        for (int i = 0; i < userAll.get(0); i++) {
//
//        }
        req.setAttribute("userAll", userAll);
        req.getRequestDispatcher("/SearchAll.jsp").forward(req, resp);
    }
}
