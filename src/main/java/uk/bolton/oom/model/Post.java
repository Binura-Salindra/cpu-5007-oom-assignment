package uk.bolton.oom.model;

import uk.bolton.oom.enums.ObserverUpdateContentType;

public class Post extends ObserverUpdateContent{

    private String postContent;

    public Post() {
    }

    public Post(ObserverUpdateContentType observerUpdateContent, String name, String postContent) {
        super(observerUpdateContent, name);
        this.postContent = postContent;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postContent='" + postContent + '\'' +
                '}';
    }
}
