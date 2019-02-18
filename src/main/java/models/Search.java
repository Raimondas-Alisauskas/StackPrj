package models;

public class Search {

    private String searchInput;
    private String dropdownValue;

    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Search(String searchInput, String dropdownValue) {
        super();
        this.searchInput = searchInput;
        this.dropdownValue = dropdownValue;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public String getDropdownValue() {
        return dropdownValue;
    }

    public void setDropdownValue(String dropdownValue) {
        this.dropdownValue = dropdownValue;
    }
}

