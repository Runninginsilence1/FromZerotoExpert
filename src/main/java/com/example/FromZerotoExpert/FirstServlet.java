package com.example.FromZerotoExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

// 版本更新，这个文件当做第二次打卡的副本代码，不做修改，但是修改 urlPattern的值为
// @WebServlet(name = "FirstServlet", value = "/FromZerotoExpert_FirstServlet ")
@WebServlet(name = "FirstServlet ", value = "/FromZerotoExpert_FirstServlet ")
public class FirstServlet extends HttpServlet {
//    private String message = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 写一个数据：你学会Servlet了吗？
        String message = "嗨，欢迎您来到 from zero to expert.";
        // 我反正理解成 Golang的 handler机制了，我觉得是一个东西，可能其他语言也是这么做的
        System.out.println("doGet被执行");
        // 回复一个正常的响应
        // 响应行
        response.setStatus(200);
        // 响应头
        // 这个应该是封装的那个方法
        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("Content-Type", "text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        Cookie cookie = new Cookie("username", "risk");
        cookie.getName();
        request.getSession();

//        这个流不需要关闭，由 tomcat 进行管理
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
