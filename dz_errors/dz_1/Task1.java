
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        // division();
        // newArray();
        getNum();

    }

    public static void division() {
        System.out.println("Введите число которое хотите разделить:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("Результат: " + a / 0);
    }

    public static void newArray() {
        int nums[] = new int[4];
        for (int i = 0; i < 6; i++) {
            nums[i] = (int) (Math.random() * 5);
        }
    }

    public static void getNum() {
        int nums[] = new int[5];
        for (int i = 0; i < 6; i++) {
            nums[i] = (int) (Math.random() * 5);
        }
        System.out.println(nums[6]);
    }
}
