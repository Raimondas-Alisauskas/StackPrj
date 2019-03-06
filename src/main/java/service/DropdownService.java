package service;

import DAO.DropdownDAO;
import beans.DropdownBean;

import java.util.List;

public class DropdownService implements IDropdownService {

    @Override
    public List<DropdownBean> getDropdown(List<DropdownBean> tags) {

        if (tags == null || tags.isEmpty()) {
            DropdownDAO dropdownDAO = new DropdownDAO();
            return dropdownDAO.getLimitedResult();

        } else {
            return tags;
        }

    }
}
