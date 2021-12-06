package servlet;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckRegServlet", value = "/CheckRegServlet")
public class CheckRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regName = request.getParameter("regName");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int res = new UserDao().findUserByName(regName);
        System.out.println("doGet---res="+res);
        out.print(res);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
