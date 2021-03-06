package service.database.DAO.implDAO;

import model.DTO.UserDTO;
import service.database.DAO.IDAO.IUserDAO;
import service.database.DBconnection;

import java.sql.*;

public class UserDAO implements IUserDAO {

    public void insertUser(UserDTO userDTO) {

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql = "INSERT INTO Users (FirstName, Email, Password, IsAdmin) VALUES (?,?,?, false)";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, userDTO.name);
                ps.setString(2, userDTO.email);
                ps.setString(3, userDTO.password);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }

    }

    public UserDTO checkUser(UserDTO userDTO) {

        String name = "";

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql = "SELECT FirstName FROM Users WHERE Email=? AND Password=?";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, userDTO.email);
                ps.setString(2, userDTO.password);
                ResultSet rs = ps.executeQuery();
                boolean more = rs.next();

                if (more) {
                    name = rs.getString("FirstName");
                } else {
                    return new UserDTO(null, null, null);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }

        }

        return new UserDTO(name, userDTO.email, userDTO.password);

    }
}