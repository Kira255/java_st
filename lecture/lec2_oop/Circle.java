package lec2_oop;

import java.lang.Math;
import java.util.Scanner;

public class Circle {

    Scanner scan = new Scanner(System.in);

    private float R;

    public Circle(float R) {
        this.R = R;
    }

    public Circle() {
        System.out.println("Введите радиус кгруга: ");
        R = scan.nextFloat();
    }

    public String periCircle(float R) {
        double res = 2 * Math.PI * R;
        String _res = "Периметр круга: " + res;
        return _res;
    }

}
