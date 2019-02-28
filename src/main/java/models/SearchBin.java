package models;

public class SearchBin {

    private String searchInput;
    private int tagId;
    private int pageNumb;

    public SearchBin() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SearchBin(String s, int d) {
        super();
        searchInput = s;
        tagId = d;
    }

    public String getSearchInput() {

        return searchInput;
    }

    public void setSearchInput(String s) {

        searchInput = s;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int d) {

        tagId = d;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }
}

