package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyModel {

    public TestBin getBinFromDB(){
        //conect to  DB and select *
        TestBin tBin = new TestBin();
        tBin.setField1("test");
        tBin.setField2("DB");

        //ArrayList<TsetBin> = new Ar


        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                ResultSet rs = statement.executeQuery("select * from DocTags");
                while(rs.next())
                {
                    // read the result set
                   // System.out.println("tag = " + rs.getString("Tag"));
                    //System.out.println("id = " + rs.getInt("Id"));

                    tBin.setField1(rs.getString("Tag"));
                    tBin.setField2(rs.getString("Title"));

                    break;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }

        //TestBin tBin = new TestBin();
        //tBin.setField1("test");
        //tBin.setField2("DB");
        return tBin;
    }
}
