package service;

import DAO.ArticleDAO;
import DAO.DropdownDAO;
import beans.ArticleBean;
import beans.DropdownBean;

import java.util.ArrayList;
import java.util.List;

public class ArticleService implements IArticleService {

    @Override
    public ArrayList<ArticleBean> getArticle(String id) {

        ArticleBean articleBean = new ArticleBean();
        articleBean.setId(Integer.parseInt(id));
        ArrayList<ArticleBean> selectedArticle = ArticleDAO.getArticle(articleBean);

        return selectedArticle;

    }

}
