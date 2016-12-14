package ru.astolbov.Models;

/**
 * Item
 * Created by alex on 12/13/16.
 */
public class Item {

    /**
     * Unique identifier.
     */
    private String id;
    /**
     * The name of the item.
     */
    private String name;
    /**
     * The description of the item.
     */
    private String description;
    /**
     * Array of comment of the items.
     */
    private Comment[] comments = new Comment[5];
    /**
     * Date create.
     */
    private int createDate;
    /**
     * Last comment.
     */
    private int lastPositionComment = 0;

    /**
     * Setter id.
     * @param setid - id for set
     */
    public void setId(String setid) {
        this.id = setid;
    }

    /**
     * Getter id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter name.
     * @param setname - name for set
     */
    public void setName(String setname) {
        this.name = setname;
    }

    /**
     * Getter name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter description.
     * @param setdescription - description
     */
    public void setDescription(String setdescription) {
        this.description = setdescription;
    }

    /**
     * Getter description.
     * @return - description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Add new comment into comments.
     * @param commentText - text of comment
     */
    public void addComment(String commentText) {
        if (lastPositionComment < comments.length) {
            comments[lastPositionComment] = new Comment();
            comments[lastPositionComment].setComment(commentText);
            lastPositionComment++;
        }
    }

    /**
     * Getter comments.
     * @return - array of comments
     */
    public Comment[] getComments() {
        return comments;
    }
}
