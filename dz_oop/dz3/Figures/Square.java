package dz_oop.dz3.Figures;

import java.util.Scanner;

public class Square extends Rectangle {

    Scanner scan = new Scanner(System.in);

    public Square(int a) {
        super(a, a);
    }

    @Override
    public String toString() {
        return "Квадрат";
    }
}
