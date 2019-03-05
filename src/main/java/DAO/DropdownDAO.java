package DAO;

import DTO.DBConnectionDTO;
import controllers.DBconnection;
import beans.DropdownBean;
import utils.ConfigurationProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DropdownDAO {
    Connection con = null;
    ResultSet rs = null;
    List<DropdownBean> tagList;
    int numbOfTags = ConfigurationProperties.SHOW_NUMB_OF_TAGS;


    public List<DropdownBean> getLimitedResult() {

        Statement statement = null;


        String searchQuery = "select Id, Tag from DocTags order by TopicCount desc limit " + numbOfTags;

//        System.out.println("Query: " + searchQuery);
        DBconnection dBconnection = new DBconnection();

        try {

            DBConnectionDTO dbConnectionDTO = dBconnection.getConnection();
            con = dbConnectionDTO.connection;

            statement = con.createStatement();


            rs = statement.executeQuery(searchQuery);


            tagList = new ArrayList<>();

            while (rs.next()) {
                DropdownBean dropdownBean = new DropdownBean();

                dropdownBean.setId(rs.getString("Id"));
                dropdownBean.setTag(rs.getString("Tag"));

                tagList.add(dropdownBean);

            }

        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                }
                statement = null;
            }

            dBconnection.closeConnection(con);
        }

        return tagList;

    }
}
