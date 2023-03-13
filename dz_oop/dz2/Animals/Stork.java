package dz_oop.dz2.Animals;

import dz_oop.dz2.Animals.Classes.Bird;

public class Stork extends Bird {
    public Stork(String type, Double height, Double weight, String eyeColor) {
        super(type, height, weight, eyeColor);
    }

    public Stork() {
        super("Stork", 125.5, 4.5, "Black");
    }

    @Override
    public String getFly() {
        return String.format("Я лечу на %f метрах, где %f - высота полёта.", heightFly, heightFly);
    }

    @Override
    public void getSound() {
        System.out.println("Сrow-crow");
    }
}
