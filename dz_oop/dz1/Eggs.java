package dz_oop.dz1;

public class Eggs extends Food {

    private Integer eggsCount;

    public Eggs(String name, Integer price, Integer quantity, String unit, String expDates) {
        super(name, price, quantity, unit, expDates);
    }

    public Eggs() {
        super("Яйца", 65, 10, "шт.", "01.03.23-01.04.23");
        eggsCount = 12;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, ExpDates: %s, Amount in a package: %d",
                this.name,
                this.price, this.quantity, this.unit, this.expDates, this.eggsCount);
    }
}
