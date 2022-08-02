package com.example.javafxproject;

public class Game extends Media {
    private double weight;

    public Game(String title, int copiesAvailable, double weight,String code) {
        super();
        super.title = title;
        super.copiesAvailable = copiesAvailable;
        this.weight = weight;
        super.code = code;
    }

    public String getTitle() {
        return title;
    }

    public Game() {
        super();
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Media code: " + code + "\nGame title: "+title + "\nCopies Available: " + copiesAvailable + ", Weight: " + weight ;
    }

}