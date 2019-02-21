package controllers;

//import model.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class PaginationBL
{
    static Connection currentCon = null;
    static ResultSet resultSet = null;
    int limit = 10;
    String tag = "java";



    public  ResultSet getLimitedResult() {

        //preparing some objects for connection
        Statement statement = null;

//        String tag = docTagDAL.getTag();
//        String limit = docTagDAL.getPassword();

        String searchQuery =
                "SELECT * FROM DocTags WHERE Tag ='"+
                        tag +
                        "' ORDER BY TopicCount " +
                        "LIMIT " + limit;

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: "+ searchQuery);

        try
        {
            //connect to DB

            //controllers.Connector

            currentCon = ConnectionManager.getConnection();

            statement=currentCon.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            boolean more = resultSet.next();

            // if user does not exist set the isValid variable to false
            if (!more)
            {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
//                docTagDAL.setValid(false);
            }

//            //if user exists set the isValid variable to true
//            else if (more)
//            {
//                String firstName = resultSet.getString("FirstName");
//                String lastName = resultSet.getString("LastName");
//
//                System.out.println("Welcome " + firstName);
//                docTagDAL.setFirstName(firstName);
//                docTagDAL.setLastName(lastName);
//                docTagDAL.setValid(true);
//            }
        }

        catch (Exception ex)
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
//        finally
//        {
//            if (resultSet != null)	{
//                try {
//                    resultSet.close();
//                } catch (Exception e) {}
//                resultSet = null;
//            }
//
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (Exception e) {}
//                statement = null;
//            }
//
//            if (currentCon != null) {
//                try {
//                    currentCon.close();
//                } catch (Exception e) {
//                }
//
//                currentCon = null;
//            }
//        }

        return resultSet;

    }
}
