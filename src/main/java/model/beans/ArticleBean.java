package model.beans;

public class ArticleBean {

    private int id;
    private String title;
    private int creationDate;
    private String example;

    public ArticleBean() {
    }

    public ArticleBean(int id, String title, int creationDate, String example) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
