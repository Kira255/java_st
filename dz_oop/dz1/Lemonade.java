package dz_oop.dz1;

public class Lemonade extends Drinkables {
    public Lemonade(String name, Integer price, Integer quantity, String unit, Integer volume) {
        super(name, price, quantity, unit, volume);
    }

    public Lemonade() {
        super("Лимонад", 50, 10, "л.", 1);
    }
}
