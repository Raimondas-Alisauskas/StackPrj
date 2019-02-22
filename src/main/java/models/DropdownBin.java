package models;

public class DropdownBin {

    private int Id;
    private String Tag;
    private String Title;
    private int HelloWorldDocTopicId;
    private int TopicCount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getHelloWorldDocTopicId() {
        return HelloWorldDocTopicId;
    }

    public void setHelloWorldDocTopicId(int helloWorldDocTopicId) {
        HelloWorldDocTopicId = helloWorldDocTopicId;
    }

    public int getTopicCount() {
        return TopicCount;
    }

    public void setTopicCount(int topicCount) {
        TopicCount = topicCount;
    }
}