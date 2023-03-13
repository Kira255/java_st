package dz_oop.dz2.Animals.Classes;

import dz_oop.dz2.Animals.Interfaces.Sound;

public class Animals implements Sound {
    protected String type;
    protected Double height;
    protected Double weight;
    protected String eyeColor;

    protected Animals(String type, Double height, Double weight, String eyeColor) {
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Height: %f, Weight: %f, Eye color: %s.",
                this.type, this.height, this.weight, this.eyeColor);
    }

    public String getType() {
        return this.type;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWeight() {
        return this.weight;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setValues(String type, String name, String breed, Double height, Double weight, String eyeColor,
            String color,
            String vaccinations, String dateOfBirth) {
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

}
