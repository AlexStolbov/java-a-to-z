package ru.astolbov.Start;

import ru.astolbov.Start.Comment;

/**
 * Created by alex on 12/13/16.
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private Comment[] comments;
    private int createDate;

    public Item(String setid, String setname){
        this.id = setid;
        this.name = setname;
    }

}
