package service.IService;

import model.DTO.ArticleDTO;
import model.beans.ArticleBean;

import java.util.ArrayList;

public interface IArticleService {

    ArticleDTO getArticle(String id);

}
