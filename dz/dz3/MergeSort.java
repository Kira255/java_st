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

    // Сортировка
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // Уже отсортированый массив
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
