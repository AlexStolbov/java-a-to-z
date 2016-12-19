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
    public void whenAddCommenteThenGetComment() {
        Item item = new Item();
        String commentText = "this is first comment";
        item.addComment(commentText);
        Comment[] comments = item.getComments();
        boolean findCommentText = false;
        for (Comment currenrComment: comments) {
            if (currenrComment.getCommentText().equals(commentText)) {
                findCommentText = true;
                break;
            }
        }
        assertThat(findCommentText, is(true));
    }
}
