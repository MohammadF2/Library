package com.example.javafxproject;

import java.util.ArrayList;

public class MediaRental implements MediaRentalInt{

    static ArrayList<Customer> customer = new ArrayList<Customer>();
    static ArrayList<Media> media = new ArrayList<Media>();

    public ArrayList getCustomer(){
        return customer;
    }

    public String getCustomerName(String id){

        int customerPlace = -1;
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId().equals(id)) {
                customerPlace = i;
            }
        }

        return customer.get(customerPlace).getName();
    }

    public ArrayList getMedia(){
        return media;
    }


    public MediaRental() {
        super();

    }


    @Override
    public void addCustomer(String name, String address, String plan,String id,String mobileNum) {
        customer.add(new Customer(name,address,plan,id,mobileNum));
    }

    @Override
    public boolean removeCustomer(String id) {
        for (int i = 0; i < customer.size();i++){
            if (customer.get(i).getId().equals(id) == true){
                customer.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int findCustomer(String id) {
        for (int i = 0; i < customer.size();i++){
            if (customer.get(i).getId().equals(id) == true){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addMovie(String title, int copiesAvailable, String rating,String code) {
        media.add(new Movie(title,copiesAvailable,rating,code));
    }

    @Override
    public void addGame(String title, int copiesAvailable, double weight,String code) {
        media.add(new Game(title, copiesAvailable, weight,code));
    }

    @Override
    public boolean removeMedia(String code) {
        for (int i = 0; i < media.size();i++){
            if (media.get(i).getCode().equals(code)){
                media.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void addAlbum(String title, int copiesAvailable, String artist, String songs, String code) {
        media.add(new Album(title, copiesAvailable, artist, songs,code));
    }

    @Override
    public boolean mediacheackcode(String code) {
        if (media.size() == 0){
            return true;
        } else{
            for (int i = 0; i < media.size();i++){
                if (media.get(i).getCode().equals(code))
                    return false;
            }
        }
        return true;
    }

    @Override
    public int findMedia(String id) {
        for (int i = 0; i < media.size();i++){
            if (media.get(i).getCode().equals(id) == true){
                return i;
            }
        }
        return -1;
    }

    public String findMediaName(String code){
        for (int i = 0; i < media.size();i++){
            if (media.get(i).getCode().equals(code) == true){
                return media.get(i).getTitle();
            }
        }
        return null;
    }

    @Override
    public int findMovie(String id) {
        return 0;
    }

    @Override
    public boolean checkID(String id){
        if (customer.size() == 0){
            return true;
        } else {
            for (int i = 0; i < customer.size();i++){
                if (customer.get(i).getId().equals(id))
                    return false;
            }
        }
        return true;
    }

    @Override
    public String findCustomerData(String id) {
        String data = "";
        for (int i = 0; i < customer.size();i++){
            if (customer.get(i).getId().equals(id))
                data = customer.get(i).toString();
        }
        return data;
    }

    @Override
    public void setLimitedPlanLimit(int value, int place) {

    }

    @Override
    public String getAllCustomersInfo() {

        String data = "";
        if (customer.size() > 0) {
            try {
                System.out.println("=====================Customers information=====================");
                for (int i = 0; i < customer.size(); i++) {
                    data = data + customer.get(i).toString() + "\n";
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("There is no customers in the dataBase");
            }
        } else {
            System.out.println("\nThere is no customers in the dataBase");
        }

        return data;
    }

    @Override
    public String gameData(){
        String data = "";
        for (int i = 0; i < media.size();i++){
            if (media.get(i) instanceof Game){
                data = data + media.get(i).toString();
            }
        }
        return data;
    }

    @Override
    public String movieData() {
        String data = "";
        for (int i = 0; i < media.size();i++){
            if (media.get(i) instanceof Movie){
                data = data + media.get(i).toString();
            }
        }
        return data;
    }

    @Override
    public String albumData() {
        String data = "";
        for (int i = 0; i < media.size();i++){
            if (media.get(i) instanceof Album){
                data = data + media.get(i).toString();
            }
        }
        return data;
    }


    @Override
    public String getAllMediaInfo() {
        String data = "";
        if (media.size() > 0) {
            try {
                System.out.println("=====================Media information=====================");
                for (int i = 0; i < media.size(); i++) {
                    if (media.get(i) instanceof Movie) {
                        data = data + media.get(i).toString() + "\n";
                        // System.out.println("Movie name: " + media.get(i).getTitle() + " copies
                        // availble " + media.get(i).getCopiesAvailable()+ "\n");
                    } else if (media.get(i) instanceof Game) {
                        data = data + media.get(i).toString() + "\n";
                        // System.out.println("Game name: " + media.get(i).getTitle() + " copies
                        // availble " + media.get(i).getCopiesAvailable()+ "\n");
                    } else if (media.get(i) instanceof Album) {
                        data = data + media.get(i).toString() + "\n";
                        // System.out.println("Album name: " + media.get(i).getTitle() + " copies
                        // availble " + media.get(i).getCopiesAvailable()+ "\n");
                    } else {
                        System.out.println("DataBase is empty");
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Media Data is empty");
            }
        } else {
            System.out.println("\nMedia Data is empty");
        }

        return data;
    }

    @Override
    public int addToCart(String id, String code) {
        int customerPlace = -1;
        int mediaPlace = -1;
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId().equals(id)) {
                customerPlace = i;
            }
        }
        System.out.println(media.size());
        System.out.println(customer.size());

        for (int i = 0; i < media.size();i++){
            if (media.get(i).getCode().equals(code))
                mediaPlace = i;
        }

        if (customerPlace == -1) {
            System.out.println("Error: This customer is not in our database");
            return -1;
        } else if (mediaPlace == -1){
            System.out.println("Error: The code is wrong");
            return -2;
        } else if (customerPlace > -1 && mediaPlace > -1) {
            for (int i = 0; i < customer.get(customerPlace).getCart().size(); i++) {
                if (customer.get(customerPlace).getCart().size() > 0) {
                    System.out.println(customer.get(customerPlace).getCart().size());
                    if (customer.get(customerPlace).getCart().get(i).equals(media.get(mediaPlace).getTitle())) {
                        System.out.println("Error: you already have this media in your cart");
                        return -3;
                    }
                }
            }
        }

        customer.get(customerPlace).addToCart(media.get(mediaPlace).getTitle());
        System.out.println("The media was add to your cart");
        return 1;
    }

    @Override
    public int removeFromCart(String id, String code) {
        int mediaPlace = -1;
        for (int i = 0; i < media.size();i++){
            if (media.get(i).getCode().equals(code))
                mediaPlace = i;
        }
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId().equals(id)) {
                for (int j = 0; j < customer.get(i).getCart().size(); j++) {
                    if (customer.get(i).getCart().get(j).equals(media.get(mediaPlace).getTitle())) {
                        customer.get(i).removeFromCart(j);
                        System.out.println("The item was removed");
                        return 1;
                    }
                }
            }
        }
        System.out.println("We couldn't find this item in your cart");
        return -1;
    }

    @Override
    public String processRequests(String id) {
        int customerPlace = -1;
        String data = "";
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId().equals(id)) {
                customerPlace = i;
            }
        }
        if (customer.get(customerPlace).getPlan().equals("UNLIMITED")) {
            if (customer.get(customerPlace).getCart().size() > 0) {
                for (int j = 0; j < customer.get(customerPlace).getCart().size(); j++) {
                    for (int u = 0; u < media.size(); u++) {
                        if (media.get(u).getTitle().equals(customer.get(customerPlace).getCart().get(j))) {
                            if (media.get(u).getCopiesAvailable() >= 1) {
                                customer.get(customerPlace).getTook().add(media.get(u).getTitle());
                                media.get(u).setCopiesAvailable(media.get(u).getCopiesAvailable() - 1);
                                data = data + "Customer: [" + customer.get(customerPlace).getName() + "] Took: ["
                                        + media.get(u).getTitle() + "]\n";
                            }
                        }
                    }
                }
            }
        } else if (customer.get(customerPlace).getPlan().equals("LIMITED")) {
            if (customer.get(customerPlace).getCart().size() > 0) {
                for (int j = 0; j < customer.get(customerPlace).getCart().size(); j++) {
                    for (int u = 0; u < media.size(); u++) {
                        if (media.get(u).getTitle().equals(customer.get(customerPlace).getCart().get(j))) {
                            if (customer.get(customerPlace).getTook().size() < customer.get(customerPlace).getPlanLim()) {
                                if (media.get(u).getCopiesAvailable() >= 1) {
                                    customer.get(customerPlace).getTook().add(media.get(u).getTitle());
                                    media.get(u).setCopiesAvailable(media.get(u).getCopiesAvailable() - 1);
                                    data = data + "Customer: [" + customer.get(customerPlace).getName() + "] Took: ["
                                            + media.get(u).getTitle() + "]\n";
                                }
                            } else {
                                data = data + "Customer :[" + customer.get(customerPlace).getName() + "] can't take ["
                                        + media.get(u).getTitle() + "] becouse he reached the limit \n";
                                System.out.println("Customer :[" + customer.get(customerPlace).getName() + "] can't take ["
                                        + media.get(u).getTitle() + "] becouse he reached the limit \n");
                            }
                        }
                    }
                }
            }
        }
        customer.get(customerPlace).getCart().clear();
        return data;
    }

    @Override
    public boolean returnMedia(String id, String code) {
        int mediaPlace = -1;
        for (int i = 0; i < media.size();i++){
            if (media.get(i).getCode().equals(code))
                mediaPlace = i;
        }
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId().equals(id)) {
                if (customer.get(i).getTook().size() > 0) {
                    for (int j = 0; j < customer.get(i).getTook().size(); j++) {
                        if (customer.get(i).getTook().get(j).equals(media.get(mediaPlace).getTitle())) {
                            for (int u = 0; u < media.size(); u++) {
                                if (media.get(u).getTitle().equals(media.get(mediaPlace).getTitle())) {
                                    media.get(u).setCopiesAvailable(media.get(u).getCopiesAvailable() + 1);
                                    customer.get(i).getTook().remove(j);
                                    System.out.println("Customer: [" + customer.get(i).getName() + "]  returned: ["
                                            + media.get(mediaPlace).getTitle() + "]\n");
                                    return true;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("This customer didn't take anything");
                }

            }
        }
        System.out.println("An error has occurred please check your data again");
        return false;
    }

    @Override
    public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
        return null;
    }
}
