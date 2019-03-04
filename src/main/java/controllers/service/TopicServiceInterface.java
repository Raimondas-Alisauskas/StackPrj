package controllers.service;

import models.DTO.TopicDTO;
import models.beans.DropdownBean;

import java.util.List;

public interface TopicServiceInterface {

    TopicDTO getTopics(String tagID, String search_field, String page_num);

    List<DropdownBean> getDropdown();

}
