package com.example.test38;

public class Chat {
   //variables
    private String name;
    private String state;
    private String image;

    public Chat() {
    }

    //constructors
    public Chat(String name, String state, String image) {
        this.name = name;
        this.state = state;
        this.image = image;
    }

    //setter and getters


    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
