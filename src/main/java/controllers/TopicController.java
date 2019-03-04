package controllers;

import controllers.service.TopicService;
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

        String tagId = req.getParameter("tagId");

        String search_field = req.getParameter("search_field");

        String pageNumStr = req.getParameter("pageNum");

        TopicService topicService = new TopicService();
        TopicDTO topicDTO = topicService.getTopics(tagId,search_field,pageNumStr);

        req.setAttribute("topicDTO", topicDTO);

        TopicService dropdown = new TopicService();
        List<DropdownBean> tagList = dropdown.getDropdown();

        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/initialPage.jsp");
        rd.forward(req, resp);
    }
}


