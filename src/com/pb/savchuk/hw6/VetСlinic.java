package com.pb.savchuk.hw6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static com.pb.savchuk.hw6.Veterinarian.treatAnimal;

public class VetСlinic {

    public static void main(String[] args) throws Exception {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();

        dog.sleep();
        dog.eat();
        dog.makeNoise();

        System.out.println("");

        Animal[] animals = new Animal[]{dog, cat, horse};
        for (Animal c: animals){

            treatAnimal (c);
        }
        Class clazz = Class.forName("com.pb.savchuk.hw6.Veterinarian");
        Constructor constr = clazz.getConstructor(new Class[] {String.class});
        Object obj = constr.newInstance("Ibolit");


    }
}
