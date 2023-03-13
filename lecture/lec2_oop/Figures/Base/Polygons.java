package lec2_oop.Figures.Base;

public abstract class Polygons implements Figure, Perimet {
    protected int[] sides;

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
