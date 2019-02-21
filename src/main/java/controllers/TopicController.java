package controllers;

import models.DocTagDAL;
import models.TopicBin;
import models.TopicModel;

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
        ArrayList<TopicBin> topics = TopicModel.getTopicsFromDB();
        req.setAttribute("Topics", topics);

        DropdownBL dropdownBL = new DropdownBL();
        List<DocTagDAL> tagList = dropdownBL.getLimitedResult();
        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}


