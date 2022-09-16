package com.example.FromZerotoExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FromZerotoExpert", value = "/FromZerotoExpert")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 写一个数据：你学会Servlet了吗？
        System.out.println("doGet被执行");
        // 回复一个正常的响应
        // 响应行
        response.setStatus(200);
        // 响应头
        // 这个应该是封装的那个方法
        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("Content-Type", "text/html");
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("utf-8");
        writer.write("<h1>我不想乱码！</h1>");

//        这个流不需要关闭，由 tomcat 进行管理
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
