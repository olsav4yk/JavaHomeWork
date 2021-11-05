package com.pb.savchuk.hw6;

public class Animal {
    protected String food;
    protected String location;
    protected String type;
    protected String noise;
    public Animal(String type, String food, String noise, String location) {
        this.type = type;
        this.food = food;
        this.noise = noise;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public void makeNoise(){

    }
    public void eat(){

    }
    public void sleep(){

        System.out.println(type + " is sleeping in the " + location);
    }
}
