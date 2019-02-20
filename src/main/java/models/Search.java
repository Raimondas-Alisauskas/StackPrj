package models;

public class Search {

    private String searchInput;
    private String dropdownValue;

    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Search(String s, String d) {
        super();
        searchInput = s;
        dropdownValue = d;
    }

    public String getSearchInput() {

        return searchInput;
    }

    public void setSearchInput(String s) {

        searchInput = s;
    }

    public String getDropdownValue() {
        return dropdownValue;
    }

    public void setDropdownValue(String d) {

        dropdownValue = d;
    }
}

