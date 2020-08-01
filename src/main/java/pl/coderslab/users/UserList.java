package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserList", urlPatterns = "/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
        UserDao userDao = new UserDao();
        request.setAttribute("users", userDao.findAll());
        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    } catch (NullPointerException e) {
        response.getWriter().append("ERROR");
        e.printStackTrace();
    }
}







}
