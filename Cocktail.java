package com.example.javafx_api.model;

public class Cocktail {
    private String name; // Changed from "label" to "name"
    private String image;
    private String source;
    private String url;
    private String instructions; // Changed from "calories" to "instructions"

    public Cocktail(String name, String image, String source, String url, String instructions) {
        this.name = name;
        this.image = image;
        this.source = source;
        this.url = url;
        this.instructions = instructions; // Updated to "instructions"
    }

    public String getName() {
        return name; // Updated to "name"
    }

    public void setName(String name) {
        this.name = name; // Updated to "name"
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInstructions() { // Updated to "getInstructions"
        return instructions;
    }

    public void setInstructions(String instructions) { // Updated to "setInstructions"
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.instructions; // Updated to include "name" and "instructions"
    }
}
