package servlet;

import dao.UserDao;
import enity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",
        loadOnStartup = 1,
        value = "/LoginServlet",
        initParams = {@WebInitParam(name="name1",value ="value1")})
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        System.out.println("开始创建LoginServlet");
        super.init();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("LoginServlet的service()执行");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("LoginServlet销毁");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");

        User user = new UserDao().findUser(username,upwd);
        if (user!=null){
            HttpSession session = request.getSession();
//        out.write("欢迎"+user.getUsername()+"登录");
            session.setAttribute("loginUser",user);
//            response.sendRedirect("util/do_news_list.jsp");
            request.getRequestDispatcher("NewslistServlet").forward(request,response);
//            util/do_news_list.jsp
//
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script language='javascript'> "+
                    "alert('账号密码错误，请重新登录');"+
                    "window.location.href='index.jsp';"+
                    "</script>");
            writer.flush();
            writer.close();
//            out.write("登录失败");
//            response.sendRedirect("../index.jsp");
        }
        destroy();
    }
}
