package models;

import controllers.DBconnection;

import java.sql.*;

public class ArticleModel {

    public static Article getArticle(Article selectedArticle) {

        Article article = new Article();


        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {


                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql = "SELECT ViewCount FROM Topics WHERE Title = ?";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, selectedArticle.getTitle());


                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {

                    article.setCreationDate(rs.getInt("ViewCount"));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }

        return article;


    }

}
