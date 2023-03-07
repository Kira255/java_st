package dz_oop.dz1;

public class Drinkables extends Products {

    protected Integer volume;

    public Drinkables(String name, Integer price, Integer quantity, String unit, Integer volume) {
        super(name, price, quantity, unit);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, Volume: %d", this.name, this.price,
                this.quantity, this.unit, this.volume);
    }
}
