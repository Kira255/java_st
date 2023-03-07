package dz_oop.dz1;

public class Products {
    protected String name;
    protected Integer price;
    protected Integer quantity;
    protected String unit;

    public Products(String name, Integer price, Integer quantity, String unit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s", this.name, this.price,
                this.quantity, this.unit);
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setValues(String name, Integer price, Integer quantity, String unit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }
}
