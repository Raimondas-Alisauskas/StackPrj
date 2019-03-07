package model.DTO;

import model.beans.ArticleBean;

import java.util.List;

public class ArticleDTO {
    private List<ArticleBean> articleList;
    private int id;
    private String title;

    public ArticleDTO(List<ArticleBean> articleList, int id, String title) {
        this.articleList = articleList;
        this.id = id;
        this.title = title;
    }

    public List<ArticleBean> getArticleList() {
        return articleList;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
