package dz_oop.dz2.Animals.Classes;

import dz_oop.dz2.Animals.Interfaces.Pet;

public class PetClass extends Animals implements Pet {

    protected String name;
    protected String breed;
    protected String vaccinations;
    protected String color;
    protected String dateOfBirth;

    protected PetClass(String type, String name, String breed, Double height, Double weight, String eyeColor,
            String color,
            String vaccinations, String dateOfBirth) {
        super(type, height, weight, eyeColor);
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.color = color;
        this.vaccinations = vaccinations;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Name: %s, Breed: %s, Height: %f, Weight: %f, Eye color: %s, Color: %s, Vaccinations: %s, Date of birth: %s.",
                this.type, this.name,
                this.breed, this.height, this.weight, this.eyeColor, this.color,
                this.vaccinations, this.dateOfBirth);
    }
}
