package models.DAO;

import models.beans.*;
import controllers.DBconnection;

import java.sql.*;
import java.util.ArrayList;

public class ArticleDAO {

    public static ArrayList<ArticleBean> getArticle(ArticleBean selectedArticle) {


        ArrayList<ArticleBean> examples = new ArrayList<>();


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

                ArticleBean articleBean = new ArticleBean();

                while (rs.next()) {
                    articleBean.setExample(rs.getString("BodyHtml"));
                    articleBean.setTitle(title);
                    examples.add(articleBean);
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
