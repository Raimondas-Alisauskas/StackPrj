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

public class ArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        ArticleBin articleBin = new ArticleBin();
        String id = req.getParameter("id");
        articleBin.setId(Integer.parseInt(id));

        ArrayList<ArticleBin> selectedArticle = ArticleModel.getArticle(articleBin);

        DropdownModel dropdownModel = new DropdownModel();
        List<DropdownBin> tagList = dropdownModel.getLimitedResult();
        req.setAttribute("tagList", tagList);

        req.setAttribute("article", selectedArticle);

        req.getRequestDispatcher("jsp/article.jsp").forward(req, resp);

    }

}
