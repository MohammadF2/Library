package com.example.javafxproject;

import java.util.ArrayList;

public interface MediaRentalInt {


    void addCustomer(String name,String address,String plan,String id,String mobileNum);
    boolean removeCustomer(String id);
    int findCustomer(String id);
    boolean checkID(String id);
    String findCustomerData(String id);
    void addMovie(String title, int copiesAvailable,String rating,String code);
    void addGame(String title, int copiesAvailable,double weight,String code);
    boolean removeMedia(String code);
    void addAlbum(String title,int copiesAvailable,String artist,String songs,String code);
    boolean mediacheackcode(String code);
    int findMedia(String id);
    int findMovie(String id);
    String gameData();
    String movieData();
    String albumData();
    void setLimitedPlanLimit(int value, int place);
    String getAllCustomersInfo();
    String getAllMediaInfo();
    int addToCart(String id, String code);
    int removeFromCart(String customerName, String mediaTitle);
    String processRequests(String id);
    boolean returnMedia(String customerName,String mediaTitle);
    ArrayList<String> searchMedia(String title, String rating, String artist, String songs);

}
