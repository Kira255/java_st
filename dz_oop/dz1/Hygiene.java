package dz_oop.dz1;

public class Hygiene extends Products {

    protected Integer amount;

    public Hygiene(String name, Integer price, Integer quantity, String unit, Integer amount) {
        super(name, price, quantity, unit);
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, Amount: %d", this.name, this.price,
                this.quantity, this.unit, this.amount);
    }
}
