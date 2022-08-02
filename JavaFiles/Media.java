package com.example.javafxproject;

public abstract class Media   {

    protected String title;
    protected int copiesAvailable;
    protected String name;
    protected String code;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract String toString();

}
