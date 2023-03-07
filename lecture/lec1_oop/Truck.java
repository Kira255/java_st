package lec1_oop;

public class Truck extends Moto {
    public Truck(String color, String model, Integer wheels, Integer weight, Integer speed) {
        super(color, model, wheels, weight, speed);
    }

    public Truck() {
        super("grey", "Man", 18, 9000, 100);
    }
}
