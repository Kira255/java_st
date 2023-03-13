package dz_oop.dz2.Animals;

import dz_oop.dz2.Animals.Classes.PetClass;
import dz_oop.dz2.Animals.Interfaces.Traning;

public class Dog extends PetClass implements Traning {

    protected String training;

    public Dog(String type, String name, String breed, Double height, Double weight, String eyeColor, String color,
            String vaccinations, String dateOfBirth, String training) {
        super(type, name, breed, height, weight, eyeColor, color, vaccinations, dateOfBirth);
        this.training = training;
    }

    public Dog() {
        super("Dog", "Jack", "German shepherd", 60.5, 30.5, "Brown", "Brown", "Yes", "11.11.22");
        training = "Yes";
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Name: %s, Breed: %s, Height: %f, Weight: %f, Eye color: %s, Color: %s, Vaccinations: %s, Date of birth: %s, Training: %s.",
                this.type, this.name,
                this.breed, this.height, this.weight, this.eyeColor, this.color,
                this.vaccinations, this.dateOfBirth, this.training);
    }

    public String getTraning() {
        return "In the process";
    }

    @Override
    public void getSound() {
        System.out.println("Woof");
    }

    @Override
    public void getWeasel() {
        System.out.println("Show affection");
    }

}
