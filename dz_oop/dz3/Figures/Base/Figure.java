package dz_oop.dz3.Figures.Base;

public abstract class Figure implements Comparable<Figure> {
    public abstract double square();

    @Override
    public int compareTo(Figure o) {
        if (this.square() < o.square())
            return -1;
        else if (this.square() > o.square())
            return 1;
        return 0;
    }
}
