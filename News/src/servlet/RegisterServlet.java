package servlet;

import dao.TopicDao;
import dao.UserDao;
import enity.Topic;
import enity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");

        boolean flag = new UserDao().addUser(username,upwd);
        if (flag==true){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script language='javascript'> "+
                    "alert('注册成功');"+
                    "window.location.href='index.jsp';"+
                    "</script>");
            writer.flush();
            writer.close();
//            User user = new User();
//            user.setUsername(username);
//            user.setUpwd(upwd);
//            HttpSession session = request.getSession();
//            session.setAttribute("loginUser",user);
//            request.getRequestDispatcher("NewslistServlet").forward(request,response);
//            response.sendRedirect("index.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script language='javascript'> "+
                    "alert('注册失败，请重新尝试');"+
                    "window.location.href='register.jsp';"+
                    "</script>");
            writer.flush();
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
