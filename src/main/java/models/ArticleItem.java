package models;

import java.util.List;

public class ArticleItem {

    private String title;
    private String question;
    private List<String> answers;

    public ArticleItem() {
        super();
    }

    public ArticleItem(String title, String question, List<String> answers) {
        super();
        this.title = title;
        this.question = question;
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
