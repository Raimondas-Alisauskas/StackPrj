package models;

import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;

public class ArticleModel {

    public static ArrayList<ArticleBin> getArticle(ArticleBin selectedArticle) {


        ArrayList<ArticleBin> examples = new ArrayList<>();


        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql_title = "SELECT Title FROM Topics WHERE Id = ?";
                PreparedStatement ps;
                ps = con.prepareStatement(sql_title);
                ps.setInt(1, selectedArticle.getId());
                ResultSet rs;
                rs = ps.executeQuery();

                String title = null;

                while (rs.next()) {
                    title = rs.getString("Title");
                }

                String sql_example = "SELECT BodyHtml FROM Examples WHERE DocTopicId = ?";

                ps = con.prepareStatement(sql_example);
                ps.setInt(1, selectedArticle.getId());

                rs = ps.executeQuery();

                ArticleBin articleBin = new ArticleBin();

                while (rs.next()) {
                    articleBin.setExample(rs.getString("BodyHtml"));
                    articleBin.setTitle(title);
                    examples.add(articleBin);
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
