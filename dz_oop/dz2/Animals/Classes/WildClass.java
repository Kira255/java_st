package dz_oop.dz2.Animals.Classes;

public class WildClass extends dz_oop.dz2.Animals.Classes.Animals {
    protected String habitat;
    protected String datesOfFinding;

    protected WildClass(String type, Double height, Double weight, String eyeColor, String habitat,
            String datesOfFinding) {
        super(type, height, weight, eyeColor);
        this.habitat = habitat;
        this.datesOfFinding = datesOfFinding;
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s, Height: %f, Weight: %f, Eye color: %s, Habitat: %s, Date of finding: %s.",
                this.type, this.height, this.weight, this.eyeColor,
                this.habitat, this.datesOfFinding);
    }
}
