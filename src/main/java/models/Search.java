package models;

public class Search {

    private String searchInput;
    private String dropdownValue;
    private int pageNumb;

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

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }
}

