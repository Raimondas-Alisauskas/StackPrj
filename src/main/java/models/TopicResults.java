package models;

import java.util.List;

public class TopicResults {

    private List<TopicBin> topicsList;
    private String searchInput;
    private int pageNumb;
    private int numbOfRecords;

    public TopicResults(List<TopicBin> topicsList, String searchInput, int pageNumb, int numbOfRecords) {
        this.topicsList = topicsList;
        this.searchInput = searchInput;
        this.pageNumb = pageNumb;
        this.numbOfRecords = numbOfRecords;
    }

    public List<TopicBin> getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(List<TopicBin> topicsList) {
        this.topicsList = topicsList;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }

    public int getNumbOfRecords() {
        return numbOfRecords;
    }

    public void setNumbOfRecords(int numbOfRecords) {
        this.numbOfRecords = numbOfRecords;
    }
}
