package dz_oop.dz2.Animals;

import dz_oop.dz2.Animals.Classes.WildClass;

public class Wolf extends WildClass {

    protected String leader;

    public Wolf(String type, Double height, Double weight, String eyeColor, String habitat, String datesOfFinding,
            String leader) {
        super(type, height, weight, eyeColor, habitat, datesOfFinding);
        this.leader = leader;
    }

    public Wolf() {
        super("Wolf", 80.5, 60.5, "Yellow", "Russia", "Around 1 800 000 years ago");
        leader = "No";
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Height: %f, Weight: %f, Eye color: %s, Habitat: %s, Date of finding: %s, Leader: %s.",
                this.type, this.height, this.weight, this.eyeColor,
                this.habitat, this.datesOfFinding, this.leader);
    }

    @Override
    public void getSound() {
        System.out.println("Owooooooo");
    }
}
