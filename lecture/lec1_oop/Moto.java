package lec1_oop;

public class Moto extends Auto {
    public Moto(String color, String model, Integer wheels, Integer weight, Integer speed) {
        super(color, model, wheels, weight, speed);
    }

    public Moto() {
        super("black", "Yamaha", 2, 200, 100);
    }

}
