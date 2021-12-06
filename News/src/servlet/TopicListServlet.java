package servlet;

import dao.TopicDao;
import enity.Topic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopicListServlet", value = "/TopicListServlet")
public class TopicListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        List<Topic> list = new TopicDao().findTopic();
        for (Topic li:
                list) {
            System.out.println(li);
        }
        request.getSession().setAttribute("allTopic",list);
        response.sendRedirect("PageControlServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
