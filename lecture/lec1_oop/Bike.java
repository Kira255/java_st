package lec1_oop;

public class Bike extends Truck {
    public Bike(String color, String model, Integer wheels, Integer weight, Integer speed) {
        super(color, model, wheels, weight, speed);
    }

    public Bike() {
        super("blue", "Stels", 2, 12, 35);
    }
}
