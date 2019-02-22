package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBconnection {





    public static Connection getConnection() {

        Connection connection = null;
        try {

            Class.forName("org.sqlite.JDBC");


            // create a database connection

//            InputStream inputStream = DBconnection.class.getResourceAsStream("database/dbpath.txt");
//            System.out.println("inputStream= " + inputStream);
//            String path = readFromInputStream(inputStream);


            connection = DriverManager.getConnection("jdbc:sqlite:../../../database/stackoverflow.db");


        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }

        return connection;
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static void closeConnection(Connection connection) {
        try {
            if(connection != null)
                connection.close();

        } catch(SQLException e) {
            // connection close failed.
            System.err.println(e);
        }
    }
}
