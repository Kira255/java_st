package dz_oop.dz1;

public class childenProd extends Products {

    protected Integer minAge;
    protected String hypoallergenic;

    public childenProd(String name, Integer price, Integer quantity, String unit, Integer minAge,
            String hypoallergenic) {
        super(name, price, quantity, unit);
        this.minAge = minAge;
        this.hypoallergenic = hypoallergenic;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Quantity: %d, Unit: %s, minAge: %d, Hypoallergenic: %s", this.name,
                this.price, this.quantity, this.unit, this.minAge, this.hypoallergenic);
    }
}
