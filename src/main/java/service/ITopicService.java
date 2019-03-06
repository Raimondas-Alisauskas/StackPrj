package service;

import DTO.TopicDTO;
import beans.DropdownBean;

import java.util.List;

public interface ITopicService {

    TopicDTO getTopics(String tagID, String search_field, String page_num);

}
