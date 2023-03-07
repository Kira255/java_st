package dz_oop.dz1;

public class Bread extends Food {

    private String flourType;

    public Bread(String name, Integer price, Integer quantity, String unit, String expDates) {
        super(name, price, quantity, unit, expDates);
    }

    public Bread() {
        super("Хлеб", 30, 1, "шт.", "01.03.23-10.03.23");
        flourType = "Пшеничная";
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, ExpDates: %s, Flour type: %s", this.name,
                this.price,
                this.quantity, this.unit, this.expDates, this.flourType);
    }
}
