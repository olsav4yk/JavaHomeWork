package com.pb.savchuk.hw6;

import java.util.Objects;

public class Cat extends Animal{
    protected String breed;

    public Cat() {
        super("Cat", "fish", "meow", "catbasket");
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
        return "breed: " + breed + " food: " + food + " location: " + location;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(breed, cat.breed);
    }
    @Override
    public int hashCode() {
        return Objects.hash(breed);
    }

}
