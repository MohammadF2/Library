package com.example.javafxproject;

import java.util.ArrayList;

public class Customer extends Media implements Comparable {

    private String address;
    private String plan;
    private int planLim;
    private String id;
    private String mobileNum;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    private ArrayList<String> cart;
    private ArrayList<String> took;


    public Customer(String name, String address, String plan,String id, String mobileNum) {
        super();
        super.name = name;
        this.address = address;
        this.plan = plan;
        this.planLim = 2;
        this.mobileNum = mobileNum;
        this.id = id;
        cart = new ArrayList<String>();
        took = new ArrayList<String>();
    }


    public ArrayList<String> getTook() {
        return took;
    }


    public ArrayList<String> getCart() {
        return cart;
    }


    public int getPlanLim() {
        return planLim;
    }


    public void setPlanLim(int planLim) {
        this.planLim = planLim;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void addToCart(String r) {
        cart.add(r);
    }

    public void removeFromCart(int r) {
        cart.remove(r);
    }


    public String toString() {
        return "Customer Id: " + id + "\nName: " + name + ", Address: " + address + ", Plan: " + plan + "\nMobile number: " + mobileNum +  "\nItems is the cart: " + cart + "\nItem he rented: " + took +"\n -------------------------------------------------------------";
    }


    @Override
    public int compareTo(Object o) {
        Customer nCustomer = (Customer) o;
        return this.name.compareTo(nCustomer.getName());
    }
}