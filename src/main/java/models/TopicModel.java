package models;

import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TopicModel {

    public static TopicResults getTopicsFromDB(Search search) {
        List<TopicBin> topics = new ArrayList<>();

        int limitOfResults = 10;
        int pageNumber = search.getPageNumb();
        int numbOfRecords = 0;

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                boolean isSearchInput = !search.getSearchInput().equals("");

                PreparedStatement psCount;

                String sql = "SELECT count(*) FROM Topics";
                if (isSearchInput) {
                    sql = sql + " WHERE Title LIKE '%'||?||'%'";
                    //psCount.setString(1, search.getSearchInput());
                }
                psCount = con.prepareStatement(sql);
                if (isSearchInput) {
                    psCount.setString(1, search.getSearchInput());
                }

                ResultSet rsCount = psCount.executeQuery();
                rsCount.next();
                numbOfRecords = rsCount.getInt(1);


                sql = "SELECT Id, Title FROM Topics";
                if (isSearchInput) {
                    sql = sql + " WHERE Title LIKE '%'||?||'%'";
                }
                sql = sql + " order by ViewCount desc limit " + ((pageNumber - 1) * limitOfResults) + ", " + limitOfResults;


                PreparedStatement psTopic;
                psTopic = con.prepareStatement(sql);
                if (isSearchInput) {
                    psTopic.setString(1, search.getSearchInput());
                }
                ResultSet rs = psTopic.executeQuery();

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

        return new TopicResults(topics, search.getSearchInput(), pageNumber, numbOfRecords);
    }

}
