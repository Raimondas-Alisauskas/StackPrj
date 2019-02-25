package controllers;

import models.DocTagDAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DropdownBL {
    Connection currentCon = null;
    ResultSet rs = null;
    List<DocTagDAL> tagList;


    public List<DocTagDAL> getLimitedResult() {

        Statement statement = null;


        String searchQuery = "select Id, Tag from DocTags order by TopicCount desc limit 10";

        System.out.println("Query: " + searchQuery);

        try {
            currentCon = DBconnection.getConnection();

            statement = currentCon.createStatement();


            rs = statement.executeQuery(searchQuery);


            tagList = new ArrayList<>();

            while (rs.next()) {
                DocTagDAL docTagDAL = new DocTagDAL();

                docTagDAL.setId(rs.getInt("Id"));
                docTagDAL.setTag(rs.getString("Tag"));

                tagList.add(docTagDAL);

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
