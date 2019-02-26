package models;

import controllers.DBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DropdownModel {
    Connection currentCon = null;
    ResultSet rs = null;
    List<DropdownBin> tagList;


    public List<DropdownBin> getLimitedResult() {

        Statement statement = null;


        String searchQuery = "select Id, Tag from DocTags order by TopicCount desc limit 10";

//        System.out.println("Query: " + searchQuery);

        try {
            currentCon = DBconnection.getConnection();

            statement = currentCon.createStatement();


            rs = statement.executeQuery(searchQuery);


            tagList = new ArrayList<>();

            while (rs.next()) {
                DropdownBin dropdownBin = new DropdownBin();

                dropdownBin.setId(rs.getInt("Id"));
                dropdownBin.setTag(rs.getString("Tag"));

                tagList.add(dropdownBin);

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

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return tagList;

    }
}
