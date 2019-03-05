package controllers.service;

import models.DAO.ArticleDAO;
import models.DAO.DropdownDAO;
import models.beans.ArticleBean;
import models.beans.DropdownBean;

import java.util.ArrayList;
import java.util.List;

public class ArticleService implements IArticleService {

    public ArrayList<ArticleBean> getArticle(String id) {

        ArticleBean articleBean = new ArticleBean();
        articleBean.setId(Integer.parseInt(id));
        ArrayList<ArticleBean> selectedArticle = ArticleDAO.getArticle(articleBean);

        return selectedArticle;

    }

    public List<DropdownBean> getDropdown() {

        DropdownDAO dropdownDAO = new DropdownDAO();
        List<DropdownBean> tagList = dropdownDAO.getLimitedResult();
        return tagList;

    }

}
