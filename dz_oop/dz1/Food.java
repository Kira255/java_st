package dz_oop.dz1;

public class Food extends Products {

    protected String expDates;

    public Food(String name, Integer price, Integer quantity, String unit, String expDates) {
        super(name, price, quantity, unit);
        this.expDates = expDates;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, ExpDates: %s", this.name, this.price,
                this.quantity, this.unit, this.expDates);
    }
}
