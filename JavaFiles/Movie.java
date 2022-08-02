package com.example.javafxproject;

public class Movie extends Media {

    private String title;
    private int copiesAvailable;
    private String rating;

    public Movie(String title, int copiesAvailable, String rating, String code) {
        super();
        this.title = title;
        this.copiesAvailable = copiesAvailable;
        this.rating = rating;
        super.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {

        return "Media code:" + code + "\nMovie title: " + title + ", Copies Available: " +  copiesAvailable + ", Rating: " + rating + "\n---------------------------------------------------------\n";

    }

    public Movie() {
        super();
    }

}

