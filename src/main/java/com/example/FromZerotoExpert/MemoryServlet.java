package com.example.FromZerotoExpert;

import org.junit.jupiter.api.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemoryServlet", value = "/FromZerotoExpert")
public class MemoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet被执行");
        // 回复一个正常的响应
        // 响应行
        response.setStatus(200);
        // 响应头
        // 这个应该是封装的那个方法
        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("Content-Type", "text/html");
        PrintWriter out = response.getWriter();
        // Cookie不存在就 设置初次访问的逻辑；
        if (!isCookieExist(request, response)) {
            String message = "嗨，欢迎您来到 from zero to expert.";
            // 我反正理解成 Golang的 handler机制了，我觉得是一个东西，可能其他语言也是这么做的

            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");

            // 写入 Cookie，并设置有效的时间
            Cookie cookie = new Cookie("visited", "");
            cookie.setMaxAge(86400); // 60 * 60 * 24 = 86400，24小时
            response.addCookie(cookie);
            // 否则直接展示 第二次之后的页面
        } else {
            String message = "哼哼哼啊啊啊啊啊啊啊啊";
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * 判断 Cookie是否存在来 考虑展示哪个页面。
     * @param request 你懂的
     * @param response 你懂的
     * @return 返回是否存在。
     */
    private boolean isCookieExist(HttpServletRequest request, HttpServletResponse response) {
        // Auth Cookie K: visited, V: null
        // 可以拿到cookie
        final String VISITED = "visited";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            String name = cookie.getName();
            if (name.equals(VISITED)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 用于测试：移除自定义的 Cookie
     */
    /*
    * 经过测试，junit应该使用的另外一个实例，所以没有拿到引用
    * 注释这段代码
    * */
    /*@Test
    public void removeCookie() {
        // null的情况
        if (this.cookieToBeRemoved == null) {
            System.out.println("[Error]服务器没有启动，这个Cookie的引用是一个null！");
        } else {
            this.cookieToBeRemoved.setMaxAge(0);
        }
    }*/
}
