package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userAdd", urlPatterns = "/user/add")
public class userAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();

        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        userDao.create(user);
        response.sendRedirect(request.getContextPath()+"/user/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);
    }
}
