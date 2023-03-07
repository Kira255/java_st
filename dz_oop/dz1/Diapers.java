package dz_oop.dz1;

public class Diapers extends childenProd {

    private String size;
    private Integer minWeignt;
    private Integer maxWeignt;
    private String type;

    public Diapers(String name, Integer price, Integer quantity, String unit, Integer minAge,
            String hypoallergenic) {
        super(name, price, quantity, unit, minAge, hypoallergenic);
    }

    public Diapers() {
        super("Подгузники", 990, 30, "шт.", 0, "Гипоаллергенно");
        size = "NB";
        minWeignt = 0;
        maxWeignt = 1;
        type = "одноразовые подгузники";
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Price: %d, Quantity: %d, Unit: %s, minAge: %d, Hypoallergenic: %s, Size: %s, minWeight: %d, maxWeignt: %d, Type: %s",
                this.name,
                this.price, this.quantity, this.unit, this.minAge, this.hypoallergenic, this.size, this.minWeignt,
                this.maxWeignt, this.type);
    }
}
