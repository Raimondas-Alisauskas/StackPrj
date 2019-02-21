package models;

import controllers.DBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TopicModel {

    public static ArrayList<TopicBin> getTopicsFromDB() {
        ArrayList<TopicBin> topics = new ArrayList<>();

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                ResultSet rs = statement.executeQuery("select Id, Title from Topics limit 8");
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

        return topics;
    }

}
