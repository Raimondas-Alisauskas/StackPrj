package service.implService;

import service.database.DAO.implDAO.TopicDAO;
import model.DTO.SearchDTO;
import model.DTO.TopicDTO;
import service.IService.ITopicService;

public class TopicService implements ITopicService {

    @Override
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

}