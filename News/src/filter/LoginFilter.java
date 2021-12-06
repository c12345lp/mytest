package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter", urlPatterns = "/newspages/*")
//@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter测试");
        System.out.println("LoginFiler初始化");
    }

    public void destroy() {
        System.out.println("LoginFiler销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("loginUser") == null){
            resp.sendRedirect("/error/error.jsp");
        }else {
            chain.doFilter(request, response);
        }
    }
}
