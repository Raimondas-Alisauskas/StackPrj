package controllers;

import models.DocTagDAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DropdownBL
{
    Connection currentCon = null;
    ResultSet rs = null;
    int limitOfResults = 10;
    String tag = "java";
    List<DocTagDAL> tagList;



    public  List<DocTagDAL> getLimitedResult() {

        //preparing some objects for connection
        Statement statement = null;

//        String tag = docTagDAL.getTag();
//        String limit = docTagDAL.getPassword();

        String searchQuery =
//                "SELECT * FROM DocTags WHERE Tag ='"+
//                        tag +
//                        "' ORDER BY TopicCount " +
//                        "LIMIT " + limit;

        "select Id, Tag from DocTags order by TopicCount desc limit 10";


        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: "+ searchQuery);

        try
        {
            //connect to DB
            currentCon = DBconnection.getConnection();

            statement=currentCon.createStatement();


            rs = statement.executeQuery(searchQuery);


            tagList = new ArrayList<>();

            while (rs.next())
            {
                DocTagDAL docTagDAL = new DocTagDAL();

                docTagDAL.setId(rs.getInt("Id"));
                docTagDAL.setTag(rs.getString("Tag"));

                tagList.add(docTagDAL);

            }

        }

        catch (Exception ex)
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally
        {
            if (rs != null)	{
                try {
                    rs.close();
                } catch (Exception e) {}
                rs = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {}
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
