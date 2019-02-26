package controllers;

import models.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("")
public class TopicController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SearchBin searchBin = new SearchBin();

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

        TopicResults topicResult = TopicModel.getTopicsFromDB(searchBin);

        req.setAttribute("topicsList", topicResult.getTopicsList());
        req.setAttribute("numbOfRecords", topicResult.getNumbOfRecords());
        req.setAttribute("pageNumb", topicResult.getPageNumb());
        req.setAttribute("searchInput", topicResult.getSearchInput());

        DropdownModel dropdownModel = new DropdownModel();
        List<DropdownBin> tagList = dropdownModel.getLimitedResult();
        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}


