package lec2_oop.Figures;

import lec2_oop.Figures.Base.Polygons;

public class Rectangle extends Polygons {

    public Rectangle(int a, int b) {
        super(new int[] { a, b, a, b });
    }

    public Rectangle() {
        this(3, 4);
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
