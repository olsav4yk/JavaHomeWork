package com.pb.savchuk.hw6;

import java.util.Objects;

public class Dog extends Animal{
    protected  String scent;
    public Dog() {
        super("Dog", "meat", "woof, woof", "doghouse");
    }
    @Override
    public void makeNoise(){
        System.out.println(type + " is making noise: \"" + noise +  "\"");
    }
    @Override
    public void eat(){
        System.out.println(type + " is eating " + food);
    }

    @Override
    public String toString() {
        return "scent: " + scent + " food: " + food + " location: " + location;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(scent, dog.scent);
    }
    @Override
    public int hashCode() {
        return Objects.hash(scent);
    }
}
