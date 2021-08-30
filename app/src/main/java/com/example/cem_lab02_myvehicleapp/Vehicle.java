package com.example.cem_lab02_myvehicleapp;


public class Vehicle {
    // attributes
    private String make;
    private int year;
    private String message;
    private String colour;
    private int engineCapacity;

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

    public Vehicle(String make, int year, String colour, int engineCapacity) {
        this(make, year);
        this.colour = colour;
        this.engineCapacity = engineCapacity;
        this.message += "\n-- Colour: " + colour + " and has capacity of " + engineCapacity + " cc";
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

    public String getColour() {
        return colour;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public static int getCounter() {
        return counter;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return message;
    }
}