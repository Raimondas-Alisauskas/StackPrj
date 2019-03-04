package controllers;

import models.DAO.ArticleDAO;
import models.DAO.DropdownDAO;
import models.beans.ArticleBean;
import models.beans.DropdownBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        ArticleBean articleBean = new ArticleBean();
        String id = req.getParameter("id");
        articleBean.setId(Integer.parseInt(id));

        ArrayList<ArticleBean> selectedArticle = ArticleDAO.getArticle(articleBean);

        DropdownDAO dropdownDAO = new DropdownDAO();
        List<DropdownBean> tagList = dropdownDAO.getLimitedResult();
        req.setAttribute("tagList", tagList);

        req.setAttribute("article", selectedArticle);

        req.getRequestDispatcher("jsp/article.jsp").forward(req, resp);

    }

}
