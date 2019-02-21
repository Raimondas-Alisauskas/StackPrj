package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection() throws ClassNotFoundException
	  {
	    // load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try
		{
		  // create a database connection
		  connection = DriverManager.getConnection("jdbc:sqlite:/home/namai/Desktop/CodeBakers/Mokymasis/StackOverflowProject/StackPrj3/database/stackoverflow.db");


		  System.out.println("connection" + connection);

		}
		catch(SQLException e)
		{
		  // if the error message is "out of memory",
		  // it probably means no database file is found
		  System.err.println(e.getMessage());
		}

		return connection;
	  }


	}