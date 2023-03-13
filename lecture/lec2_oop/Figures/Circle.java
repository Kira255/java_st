package lec2_oop.Figures;

import java.lang.Math;
import java.util.Scanner;

import lec2_oop.Figures.Base.Figure;
import lec2_oop.Figures.Base.Lenghtable;

public class Circle implements Figure, Lenghtable {

    Scanner scan = new Scanner(System.in);

    private int R;

    public Circle(int R) {
        this.R = R;
    }

    public Circle() {
        System.out.println("Введите радиус кгруга: ");
        this.R = scan.nextInt();
    }

    public double length() {
        return 2 * Math.PI * R;
    }

    @Override
    public double square() {
        return Math.PI * (R * R);
    }

    @Override
    public String toString() {
        return String.format("Круг");
    }
}
