package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestAPIServlet")
public class RequestAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //getRequestURI获取请求的资源路径
        System.out.println("URI =="+request.getRequestURI());
    //获取请求的统一资源定位
        System.out.println("URL =="+request.getRequestURL());
    //获取客服端的IP地址
        System.out.println("客户端ip地址 =="+request.getRemoteHost());
    //获取请求头
        System.out.println("请求头 =="+request.getHeader("User-Agent"));
    //获取请求方式GET或者POST
        System.out.println("请求的方式 =="+request.getMethod());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
