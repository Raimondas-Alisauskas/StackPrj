package controllers;

import models.Article;
import models.ArticleModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/article")
public class ArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        Article article = new Article();
        article.setTitle(req.getParameter("title"));

        Article selectedArticle = ArticleModel.getArticle(article);
        selectedArticle.setTitle(article.getTitle());

        req.setAttribute("article", selectedArticle);
        req.getRequestDispatcher("article.jsp").forward(req, resp);

    }


}
