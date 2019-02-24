package models;

public class Result {

    private String searchInput;
    private String title;
    private int pageNumb;
    private int numbOfRecords;

    public Result() {
    }

    public Result(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public int getNumbOfRecords() {
        return numbOfRecords;
    }

    public void setNumbOfRecords(int numbOfRecords) {
        this.numbOfRecords = numbOfRecords;
    }
}
