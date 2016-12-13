package ru.astolbov.Start;

/**
 * Created by alex on 12/13/16.
 */
public class Comment {
    private String id;
    private String commentText;

    public void setId(String setId){
        this.id = setId;
    }

    public String getId(){
        return this.id;
    }

    public void setComment(String setCommentText){
        this.commentText = setCommentText;
    }

    public String getComment(){
        return this.commentText;
    }
}
