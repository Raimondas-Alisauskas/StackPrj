package controllers.service;

import models.beans.ArticleBean;
import models.beans.DropdownBean;

import java.util.ArrayList;
import java.util.List;

public interface IArticleService {

    ArrayList<ArticleBean> getArticle(String id);

    List<DropdownBean> getDropdown();

}
