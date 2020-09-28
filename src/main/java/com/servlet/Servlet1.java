package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//请求转发过程的servlet1
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取请求参数()并且查看
        String username = request.getParameter("username");
        System.out.println("在Servlet1（柜台1）中查看参数（材料）"+username);
    //给材料盖一个章，并传递到Servlet2（柜台2）去查看
        request.setAttribute("key1","柜台1的章");
    //Servlet2怎么走
    //请求撞飞必须要以斜杠打头/斜杠表示地址为http：//ip：port/工程名/
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Servlet2");
    //走向Servlet2
    requestDispatcher.forward(request,response);
    }
}
