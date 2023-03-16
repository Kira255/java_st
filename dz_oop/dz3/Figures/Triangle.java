package dz_oop.dz3.Figures;

import java.util.Scanner;

import dz_oop.dz3.Figures.Base.Polygons;

public class Triangle extends Polygons {

    Scanner scan = new Scanner(System.in);

    public Triangle(int a, int b, int c) {
        super(new int[] { a, b, c });
    }

    @Override
    public double square() {
        double p = perimeter() / 2.0;
        return (int) Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    @Override
    public String toString() {
        return "Треугольник";
    }

}
