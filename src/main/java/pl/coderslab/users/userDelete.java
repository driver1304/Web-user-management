package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userDelete", urlPatterns = "/user/delete")
public class userDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int id = Integer.parseInt(request.getParameter("id"));
        if ("true".equals(request.getParameter("decision"))) {
            userDao.delete(id);
        }
        response.sendRedirect(request.getContextPath() + "/user/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        getServletContext().getRequestDispatcher("/users/delete.jsp")
                .forward(request, response);
    }
}
