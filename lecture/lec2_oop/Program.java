/*реализовать классы следующих геометрических фигур: 
1.Треугольник 
2.Прямоугольник 
3.Квадрат 
4.Круг 
У каждой из этих фигур реализовать методы вычисления периметра и площади этих фигур. 
Так же для каждой фигуры реализовать проверку на корректность данных при создании фигуры, 
то есть можем ли мы начертить такой треугольник с заданными стонами или квадрат или прямоугольник. 
Так же круг может существовать только с радиусом больше нуля. 
Использовать эти классы в main и проверить все методы и конструкторы классов."
*/
package lec2_oop;

import lec2_oop.Figures.Circle;
import lec2_oop.Figures.Rectangle;
import lec2_oop.Figures.Square;
import lec2_oop.Figures.Triangle;
import lec2_oop.Figures.Base.Figure;
import lec2_oop.Figures.Base.Lenghtable;
import lec2_oop.Figures.Base.Perimet;

public class Program {
    public static void main(String[] args) {

        Figure[] figures = { new Triangle(), new Circle(), new Rectangle(), new Square() };
        for (Figure figute : figures)
            printFig(figute);
    }

    private static void printFig(Figure figure) {
        System.out.println(figure);
        System.out.println(String.format("Площадь: %f", figure.square()));
        if (figure instanceof Lenghtable) {
            Lenghtable l = (Lenghtable) figure;
            System.out.println(String.format("Длина окр: %f", l.length()));
        }
        if (figure instanceof Perimet) {
            Perimet p = (Perimet) figure;
            System.out.println(String.format("Периметр: %f", p.perimeter()));
        }

    }
}
