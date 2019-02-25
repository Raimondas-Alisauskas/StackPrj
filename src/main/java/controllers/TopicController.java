package controllers;

import models.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class TopicController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Search search = new Search();
        //search.setSearchInput(req.getParameter("search_field"));
        //search.setPageNumb(Integer.parseInt(req.getParameter("pageNum")));
        //System.out.println(search.getSearchInput());

        String search_field = req.getParameter("search_field");
        if (search_field == null) {
            search_field = "";
        }
        search.setSearchInput(search_field);

        String pageNumStr = req.getParameter("pageNum");
        int pageNr;
        if (pageNumStr == null) {
            pageNr = 1;
        } else {
            pageNr = Integer.parseInt(pageNumStr);
        }
        search.setPageNumb(pageNr);

        //System.out.println("search_field " + req.getParameter("search_field"));
        //System.out.println("pageNum " + req.getParameter("pageNum"));

        TopicResults topicResult = TopicModel.getTopicsFromDB(search);

        //ArrayList<TopicBin> topics = TopicModel.getTopicsFromDB(search);
        req.setAttribute("Topics", topicResult.getTopicsList());

        DropdownBL dropdownBL = new DropdownBL();
        List<DocTagDAL> tagList = dropdownBL.getLimitedResult();
        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}


