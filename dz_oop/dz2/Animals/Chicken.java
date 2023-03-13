package dz_oop.dz2.Animals;

import dz_oop.dz2.Animals.Classes.Bird;

public class Chicken extends Bird {
    public Chicken(String type, Double height, Double weight, String eyeColor) {
        super(type, height, weight, eyeColor);
    }

    public Chicken() {
        super("Chiken", 0.1, 1.5, "Black");
    }

    @Override
    public String getFly() {
        return String.format("Я лечу на %f метрах, где %f - высота полёта.", heightFly, heightFly);
    }

    @Override
    public void getSound() {
        System.out.println("Сheep-cheep");
    }
}