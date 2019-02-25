package models;

import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;

public class ArticleModel {

    public static ArrayList<Article> getArticle(Article selectedArticle) {


        ArrayList<Article> examples = new ArrayList<>();


        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {


                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql = "SELECT BodyHtml FROM Examples WHERE DocTopicId = ?";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setInt(1, selectedArticle.getId());


                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    Article article = new Article();
                    article.setExample(rs.getString("BodyHtml"));
                    examples.add(article);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }

        return examples;


    }

}
