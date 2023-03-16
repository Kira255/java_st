package dz_oop.dz3.Figures;

import dz_oop.dz3.Figures.Base.Polygons;

public class Rectangle extends Polygons {

    public Rectangle(int a, int b) {
        super(new int[] { a, b, a, b });
    }

    public Rectangle() {
        this(0, 0);
    }

    @Override
    public double square() {
        return sides[0] * sides[1];
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник");
    }

}
