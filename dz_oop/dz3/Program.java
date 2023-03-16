package dz_oop.dz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dz_oop.dz3.Figures.Base.Figure;

public class Program {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Scanner scan = new Scanner(System.in);
        Figure[] figures = {};
        boolean contr = true;
        while (contr) {
            System.out.println(
                    "Привет, это программа, в которой можно работать с фигурами: чтобы добавить новую фигуру введите 1, чтобы посчитать периметр у всех фигур введите 2, чтобы посчитать площадь у всех фигур введите 3, чтобы удалить фигуру введите 4, чтобы изменить фигуру по индексу введите 5, чтобы отсортировать по площади введите 6, чтобы вывести информацию о всех фигурах введите 7.");
            int control = scan.nextInt();
            switch (control) {
                case 1:
                    System.out.println(
                            "Чтобы добавить прямоугольник введите 1, чтобы добавить квадрат введите 2, чтобы добавить треугольник введите 3, чтобы добавить круг введите 4.");
                    int index = scan.nextInt();
                    switch (index) {
                        case 1:
                            figures = Actions.addRectangle(figures);
                            break;
                        case 2:
                            figures = Actions.addSquare(figures);
                            break;
                        case 3:
                            figures = Actions.addTriangle(figures);
                            break;
                        case 4:
                            figures = Actions.addCircle(figures);
                            break;
                    }
                    continue;
                case 2:
                    figures = Actions.printPerimet(figures);
                    continue;
                case 3:
                    figures = Actions.printSquare(figures);
                    continue;
                case 4:
                    try {
                        System.out.println("Введите индекс: ");
                        int index1 = scan.nextInt();
                        if (index1 < 0) {
                            throw new Exception("Число меньше нуля.");
                        }
                        figures = Actions.removeIndex(figures, index1);
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод");
                    }
                    continue;
                case 5:
                    try {
                        System.out.println("Введите индекс: ");
                        int index2 = scan.nextInt();
                        if (index2 < 0) {
                            throw new Exception("Число меньше нуля.");
                        }
                        figures = Actions.getIndex(figures, index2);
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод");
                    }
                    continue;
                case 6:
                    List<Figure> list = new ArrayList<>(Arrays.asList(figures));
                    list.get(0).compareTo(list.get(1));
                    for (Figure figure : list) {
                        System.out.println(figure);
                        System.out.println(figure.square());
                    }
                    System.out.println();
                    list.toArray(new Figure[0]);
                    continue;
                case 7:
                    figures = Actions.printAll(figures);
                    continue;
                default:
                    contr = false;
            }
        }
    }
}
