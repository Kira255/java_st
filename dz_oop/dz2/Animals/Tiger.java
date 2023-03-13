package dz_oop.dz2.Animals;

import dz_oop.dz2.Animals.Classes.WildClass;

public class Tiger extends WildClass {
    public Tiger(String type, Double height, Double weight, String eyeColor, String habitat, String datesOfFinding) {
        super(type, height, weight, eyeColor, habitat, datesOfFinding);
    }

    public Tiger() {
        super("Tiger", 100.5, 300.5, "Green", "Russia", "Around 3 900 000 years ago");
    }

    @Override
    public void getSound() {
        System.out.println("R-r-r-r");
    }
}
