package controllers;

import DTO.DBConnectionDTO;
import utils.ConfigurationProperties;
import utils.ErrorType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {

    DBConnectionDTO dbConnectionDTO = new DBConnectionDTO();

    public DBConnectionDTO getConnection() {


        try {

            Class.forName("org.sqlite.JDBC");

            // create a database connection
            dbConnectionDTO.connection = DriverManager.getConnection(ConfigurationProperties.DB_CONNECTION_STR);
            dbConnectionDTO.isConnectedToDB = true;

        } catch (SQLException | ClassNotFoundException e) {
            dbConnectionDTO.errorType = ErrorType.NO_CONNECTION_TO_DATABASE;
            System.out.println(e.getMessage());
        }

        return dbConnectionDTO;
    }

    public DBConnectionDTO closeConnection(Connection connection) {
        try {
            if(connection != null)
                connection.close();
                dbConnectionDTO.isConnectedToDB = false;

        } catch(SQLException e) {
            // connection close failed.
            System.err.println(e);
            dbConnectionDTO.errorType = ErrorType.NO_CONNECTION_TO_DATABASE;
        }
        return dbConnectionDTO;
    }
}
