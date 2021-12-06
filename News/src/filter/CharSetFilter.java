package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "CharSetFilter",urlPatterns = {"/newspages/*"})
public class CharSetFilter implements Filter {
    private String filerName;
    private String charSet;
    public void init(FilterConfig config) throws ServletException {
        System.out.println("charSetFilter测试");
        filerName = config.getInitParameter("name2");
        charSet = config.getInitParameter("name1");
        System.out.println("charSetFilter的初始化");
        System.out.println("filterName的值为"+filerName);
    }

    public void destroy() {
        System.out.println("charSetFilter的销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("charSet的值为"+charSet);
        System.out.println("charSetFilter的doFilter执行");
        request.setCharacterEncoding(charSet);
        response.setCharacterEncoding(charSet);
        chain.doFilter(request,response);
    }
}
