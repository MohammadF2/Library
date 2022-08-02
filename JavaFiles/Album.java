package com.example.javafxproject;

public class Album extends Media{

    private String artist;
    private String songs;

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public Album(String title, int copiesAvailable, String artist, String songs,String code) {
        super();
        this.title = title;
        this.copiesAvailable = copiesAvailable;
        this.artist = artist;
        this.songs = songs;
        super.code = code;
    }

    public String toString() {

        return "Media code:" + code + "\nAlbum title: " + title + ", Copies Available: " + copiesAvailable + ", Artist: " + artist + ", Songs: " + songs + "\n---------------------------------------------------------\n";

    }


    public Album() {
        super();
    }
}
