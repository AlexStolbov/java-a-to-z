package ru.astolbov.Models;

/**
 * Item
 * Задача
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
    private long createDate;

    /**
     * Line separator.
     */
    private String lineseparator = System.getProperty("line.separator");

    public Item() {
        this.createDate = System.currentTimeMillis();
    }

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
        for (int i = 0; i < comments.length; i++) {
            if (comments[i] == null) {
                comments[i] = new Comment();
                comments[i].setComment(commentText);
            }
        }
    }

    /**
     * Getter comments.
     * @return - array of comments
     */
    public Comment[] getComments() {
        return comments;
    }

    /**
     * The string representation of the Item.
     */
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Id: ");
        stringBuffer.append(this.id);
        stringBuffer.append(". Name: ");
        stringBuffer.append(this.name);
        stringBuffer.append(". Create date: ");
        stringBuffer.append(this.createDate);
        if (this.description != null) {
            stringBuffer.append(". Description: ");
            stringBuffer.append(this.description);
        }

        for (Comment comment:getComments()) {
            if (comment != null) {
                stringBuffer.append(lineseparator);
                stringBuffer.append("   comments: ");
                stringBuffer.append(comment.getCommentText());
            }
        }

        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
