package models;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;
import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchModel {

    public static List<Result> getResults(Search search) {

        List<Result> results = new ArrayList<>();
        int limitOfResults = 10;
        int pageNumber = search.getPageNumb();

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {


                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql1 = "SELECT count(*) FROM Topics WHERE Title like '%'||?||'%'";

                PreparedStatement ps1;
                ps1= con.prepareStatement(sql1);
                ps1.setString(1, search.getSearchInput());


                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                int numbOfRecords = rs1.getInt(1);
                System.out.printf("numbOfRecords= " + numbOfRecords);


                String sql2 = "SELECT Title FROM Topics WHERE Title like '%'||?||'%' order by ViewCount desc limit ?,"+limitOfResults;

                PreparedStatement ps2;
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, search.getSearchInput());
                ps2.setString(2, String.valueOf((pageNumber - 1) * limitOfResults));



                ResultSet rs2;
                rs2 = ps2.executeQuery();

                while (rs2.next()) {
                    Result result = new Result();
                    result.setSearchInput(search.getSearchInput());
                    result.setTitle(rs2.getString("Title"));
                    result.setPageNumb(pageNumber);

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
