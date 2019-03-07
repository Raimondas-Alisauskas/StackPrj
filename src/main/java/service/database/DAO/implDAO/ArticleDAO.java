package service.database.DAO.implDAO;

import model.DTO.ArticleDTO;
import model.beans.*;
import service.database.DAO.IDAO.IArticleDAO;
import service.database.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO implements IArticleDAO {

    @Override
    public ArticleDTO getArticle(int articleId) {

        List<ArticleBean> examples = new ArrayList<>();

        String title = "";

        Connection con = DBconnection.getConnection();
        if (con != null) {
            try {

                Statement statement = con.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                String sql_title = "SELECT Title FROM Topics WHERE Id = ?";
                PreparedStatement ps;
                ps = con.prepareStatement(sql_title);
                ps.setInt(1, articleId);
                ResultSet rs;
                rs = ps.executeQuery();

                if (rs.next()) {
                    title = rs.getString("Title");
                }

                String sql_example = "SELECT BodyHtml FROM Examples WHERE DocTopicId = ? ORDER BY Id";

                ps = con.prepareStatement(sql_example);
                ps.setInt(1, articleId);
                rs = ps.executeQuery();

                while (rs.next()) {
                    ArticleBean articleBean = new ArticleBean();
                    articleBean.setExample(rs.getString("BodyHtml"));
                    examples.add(articleBean);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnection.closeConnection(con);
            }
        }

        return new ArticleDTO(examples, articleId, title);
    }

}
