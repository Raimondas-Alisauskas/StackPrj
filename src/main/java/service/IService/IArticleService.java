package service.IService;

import model.beans.ArticleBean;

import java.util.ArrayList;

public interface IArticleService {

    ArrayList<ArticleBean> getArticle(String id);

}
