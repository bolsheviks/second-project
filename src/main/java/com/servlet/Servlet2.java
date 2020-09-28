package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取请求的参数进行查看
        String username = request.getParameter("username");
        System.out.println("在Servlet2(柜台2）中查看参数（材料）"+username);
    //查看柜台1是否有盖章
    Object key1 = request.getAttribute("key1");
        System.out.println("柜台1是否盖过章"+key1);
        //处理自己的业务
        System.out.println("Servlet2处理自己的业务");

    }
}
