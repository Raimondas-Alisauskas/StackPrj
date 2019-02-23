package controllers;

import models.Result;
import models.Search;
import models.SearchModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet("/result")
public class SearchController extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        Search search = new Search();
        search.setSearchInput(req.getParameter("search_field"));
        search.setPageNumb(Integer.parseInt(req.getParameter("pageNum")));
        System.out.println(search.getSearchInput());

//        http://localhost:8080/Stack_war_exploded/result?lang_name=android&search_field=kotlin&search_button=



        List<Result> results = SearchModel.getResults(search);
        req.setAttribute("results", results);
        req.getRequestDispatcher("result.jsp").forward(req, resp);


    }


}
