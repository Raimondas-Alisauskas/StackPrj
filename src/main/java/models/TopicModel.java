package models;

import controllers.DBconnection;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TopicModel {

    public static TopicResults getTopicsFromDB(SearchBin searchBin) {
        List<TopicBin> topics = new ArrayList<>();
        String tagId = searchBin.getTagId();
        String searchInput = searchBin.getSearchInput();
        int pageNumber = searchBin.getPageNumb();
        int numbOfTitles = Constants.SHOW_NUMB_OF_TITLES;
        int numbOfRecords = 0;


        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                boolean isSearchInput = !searchInput.equals("");

                String sql = "SELECT count(*) FROM Topics";
                if (isSearchInput) {
                    sql = sql + " WHERE Title LIKE '%'||?||'%'AND DocTagId = ?";
                }

                PreparedStatement psCount;
                psCount = con.prepareStatement(sql);
                if (isSearchInput) {
                    psCount.setString(1, searchInput);
                    psCount.setString(2, tagId);
                }

                ResultSet rsCount = psCount.executeQuery();

                rsCount.next();
                numbOfRecords = rsCount.getInt(1);


                sql = "SELECT Id, Title FROM Topics";

                if (isSearchInput) {
                    sql = sql + " WHERE Title LIKE '%" + searchInput + "%' AND DocTagId = " + tagId;
                }

                sql = sql + " order by ViewCount desc limit " + ((pageNumber - 1) * numbOfTitles) + ", " + numbOfTitles;

                ResultSet rs = statement.executeQuery(sql);

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

        return new TopicResults(topics, tagId, searchInput, pageNumber, numbOfRecords);
    }

}
