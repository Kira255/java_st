package lec2_oop.Figures;

public class Square extends Rectangle {

    public Square(int a) {
        super(a, a);
    }

    public Square() {
        this(3);
    }

    @Override
    public String toString() {
        return "Квадрат";
    }
}
