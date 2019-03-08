package controller;

import model.DTO.ArticleDTO;
import model.beans.DropdownBean;
import service.IService.IArticleService;
import service.IService.IDropdownService;
import service.implService.ArticleService;
import service.implService.DropdownService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ArticleController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        IArticleService articles = new ArticleService();

        String id = req.getParameter("id");

        ArticleDTO articleDTO = articles.getArticle(id);
        req.setAttribute("articleDTO", articleDTO);

        HttpSession session = req.getSession();
        IDropdownService dropdown = new DropdownService();
        List<DropdownBean> tagList = (List<DropdownBean>) session.getAttribute("tagList");
        if (tagList == null || tagList.isEmpty()) {
            tagList = dropdown.getDropdown();
            session.setAttribute("tagList", tagList);
        }

        req.getRequestDispatcher("jsp/article.jsp").forward(req, resp);

    }

}
