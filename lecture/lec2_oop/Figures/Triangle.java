package lec2_oop.Figures;

import lec2_oop.Figures.Base.Polygons;

public class Triangle extends Polygons {

    public Triangle(int a, int b, int c) {
        super(new int[] { a, b, c });
    }

    public Triangle() {
        this(3, 4, 5);
    }

    @Override
    public double square() {
        double p = perimeter() / 2.0;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    @Override
    public String toString() {
        return "Треугольник";
    }

}
