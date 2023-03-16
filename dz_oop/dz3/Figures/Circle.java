package dz_oop.dz3.Figures;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dz_oop.dz3.Figures.Base.Figure;
import dz_oop.dz3.Figures.Base.Lenghtable;

public class Circle extends Figure implements Lenghtable {

    Scanner scan = new Scanner(System.in);

    private int R;

    public Circle(int R) {
        this.R = R;
    }

    public Circle(Figure[] figures) throws ArrayIndexOutOfBoundsException {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        System.out.println("Введите радиус кгруга: ");
        try {
            this.R = scan.nextInt();
            if (R < 0) {
                throw new Exception("Число меньше нуля.");
            }
            list.add(new Circle(R));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double length() {
        return 2 * Math.PI * R;
    }

    public double square() {
        return (Math.PI * (R * R));
    }

    @Override
    public String toString() {
        return String.format("Круг");
    }
}
