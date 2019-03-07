package model.beans;

public class ArticleBean {

    private String example;
    private String title;
    private String bodyMarkdown;

    public ArticleBean(String example, String title, String bodyMarkdown) {
        this.example = example;
        this.title = title;
        this.bodyMarkdown = bodyMarkdown;
    }

    public String getExample() {
        return example;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyMarkdown() {
        return bodyMarkdown;
    }

}
