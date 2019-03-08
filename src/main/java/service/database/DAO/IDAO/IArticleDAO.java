package service.database.DAO.IDAO;

import model.DTO.ArticleDTO;

public interface IArticleDAO {

    ArticleDTO getArticle(int articleId);

}
