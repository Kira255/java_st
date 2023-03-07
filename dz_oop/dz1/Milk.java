package dz_oop.dz1;

public class Milk extends Drinkables {

    private Float fatPercent;
    private String expDates;

    public Milk(String name, Integer price, Integer quantity, String unit, Integer volume) {
        super(name, price, quantity, unit, volume);
    }

    public Milk() {
        super("Молоко", 65, 5, "л.", 1);
        fatPercent = 2.5f;
        expDates = "01.03.23-08.03.23";
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Price: %d, Quantity: %d, Unit: %s, Volume: %d, Fat Percentage: %f, expDates: %s",
                this.name,
                this.price, this.quantity, this.unit, this.volume, this.fatPercent, this.expDates);
    }
}
