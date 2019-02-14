

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;




public class App {

	public static void main(String[] args) throws ClassNotFoundException
	  {
	    // load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");

	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:stackoverflow.db");
	    
	      createTableDocTags(connection);
	      
	      
	      System.out.println("OK");
	      	      
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	  }
	
	
	public static void createTableDocTags(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	      //DocTag table
	      statement.executeUpdate("drop table if exists DocTags");
	      
	      String nTable = "";
	      	      
	      nTable = "CREATE TABLE if not exists DocTags ("
	      		+ "Id INTEGER PRIMARY KEY,"
	      		+ " Tag text,"
	      		+ " Title text,"
	      		+ " HelloWorldDocTopicId INTEGER,"
	      		+ " TopicCount INTEGER);";
	      
	      statement.executeUpdate(nTable);
	      
	      int id;
	      String tag;
	  	  String title;
	  	  int helloWorldDocTopicId;
	  	  int topicCount;
    
	      String insertTableSQL = "INSERT INTO DocTags"
	    		+ "(Id, Tag, Title, HelloWorldDocTopicId, TopicCount) VALUES"
	    		+ "(?,?,?,?,?)";
	      JSONParser parser = new JSONParser();

	        try {

	        	JSONArray jsons = (JSONArray) parser.parse(new FileReader("doctags.json"));

	        	  for (Object ojson : jsons)
	        	  {
	        		 
	        	    JSONObject jsonObject = (JSONObject) ojson;
	        	     	          	    	
	        	    //System.out.println(jsonObject);
	        	    
	        	    if (jsonObject.containsKey("Id")) {
	        	    	id = Math.toIntExact((Long) jsonObject.get("Id"));
	        	    } else {
	        	    	id = 0;
	        	    };
	        	    
	        	    if (jsonObject.containsKey("Tag")) {
	        	    	tag = (String) jsonObject.get("Tag");
	        	    } else {
	        	    	tag = "";
	        	    };
	        	    
	        	    if (jsonObject.containsKey("Title")) {
	        	    	title = (String) jsonObject.get("Title");
	        	    } else {
	        	    	title = "";
	        	    };
	        	    
	        	    if (jsonObject.containsKey("HelloWorldDocTopicId")) {
	        	    	helloWorldDocTopicId = Math.toIntExact((Long) jsonObject.get("HelloWorldDocTopicId"));
	        	    } else {
	        	    	helloWorldDocTopicId = 0;
	        	    };
	        	    
	        	    if (jsonObject.containsKey("TopicCount")) {
	        	    	topicCount = Math.toIntExact((Long) jsonObject.get("TopicCount"));
	        	    } else {
	        	    	topicCount = 0;
	        	    };
	        	    
	        	    PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
	        	    preparedStatement.setInt(1, id);
	        	    preparedStatement.setString(2, tag);
	        	    preparedStatement.setString(3, title);
	        	    preparedStatement.setInt(4, helloWorldDocTopicId);
	        	    preparedStatement.setInt(5, topicCount);
	        	    // execute insert SQL stetement
	        	    preparedStatement.executeUpdate();
	        	    
	        	    
	        	  }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		}

	
	}