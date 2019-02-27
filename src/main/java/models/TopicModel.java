package models;

import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TopicModel {

    public static TopicResults getTopicsFromDB(SearchBin searchBin) {
        List<TopicBin> topics = new ArrayList<>();
        String tagId = searchBin.getTagId();
        String SearchInput = searchBin.getSearchInput();
        int pageNumber = searchBin.getPageNumb();
        int limitOfResults = 10;
        int numbOfRecords = 0;



        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                boolean isSearchInput = !SearchInput.equals("");

                String sql = "SELECT count(*) FROM Topics";
                if (isSearchInput) {
                    sql = sql + " WHERE Title LIKE '%'||?||'%'AND DocTagId = ?";
                }

                PreparedStatement psCount;
                psCount = con.prepareStatement(sql);
                if (isSearchInput) {
                    psCount.setString(1, SearchInput);
                    psCount.setString(2, tagId);
                }

                ResultSet rsCount = psCount.executeQuery();

                rsCount.next();
                numbOfRecords = rsCount.getInt(1);


                sql = "SELECT Id, Title FROM Topics";

                if (isSearchInput) {
                    sql = sql + " WHERE Title LIKE '%" + SearchInput + "%' AND DocTagId = " + tagId;
                }

                sql = sql + " order by ViewCount desc limit " + ((pageNumber - 1) * limitOfResults) + ", " + limitOfResults;

                ResultSet rs =  statement.executeQuery(sql);

//                System.out.println("sql= " + sql);
//                System.out.println("tagId= " + tagId);
//                System.out.println("SearchInput= " + SearchInput);

                while (rs.next()) {
                    TopicBin topic = new TopicBin();
                    topic.setId(rs.getInt("Id"));
                    topic.setTitle(rs.getString("Title"));

                    topics.add(topic);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }

        return new TopicResults(topics, tagId, SearchInput, pageNumber, numbOfRecords);
    }

}
