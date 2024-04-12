package org.example.steampowered.pojo;

public class Category {
    
    private int id;
    private String description;


    public Category(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
