package service.database.DAO.implDAO;

import service.database.DAO.IDAO.IDeleteDAO;
import service.database.DBconnection;
import java.sql.*;

public class DeleteDAO implements IDeleteDAO {

    public void deleteTopic(int TopicId) {


        Connection con = DBconnection.getConnection();


        if (con != null) try {

            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            String deleteQuery = "delete from Topics where Id = ? ";
            PreparedStatement ps;
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, TopicId);
            int result = ps.executeUpdate();
            System.out.println(result);

//           statement.executeUpdate(deleteQuery);




        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnection.closeConnection(con);
        }


    }
}
