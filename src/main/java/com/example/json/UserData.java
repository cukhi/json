package com.example.json;

import com.google.gson.annotations.SerializedName;

public class UserData {


    @SerializedName("author")
    public String author;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("date")
    public String date;
    @SerializedName("content")
    public String content;
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserData(String title,String description,String  date, String content, String author){
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
        this.content = content;
    }
}
