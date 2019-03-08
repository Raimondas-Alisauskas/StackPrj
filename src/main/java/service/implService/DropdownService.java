package service.implService;

import service.database.DAO.implDAO.DropdownDAO;
import model.beans.DropdownBean;
import service.IService.IDropdownService;

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
