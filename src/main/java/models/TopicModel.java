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
                boolean isTagId = !tagId.equals("");

                System.out.println(isTagId);

                String sql = "SELECT count(*) FROM Topics";

                if (isSearchInput && isTagId) {

                    sql = sql + " WHERE Title LIKE '%'||?||'%'AND DocTagId = ?";

                } else if (isSearchInput) {

                    sql = sql + " WHERE Title LIKE '%'||?||'%'";

                } else if (isTagId) {

                    sql = sql + " WHERE DocTagId = ?";
                }

                PreparedStatement psCount;
                psCount = con.prepareStatement(sql);

                if (isSearchInput && isTagId) {

                    psCount.setString(1, searchInput);
                    psCount.setString(2, tagId);

                } else if (isSearchInput) {

                    psCount.setString(1, searchInput);

                } else if (isTagId) {

                    psCount.setString(1, tagId);

                }

                ResultSet rsCount = psCount.executeQuery();
                rsCount.next();
                numbOfRecords = rsCount.getInt(1);

                sql = "SELECT Id, Title FROM Topics";

                if (isSearchInput && isTagId) {

                    sql = sql + " WHERE Title LIKE '%" + searchInput + "%' AND DocTagId = " + tagId;

                } else if (isSearchInput) {

                    sql = sql + " WHERE Title LIKE '%" + searchInput + "%'";

                } else if (isTagId) {

                    sql = sql + " WHERE DocTagId = " + tagId;

                }

                sql = sql + " order by ViewCount desc limit " + ((pageNumber - 1) * numbOfTitles) + ", " + numbOfTitles;

                ResultSet rs = statement.executeQuery(sql);

                System.out.println(sql);

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
