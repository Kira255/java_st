package dz_oop.dz2.Animals.Classes;

import dz_oop.dz2.Animals.Interfaces.flyHeight;

public abstract class Bird extends dz_oop.dz2.Animals.Classes.Animals implements flyHeight {

    protected Bird(String type, Double height, Double weight, String eyeColor) {
        super(type, height, weight, eyeColor);
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Height: %f, Weight: %f, Eye color: %s.",
                this.type, this.height, this.weight, this.eyeColor);
    }
}
