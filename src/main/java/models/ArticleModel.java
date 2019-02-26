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

                String sql = "SELECT BodyHtml FROM Examples WHERE DocTopicId = ?";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setInt(1, selectedArticle.getId());


                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    ArticleBin articleBin = new ArticleBin();
                    articleBin.setExample(rs.getString("BodyHtml"));
//                    articleBin.setTitle(rs.getString("Title"));
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
