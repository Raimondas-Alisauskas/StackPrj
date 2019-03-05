package controllers.service;

import models.DAO.DropdownDAO;
import models.DAO.TopicDAO;
import models.DTO.SearchDTO;
import models.DTO.TopicDTO;
import models.beans.DropdownBean;

import java.util.List;

public class TopicService implements ITopicService {

    public TopicDTO getTopics(String tagID, String search_field, String page_num) {

        SearchDTO searchDTO = new SearchDTO();

        if (tagID == null) {
            tagID = "";
        }
        searchDTO.setTagId(tagID);

        if (search_field == null) {
            search_field = "";
        }
        searchDTO.setSearchInput(search_field);

        int pageNr;
        if (page_num == null) {
            pageNr = 1;
        } else {
            pageNr = Integer.parseInt(page_num);
        }
        searchDTO.setPageNumb(pageNr);

        TopicDTO topicDTO = TopicDAO.getTopicsFromDB(searchDTO);

        return topicDTO;
    }

    public List<DropdownBean> getDropdown() {

        DropdownDAO dropdownDAO = new DropdownDAO();
        List<DropdownBean> tagList = dropdownDAO.getLimitedResult();

        return tagList;
    }

}
