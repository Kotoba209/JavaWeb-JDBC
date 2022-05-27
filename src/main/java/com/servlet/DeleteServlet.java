package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("id = " + id);
        int userId = Integer.parseInt(id);

        UserDao ud = new UserDaoImpl();

        if (ud.delete(userId)) {
            req.setAttribute("message", "删除成功");
            req.getRequestDispatcher("/SearchAll.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
