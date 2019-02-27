package controllers;

import models.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//@WebServlet("")
public class TopicController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SearchBin searchBin = new SearchBin();

        String tagId = req.getParameter("tagId");
        searchBin.setTagId(tagId);

        String search_field = req.getParameter("search_field");
        if (search_field == null) {
            search_field = "";
        }
        searchBin.setSearchInput(search_field);

        String pageNumStr = req.getParameter("pageNum");
        int pageNr;
        if (pageNumStr == null) {
            pageNr = 1;
        } else {
            pageNr = Integer.parseInt(pageNumStr);
        }
        searchBin.setPageNumb(pageNr);

        TopicResults topicResults = TopicModel.getTopicsFromDB(searchBin);

        req.setAttribute("topicResults", topicResults);

        DropdownModel dropdownModel = new DropdownModel();
        List<DropdownBin> tagList = dropdownModel.getLimitedResult();
        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/initialPage.jsp");
        rd.forward(req, resp);
    }
}


