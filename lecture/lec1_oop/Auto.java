package lec1_oop;

public class Auto extends Transport {

    public Auto(String color, String model, Integer wheels, Integer weight, Integer speed) {
        super(color, model, wheels, weight, speed);
    }

    public Auto() {
        super("white", "sedan", 4, 1500, 150);
    }
}
