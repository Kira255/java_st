package dz_oop.dz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

import dz_oop.dz3.Figures.Circle;
import dz_oop.dz3.Figures.Rectangle;
import dz_oop.dz3.Figures.Square;
import dz_oop.dz3.Figures.Triangle;
import dz_oop.dz3.Figures.Base.Figure;
import dz_oop.dz3.Figures.Base.Lenghtable;
import dz_oop.dz3.Figures.Base.Perimet;

public class Actions {

    public static Figure[] addRectangle(Figure[] figures)
            throws ArrayIndexOutOfBoundsException, IllegalFormatException {
        Scanner scan = new Scanner(System.in);
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        try {
            System.out.println("Введите сторону a: ");
            int a = scan.nextInt();
            if (a < 0) {
                throw new Exception("Число меньше нуля.");
            }
            System.out.println("Введите сторону b: ");
            int b = scan.nextInt();
            if (b < 0) {
                throw new Exception("Число меньше нуля.");
            }
            list.add(new Rectangle(a, b));
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
        }
        for (Figure figure : list)
            System.out.println(figure);
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] addTriangle(Figure[] figures) throws ArrayIndexOutOfBoundsException, IllegalFormatException {
        Scanner scan = new Scanner(System.in);
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        boolean contr = true;
        while (contr) {
            try {
                System.out.println("Введите сторону a: ");
                int a = scan.nextInt();
                if (a < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                System.out.println("Введите сторону b: ");
                int b = scan.nextInt();
                if (b < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                System.out.println("Введите сторону c: ");
                int c = scan.nextInt();
                if (c < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                if (a + b < c || a + c < b || b + c < a) {
                    System.out.println("Такой треугольник не существует.");
                    continue;
                } else {
                    list.add(new Triangle(a, b, c));
                    contr = false;
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод");
            }
        }

        for (Figure figure : list)
            System.out.println(figure);
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] addSquare(Figure[] figures) throws ArrayIndexOutOfBoundsException, IllegalFormatException {
        Scanner scan = new Scanner(System.in);
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        try {
            System.out.println("Введите сторону a: ");
            int a = scan.nextInt();
            if (a < 0) {
                throw new Exception("Число меньше нуля.");
            }
            list.add(new Square(a));
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
        }
        for (Figure figure : list)
            System.out.println(figure);
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] addCircle(Figure[] figures) throws ArrayIndexOutOfBoundsException, IllegalFormatException {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Введите радиус кгруга: ");
            int R = scan.nextInt();
            if (R < 0) {
                throw new Exception("Число меньше нуля.");
            }
            list.add(new Circle(R));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Figure figure : list)
            System.out.println(figure);
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] printPerimet(Figure[] figures) {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        for (Figure figure : list) {
            System.out.println(figure);
            if (figure instanceof Lenghtable) {
                Lenghtable l = (Lenghtable) figure;
                System.out.println(String.format("Длина окружности: %f", l.length()));
            }
            if (figure instanceof Perimet) {
                Perimet p = (Perimet) figure;
                System.out.println(String.format("Периметр: %f", p.perimeter()));
            }
        }
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] printSquare(Figure[] figures) {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        for (Figure figure : list) {
            System.out.println(figure);
            System.out.println(String.format("Площадь: %f", figure.square()));
        }
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] removeIndex(Figure[] figures, int index) {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        list.remove(index);
        for (Figure figure : list)
            System.out.println(figure);
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] getIndex(Figure[] figures, int index)
            throws ArrayIndexOutOfBoundsException, IllegalFormatException {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        Scanner scan = new Scanner(System.in);
        System.out.println(list.get(index));
        if (list.get(index) instanceof Rectangle) {
            try {
                System.out.println("Введите сторону a: ");
                int a = scan.nextInt();
                if (a < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                System.out.println("Введите сторону b: ");
                int b = scan.nextInt();
                if (b < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                list.set(index, new Rectangle(a, b));
            } catch (Exception e) {
                System.out.println("Некорректный ввод");
            }
            for (Figure figure : list)
                System.out.println(figure);
        }
        if (list.get(index) instanceof Square) {
            try {
                System.out.println("Введите сторону a: ");
                int a = scan.nextInt();
                if (a < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                list.set(index, new Square(a));
            } catch (Exception e) {
                System.out.println("Некорректный ввод");
            }
            for (Figure figure : list)
                System.out.println(figure);
        }
        if (list.get(index) instanceof Triangle) {
            boolean contr = true;
            while (contr) {
                try {
                    System.out.println("Введите сторону a: ");
                    int a = scan.nextInt();
                    if (a < 0) {
                        throw new Exception("Число меньше нуля.");
                    }
                    System.out.println("Введите сторону b: ");
                    int b = scan.nextInt();
                    if (b < 0) {
                        throw new Exception("Число меньше нуля.");
                    }
                    System.out.println("Введите сторону c: ");
                    int c = scan.nextInt();
                    if (c < 0) {
                        throw new Exception("Число меньше нуля.");
                    }
                    if (a + b < c || a + c < b || b + c < a) {
                        System.out.println("Такой треугольник не существует.");
                        continue;
                    } else {
                        list.set(index, new Triangle(a, b, c));
                        contr = false;
                    }
                } catch (Exception e) {
                    System.out.println("Некорректный ввод");
                }
            }
            for (Figure figure : list)
                System.out.println(figure);
        }
        if (list.get(index) instanceof Circle) {
            try {
                System.out.println("Введите радиус кгруга: ");
                int R = scan.nextInt();
                if (R < 0) {
                    throw new Exception("Число меньше нуля.");
                }
                list.set(index, new Circle(R));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            for (Figure figure : list)
                System.out.println(figure);
        }
        System.out.println();
        return list.toArray(new Figure[0]);
    }

    public static Figure[] printAll(Figure[] figures) {
        List<Figure> list = new ArrayList<>(Arrays.asList(figures));
        for (Figure figure : list) {
            System.out.println(figure);
            System.out.println(String.format("Площадь: %f", figure.square()));
            if (figure instanceof Lenghtable) {
                Lenghtable l = (Lenghtable) figure;
                System.out.println(String.format("Длина окружности: %f", l.length()));
            }
            if (figure instanceof Perimet) {
                Perimet p = (Perimet) figure;
                System.out.println(String.format("Периметр: %f", p.perimeter()));
            }
        }
        System.out.println();
        return list.toArray(new Figure[0]);
    }
}
