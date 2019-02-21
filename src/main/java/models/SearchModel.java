package models;

import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchModel {

    public static List<Result> getResults(Search search) {

        List<Result> results = new ArrayList<>();

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql = "SELECT Title FROM Topics WHERE Title like '%'||?||'%' ";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, search.getSearchInput());

                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    Result result = new Result();
                    result.setTitle(rs.getString("Title"));

                    results.add(result);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }


        return results;
    }

}
