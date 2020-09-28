package com.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponeIOServlet")
public class ResponeIOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //要求 往客服端回传字符串数据

        //响应乱码解决方法
        //方案1：tong
        //设置服务器字符集为UTF-8
        response.setCharacterEncoding("UTF-8");
        //通过响应头 设置浏览器也使用UTF-8字符集
         //response.setHeader("Content-type","text/html;charest=utf-8");

        // PrintWriter writer = response.getWriter();
       // writer.write("这是ResponeIOServlet的相应内容");

        //方案2
        //同时设置服务器和客户端使用UTF-8字符集 还设置响应头
        //此方法一定要在获取对象之前调用才有效
        response.setContentType("text/html;charest=UTF-8");

       PrintWriter writer = response.getWriter();
        writer.write("这是ResponeIOServlet的相应内容");
    }
}