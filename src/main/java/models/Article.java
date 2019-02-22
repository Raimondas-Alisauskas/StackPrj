package models;

public class Article {

    private int id;
    private String title;
    private int creationDate;

    public Article() {
    }

    public Article(int id, String title, int creationDate) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
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
}
