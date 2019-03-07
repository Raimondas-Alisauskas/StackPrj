package service.implService;

import model.DTO.ArticleDTO;
import service.database.DAO.IDAO.IArticleDAO;
import service.database.DAO.implDAO.ArticleDAO;
import service.IService.IArticleService;

public class ArticleService implements IArticleService {

    @Override
    public ArticleDTO getArticle(String id) {

        int articleId;
        if (id == null || id.isEmpty()) {
            articleId = 0;
        } else {
            articleId = (Integer.parseInt(id));
        }

        IArticleDAO articleDAO = new ArticleDAO();
        ArticleDTO articleDTO = articleDAO.getArticle(articleId);

        return articleDTO;

    }

}
