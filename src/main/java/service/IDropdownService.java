package service;

import beans.DropdownBean;

import java.util.List;

public interface IDropdownService {

    List<DropdownBean> getDropdown(List<DropdownBean> tagList);
}
