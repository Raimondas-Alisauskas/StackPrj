package controllers;

import models.DAO.DropdownDAO;
import models.DAO.TopicDAO;
import models.DTO.SearchDTO;
import models.DTO.TopicDTO;
import models.beans.DropdownBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TopicController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SearchDTO searchDTO = new SearchDTO();

        String tagId = req.getParameter("tagId");

        if (tagId == null) {
            tagId ="";
        }
        searchDTO.setTagId(tagId);


        String search_field = req.getParameter("search_field");
        if (search_field == null) {
            search_field = "";
        }
        searchDTO.setSearchInput(search_field);

        String pageNumStr = req.getParameter("pageNum");
        int pageNr;
        if (pageNumStr == null) {
            pageNr = 1;
        } else {
            pageNr = Integer.parseInt(pageNumStr);
        }
        searchDTO.setPageNumb(pageNr);

        TopicDTO topicDTO = TopicDAO.getTopicsFromDB(searchDTO);



        req.setAttribute("topicDTO", topicDTO);

        DropdownDAO dropdownDAO = new DropdownDAO();
        List<DropdownBean> tagList = dropdownDAO.getLimitedResult();
        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/initialPage.jsp");
        rd.forward(req, resp);
    }
}


