package service.implService;

import service.database.DAO.implDAO.ArticleDAO;
import model.beans.ArticleBean;
import service.IService.IArticleService;

import java.util.ArrayList;

public class ArticleService implements IArticleService {

    @Override
    public ArrayList<ArticleBean> getArticle(String id) {

        ArticleBean articleBean = new ArticleBean();
        articleBean.setId(Integer.parseInt(id));
        ArrayList<ArticleBean> selectedArticle = ArticleDAO.getArticle(articleBean);

        return selectedArticle;

    }

}
