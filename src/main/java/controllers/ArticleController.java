package controllers;

import models.Article;
import models.ArticleModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/article")
public class ArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        Article article = new Article();
        article.setTitle(req.getParameter("title"));
        String a = req.getParameter("id");
        article.setId(Integer.parseInt(a));


        ArrayList<Article> selectedArticle = ArticleModel.getArticle(article);
        // pratesti su example gavimu


//        selectedArticle.setTitle(article.getTitle());
//        selectedArticle.setId(article.getId());

        req.setAttribute("article", selectedArticle);
        req.getRequestDispatcher("article.jsp").forward(req, resp);

    }


}
