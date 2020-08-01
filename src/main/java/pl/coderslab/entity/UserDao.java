package pl.coderslab.entity;

import pl.coderslab.utils.DbUtil;
import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    private static final String READ_USER_QUERY =
            "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";

    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";

    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";

    private static final String DELETE_ALL_USERS_QUERY =
            "DELETE FROM users WHERE id > 0";

    public String hashPassword(String password) {
        return org.mindrot.jbcrypt.BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User read(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement prepStat = conn.prepareStatement(READ_USER_QUERY);
            prepStat.setInt(1, userId);
            ResultSet rs = prepStat.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement prepStat = conn.prepareStatement(UPDATE_USER_QUERY);
            prepStat.setString(1, user.getUserName());
            prepStat.setString(2, user.getEmail());
            prepStat.setString(3, this.hashPassword(user.getPassword()));
            prepStat.setInt(4, user.getId());
            prepStat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement prepStat = conn.prepareStatement(DELETE_USER_QUERY);
            prepStat.setInt(1, userId);
            prepStat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static User[] addToArray(User u, User[] users) {
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = u;
        return users;
    }

    public static User[] findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            User[] arrOfUsers = new User[0];
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(FIND_ALL_USERS_QUERY);

            while (rs.next()) {
                User tempUser = new User();
                tempUser.setId(rs.getInt(1));
                tempUser.setUserName(rs.getString(2));
                tempUser.setEmail(rs.getString(3));
                tempUser.setPassword(rs.getString(4));
                arrOfUsers= addToArray(tempUser, arrOfUsers);
            }
            return arrOfUsers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
