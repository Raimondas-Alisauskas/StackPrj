package controllers;

import models.ArticleBin;
import models.ArticleModel;
import models.DropdownBin;
import models.DropdownModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/article")
public class ArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        ArticleBin articleBin = new ArticleBin();
        String articleTitle = req.getParameter("title");
        articleBin.setTitle(articleTitle);
        String a = req.getParameter("id");
        articleBin.setId(Integer.parseInt(a));


        ArrayList<ArticleBin> selectedArticle = ArticleModel.getArticle(articleBin);

        // pratesti su example gavimu

//        selectedArticle.setTitle(articleBin.getTitle());
//        selectedArticle.setId(articleBin.getId());

        DropdownModel dropdownModel = new DropdownModel();
        List<DropdownBin> tagList = dropdownModel.getLimitedResult();
        req.setAttribute("tagList", tagList);

        req.setAttribute("article", selectedArticle);
        req.setAttribute("articleTitle", articleTitle);

        req.getRequestDispatcher("jsp/article.jsp").forward(req, resp);

    }

}
