package models.DTO;

public class SearchDTO {

    private String searchInput;
    private String tagId;
    private int pageNumb;

    public SearchDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SearchDTO(String s, String d) {
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String d) {

        tagId = d;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }
}

