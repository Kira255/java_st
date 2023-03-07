package dz_oop.dz1;

public class Pacifier extends childenProd {
    public Pacifier(String name, Integer price, Integer quantity, String unit, Integer minAge,
            String hypoallergenic) {
        super(name, price, quantity, unit, minAge, hypoallergenic);
    }

    public Pacifier() {
        super("Соска", 230, 2, "шт.", 0, "Гипоаллергенно");
    }
}
