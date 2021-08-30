package com.example.cem_lab02_myvehicleapp;


public class Vehicle {
    // attributes
    private String make;
    private int year;
    private String message;

    // global counter to count number of Vehicle objects created
    public static int counter = 0;

    public Vehicle() {   // default constructor
        this.make = "Tesla";
        this.year = 2021;
        this.message = "Default Make/Year => Make: " + make + ", Year: " + year;
        addToCounter();
    }

    public Vehicle(String make) {
        this.make = make;
        this.year = 2021;  // give default year
        this.message = "Make Given as: " + make + ", Year Defaulted to: " + year;
        addToCounter();
    }

    public Vehicle(String make, int year) {
        this.make = make;
        this.year = year;
        this.message = "Your Car is a " + make + " built in year " + year + ".";
        addToCounter();
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getMessage() {
        return message;
    }

    private void addToCounter() {
        counter++;  // count the number of Cars
    }

    @Override
    public String toString() {
        return message;
    }
}