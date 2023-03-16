package dz_oop.dz3.Figures.Base;

import java.util.Scanner;

public abstract class Polygons extends Figure implements Perimet {
    protected int[] sides;
    protected int side;

    Scanner scan = new Scanner(System.in);

    protected Polygons(int[] sides) {
        this.sides = sides;
    }

    public double perimeter() {
        int sum = 0;
        for (int side : sides)
            sum += side;
        return sum;
    }
}
