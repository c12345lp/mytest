package servlet;

import dao.NewsDao;
import enity.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewslistServlet", value = "/NewslistServlet")
public class NewslistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> list = new NewsDao().findNews();
        HttpSession session = request.getSession();
        session.setAttribute("allNews",list);
//        response.sendRedirect("newspages/admin.jsp");
        response.sendRedirect("TopicListServlet");
//        request.getRequestDispatcher("TopicListServlet").forward(request,response);
    }
}
