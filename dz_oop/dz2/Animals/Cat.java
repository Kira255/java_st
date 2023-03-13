package dz_oop.dz2.Animals;

import dz_oop.dz2.Animals.Classes.PetClass;

public class Cat extends PetClass {

    protected String coat;

    public Cat(String type, String name, String breed, Double height, Double weight, String eyeColor, String color,
            String vaccinations, String dateOfBirth, String coat) {
        super(type, name, breed, height, weight, eyeColor, color, vaccinations, dateOfBirth);
        this.coat = coat;
    }

    public Cat() {
        super("Cat", "Murka", "Siamese cat", 24.5, 4.5, "Green", "White", "Yes", "24.01.23");
        coat = "Yes";
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Name: %s, Breed: %s, Height: %f, Weight: %f, Eye color: %s, Color: %s, Vaccinations: %s, Date of birth: %s, Coat: %s.",
                this.type, this.name,
                this.breed, this.height, this.weight, this.eyeColor, this.color,
                this.vaccinations, this.dateOfBirth, this.coat);
    }

    @Override
    public void getSound() {
        System.out.println("Meow");
    }

    @Override
    public void getWeasel() {
        System.out.println("Show affection");
    }
}
