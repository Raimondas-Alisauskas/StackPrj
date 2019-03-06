package controllers;

import service.ArticleService;
import service.DropdownService;
import service.IArticleService;
import beans.ArticleBean;
import beans.DropdownBean;
import service.IDropdownService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        IArticleService articles = new ArticleService();

        String id = req.getParameter("id");

        ArrayList<ArticleBean> selectedArticle = articles.getArticle(id);
        req.setAttribute("article", selectedArticle);

        HttpSession session = req.getSession();
        IDropdownService dropdown = new DropdownService();
        List<DropdownBean> tagList = dropdown.getDropdown((List<DropdownBean>) session.getAttribute("tagList"));
        session.setAttribute("tagList", tagList);

        req.getRequestDispatcher("jsp/article.jsp").forward(req, resp);

    }

}
