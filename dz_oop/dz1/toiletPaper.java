package dz_oop.dz1;

public class toiletPaper extends Hygiene {

    private Integer layersCount;

    public toiletPaper(String name, Integer price, Integer quantity, String unit, Integer amount) {
        super(name, price, quantity, unit, amount);
    }

    public toiletPaper() {
        super("Туалетная бумага", 250, 10, "шт.", 6);
        layersCount = 3;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, Amount: %d, Layers count: %d", this.name,
                this.price,
                this.quantity, this.unit, this.amount, this.layersCount);
    }
}
