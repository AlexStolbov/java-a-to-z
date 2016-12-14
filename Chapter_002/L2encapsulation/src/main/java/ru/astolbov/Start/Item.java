package ru.astolbov.Start;

import ru.astolbov.Start.Comment;

/**
 * Item
 * Created by alex on 12/13/16.
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private Comment[] comments = new Comment[5];
    private int createDate;
    private int lastPositionComment = 0;

    /**
     * Setter id
     * @param setid
     */
    public void setId(String setid){
        this.id = setid;
    }

    /**
     * Getter id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Add new comment into comments
     * @param commentText
     */
    public void addComment(String commentText) {
        if (lastPositionComment < comments.length) {
            comments[lastPositionComment] = new Comment();
            comments[lastPositionComment].setComment(commentText);
            lastPositionComment++;
        }
    }

    /**
     * Getter comments
     */
    public Comment[] getComments() {
        return comments;
    }
}
