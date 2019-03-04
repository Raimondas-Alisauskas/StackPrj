package controllers.service.interfaces;

import models.beans.ArticleBean;
import models.beans.DropdownBean;

import java.util.ArrayList;
import java.util.List;

public interface ArticleServiceInterface {

    ArrayList<ArticleBean> getArticle(String id);

    List<DropdownBean> getDropdown();

}
