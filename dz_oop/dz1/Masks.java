package dz_oop.dz1;

public class Masks extends Hygiene {
    public Masks(String name, Integer price, Integer quantity, String unit, Integer amount) {
        super(name, price, quantity, unit, amount);
    }

    public Masks() {
        super("Маска", 95, 30, "шт.", 1);
    }
}
