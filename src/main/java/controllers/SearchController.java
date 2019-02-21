package controllers;

import models.Search;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class SearchController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        Search search = new Search();
        search.setDropdownValue(req.getParameter("lang_name"));
        search.setSearchInput(req.getParameter("search_field"));

        req.setAttribute("mySearch", search);
        req.getRequestDispatcher("index.jsp").forward(req, resp);


    }


}
