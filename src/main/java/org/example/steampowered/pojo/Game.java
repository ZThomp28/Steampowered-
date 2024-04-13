package org.example.steampowered.pojo;

import java.util.HashMap;


public class Game {

    private String appId;
    private String name;
    private String imgIconURL;    
    private String shortDescription;
    private HashMap<String, Category> categories;
    private HashMap<String, Genre> genres;

    public Game(){

    }

    public Game(String appId, String name, String imgIconURL, String shortDescription) {
        this.appId = appId;
        this.name = name;
        this.imgIconURL = imgIconURL;       
        this.shortDescription = shortDescription;
        this.categories = new HashMap<String, Category>();
        this.genres = new HashMap<String, Genre>();
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgIconURL() {
        return this.imgIconURL;
    }

    public void setImgIconURL(String imgIconURL) {
        this.imgIconURL = imgIconURL;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public HashMap<String, Category> getCategories(){
        return this.categories;
    }

    public void addCategory(Category category) {
        this.categories.put(category.getId(), category);
    }

    public void addCategoryMap(HashMap<String, Category> categories) {
        this.categories.putAll(categories);
    }

    public HashMap<String, Genre> getGenres() {
        return this.genres;
    }

    public void addGenre(Genre genre) {
        this.genres.put(genre.getId(), genre);
    }

    public void addGenreMap(HashMap<String, Genre> genres) {
        this.genres.putAll(genres);
    }
    
}
