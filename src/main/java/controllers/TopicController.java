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
        searchDTO.setTagId(tagId); //cia nusetiname tagID i searchDTO


        String search_field = req.getParameter("search_field");  //pasiemame search field is req objekto (= is kliento uzklausos)
        if (search_field == null) {
            search_field = "";
        }
        searchDTO.setSearchInput(search_field); // nusetiname search_field

        String pageNumStr = req.getParameter("pageNum"); // jsp nusetinome numberi paimta is kliento
        int pageNr;
        if (pageNumStr == null) {
            pageNr = 1; //jei nera kitokios info, tai default rodome pirma psl
        } else {
            pageNr = Integer.parseInt(pageNumStr);
        }
        searchDTO.setPageNumb(pageNr);

        TopicDTO topicDTO = TopicDAO.getTopicsFromDB(searchDTO); ///Cia jau einame ieskoti topicu. sita funkc sukurs objekta TopidDTO



        req.setAttribute("topicDTO", topicDTO); //perduoda i requesta (jsp) atrinktus topicus pagal searchDTO
                                                    ///ideojome i req topicDTO kaip atributa, nes mes galim ideti objekta kaip atributa

        DropdownDAO dropdownDAO = new DropdownDAO();
        List<DropdownBean> tagList = dropdownDAO.getLimitedResult();
        req.setAttribute("tagList", tagList);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/initialPage.jsp"); //perduodame req i jsp. jsp moka dirbti su musu objektu
        rd.forward(req, resp);
    }
}


