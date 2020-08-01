package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userEdit", urlPatterns = "/user/edit")
public class userEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User();

        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setId(id);
        userDao.update(user);

        response.sendRedirect(request.getContextPath()+"/user/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        User read = userDao.read(Integer.parseInt(id));
        request.setAttribute("user", read);

        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(request, response);
    }
}
