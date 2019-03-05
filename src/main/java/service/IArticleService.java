package service;

import beans.ArticleBean;
import beans.DropdownBean;

import java.util.ArrayList;
import java.util.List;

public interface IArticleService {

    ArrayList<ArticleBean> getArticle(String id);

}
