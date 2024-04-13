package org.example.steampowered.pojo;


public class Category {
    
    private String id;
    private String description;

    public Category(){

    }

    public Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
