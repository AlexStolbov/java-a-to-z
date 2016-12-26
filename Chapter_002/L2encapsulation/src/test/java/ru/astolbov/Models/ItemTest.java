package ru.astolbov.Models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/19/16.
 */
public class ItemTest {
    /**
     * Test set and get items id.
     */
    @Test
    public void whenSetItemsIdThenGetItemsId() {
        String id = "3475";
        Item item = new Item();
        item.setId(id);
        assertThat(item.getId().equals(id), is(true));
    }

    /**
     * Test set and get items name.
     */
    @Test
    public void whenSetItemsNameThenGetItemsName() {
        String name = "Test Item class";
        Item item = new Item();
        item.setName(name);
        assertThat(item.getName().equals(name), is(true));
    }

    /**
     * Test set and get items name.
     */
    @Test
    public void whenAddCommentThenGetComment() {
        Item item = new Item();
        String commentText = "one comment";
        item.addComment(commentText);
        item.addComment("two comment");
        item.addComment("three comment");
        item.addComment("four comment");
        item.addComment("five comment");
        item.addComment("six comment");
        Comment[] comments = item.getComments();
        boolean findCommentText = false;
        for (Comment currentComment: comments) {
            if (currentComment.getCommentText().equals(commentText)) {
                findCommentText = true;
                break;
            }
        }
        assertThat(findCommentText, is(true));
    }

    @Test
    public void whenToStringThenReturnAllFields() {
        Item item = new Item();
        item.setName("one task");
        item.addComment("one comment");
        String toString = item.toString();
        String well = "Id: null. Name: one task. Create date: ".concat(item.get)
        1482776535361 comments: one comment";
        assertThat(toString, is(well));
    }
}
