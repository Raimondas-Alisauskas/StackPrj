package service.database.DAO.IDAO;

import model.beans.ArticleBean;

import java.util.ArrayList;

public interface IArticleDAO {

    ArrayList<ArticleBean> getArticle(ArticleBean selectedArticle);

}
