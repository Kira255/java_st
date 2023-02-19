package dz.dz3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    // Главный модуль
    public static void main(String[] args) {
        int len = getNumberByUser("Введите количество элементов: ");
        int[] items = createArray(len);
        fillArray(items, -100, 100);
        System.out.println(Arrays.toString(items));
        int[] result = mergesort(items);
        System.out.println(Arrays.toString(result));
    }

    // Ввод числа
    public static int[] createArray(int size) {
        return new int[size];
    }

    public static int getNumberByUser(String text) {
        System.out.print(text);
        return input.nextInt();
    }

    // Заполнение массива
    public static void fillArray(int[] col, int min, int max) {
        int count = col.length;
        int index = 0;
        while (index < count) {
            col[index] = random.nextInt(min, max);
            index = index + 1;
        }
    }

    // Реализация отсортированного массива
    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }
}
