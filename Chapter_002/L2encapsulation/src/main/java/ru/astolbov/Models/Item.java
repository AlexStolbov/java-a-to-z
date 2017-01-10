package ru.astolbov.Models;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

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
     * Constructor.
     */
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
     * Getter createDate.
     * @return - createDate
     */
    public long getCreateDate() {
        return createDate;
    }

    /**
     * Return createDate as string.
     * @return date in human format
     */
    public String createDateAsString() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(this.createDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

        return sdf.format(gregorianCalendar.getTime());
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
                break;
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
     * @return the string representation of the menu
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Id: ".concat(this.id).concat(". "));
        stringBuffer.append("Name: ".concat(this.name).concat(". "));
        stringBuffer.append("Create date: ".concat(createDateAsString()).concat(". "));
        if (this.description != null) {
            stringBuffer.append("Description: ".concat(this.description).concat(". "));
        }
        for (Comment comment:getComments()) {
            if (comment != null) {
                stringBuffer.append(System.lineSeparator());
                stringBuffer.append(" comments: ");
                stringBuffer.append(comment.getCommentText());
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
