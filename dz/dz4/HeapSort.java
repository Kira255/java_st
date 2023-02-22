import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class HeapSort {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    // Главный модуль
    public static void main(String args[]) {
        int len = getNumberByUser("Введите количество элементов: ");
        int[] items = createArray(len);
        fillArray(items, -100, 100);
        System.out.println(Arrays.toString(items));
        int[] result = heapSort(items, len);
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

    // Сортировка
    public static int[] heapSort(int[] myArray, int length) {
        int temp;
        int size = length - 1;
        for (int i = (length / 2); i >= 0; i--) {
            heapify(myArray, i, size);
        }
        ;
        for (int i = size; i >= 0; i--) {
            temp = myArray[0];
            myArray[0] = myArray[size];
            myArray[size] = temp;
            size--;
            heapify(myArray, 0, size);
        }
        return (myArray);
    }

    public static void heapify(int[] myArray, int i, int heapSize) {
        int a = 2 * i;
        int b = 2 * i + 1;
        int largestElement;
        if (a <= heapSize && myArray[a] > myArray[i]) {
            largestElement = a;
        } else {
            largestElement = i;
        }
        if (b <= heapSize && myArray[b] > myArray[largestElement]) {
            largestElement = b;
        }
        if (largestElement != i) {
            int temp = myArray[i];
            myArray[i] = myArray[largestElement];
            myArray[largestElement] = temp;
            heapify(myArray, largestElement, heapSize);
        }
    }
}