package com.pb.savchuk.hw6;

import java.util.Objects;

public class Horse extends Animal {
    protected int spead;

    public Horse() {
        super("Horse", "oats", "neigh", "stable");
    }

    @Override
    public void makeNoise(){
        System.out.println(type + " is making noise: \"" + noise +  "\"");
    }

    @Override
    public String toString() {
        return "spead: " + spead + " food: " + food + " location: " + location;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return spead == horse.spead;
    }
    @Override
    public int hashCode() {
        return Objects.hash(spead);
    }
}
