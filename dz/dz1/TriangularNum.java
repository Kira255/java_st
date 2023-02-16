import java.util.Scanner;

public class TriangularNum {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int num = getNumberByUser("Введите число: ");
        double res = formula(num);
        print(res);
    }

    // получение числа
    public static int getNumberByUser(String text) {
        System.out.print(text);
        return input.nextInt();
    }

    // вычисление формулы
    public static double formula(double num) {
        double res = 0.5 * (num * num + num);
        return res;
    }

    // вывод результата
    public static void print(double num) {
        int res = (int) num;
        System.out.print(res);
    }
}