package servlet;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            System.out.println(username);
            System.out.println(password);
        } else {
            System.out.println("username and password is null");
        }
        //第一次登录
        if (request.getCookies() == null) {
            System.out.println("第一次登录成功");
            if (username.equals("admin") && password.equals("admin")) {
                Cookie usernameCookie = new Cookie("username",username);
                Cookie passwordCookie = new Cookie("password",password);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            } else {
                response.sendRedirect("/fail.jsp");
            }
        }
        //非第一次登录
        else {
            System.out.println("不是第一次登录了");
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("admin")) {
                    System.out.println("cookie的名字:"+cookie.getName());
                    if (cookie.getValue().equals(username)) {
                        for (Cookie cookie1 : request.getCookies()) {
                            if (cookie1.getName().equals("password")) {
                                System.out.println("cookie1的名字:"+cookie.getName());
                                if (cookie1.getValue().equals(password)) {
                                    request.getRequestDispatcher("/success.jsp").forward(request,response);
                                }
                            }
                        }
                    }
                }
            }
            response.sendRedirect("/fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
