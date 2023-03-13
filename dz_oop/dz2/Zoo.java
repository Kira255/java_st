package dz_oop.dz2;

import dz_oop.dz2.Animals.Classes.Animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dz_oop.dz2.Animals.Cat;
import dz_oop.dz2.Animals.Chicken;
import dz_oop.dz2.Animals.Dog;
import dz_oop.dz2.Animals.Stork;
import dz_oop.dz2.Animals.Tiger;
import dz_oop.dz2.Animals.Wolf;

public class Zoo {

    public static Animals[] addCat(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.add(new Cat());
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] addDog(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.add(new Dog());
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] addWolf(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.add(new Wolf());
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] addTiger(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.add(new Tiger());
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] addChiken(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.add(new Chicken());
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] addStork(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.add(new Stork());
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] removeIndex(Animals[] animals, int index) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        list.remove(index);
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] getIndex(Animals[] animals, int index) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        System.out.println(list.get(index));
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] getIndexSound(Animals[] animals, int index) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        Animals someone = list.get(index);
        someone.getSound();
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] printAll(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        for (Animals animal : list)
            System.out.println(animal);
        System.out.println();
        return list.toArray(new Animals[0]);
    }

    public static Animals[] getAllSound(Animals[] animals) {
        List<Animals> list = new ArrayList<>(Arrays.asList(animals));
        for (Animals animal : list)
            animal.getSound();
        System.out.println();
        return list.toArray(new Animals[0]);
    }
}