package controllers;

import controllers.service.ITopicService;
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

        ITopicService topicService = new TopicService();
        ITopicService dropdown = new TopicService();

        String tagId = req.getParameter("tagId");

        String search_field = req.getParameter("search_field");

        String pageNumStr = req.getParameter("pageNum");


        TopicDTO topicDTO = topicService.getTopics(tagId,search_field,pageNumStr);

        req.setAttribute("topicDTO", topicDTO);

        List<DropdownBean> tagList = dropdown.getDropdown();

        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/initialPage.jsp");
        rd.forward(req, resp);
    }
}


