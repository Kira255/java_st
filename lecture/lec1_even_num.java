import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lec1_even_num {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // дан массив чисел, нужно сформировать новую выборку
        // из только четных чисел
        int len = getNumberByUser("Введите количество элементов ");
        int[] items = createArray(len);
        fillArray(items, 0, 10);
        // print2(items);

        int evenCount = getCountEvenItems(items);
        int[] evenItems = getEvenItems(items, evenCount);
        // print2(evenItems);
        System.out.println(Arrays.toString(items));
        System.out.println(Arrays.toString(evenItems));
    }

    // #region
    // 2.0 Ввод числа
    public static int[] createArray(int size) {
        return new int[size];
    }

    public static int getNumberByUser(String text) {
        System.out.print(text);
        return input.nextInt();
    }

    // 2.2 Заполнение массива
    public static void fillArray(int[] col, int min, int max) {
        int count = col.length;
        int index = 0;
        while (index < count) {
            col[index] = random.nextInt(min, max);
            index = index + 1;
        }
    }

    // 2.4 Печать результата
    public static String print(int[] data) {
        String output = "";
        int count = data.length;

        int index = 0;
        while (index < count) {
            output += data[index] + " ";
            index = index + 1;
        }
        return output;
    }

    // 2.4 Печать результата
    public static void print2(int[] data) {

        int count = data.length;

        int index = 0;
        while (index < count) {
            System.out.print(data[index] + " ");
            index = index + 1;
        }

    }

    // 2.3 Получение только четных чисел
    public static int[] getEvenItems(int[] rawData, int countEvenElements) {
        int count = rawData.length;
        int[] evenItems = createArray(countEvenElements);

        int k = 0;

        for (int i = 0; i < count; i++) {
            if (rawData[i] % 2 == 0) {
                evenItems[k] = rawData[i];
                k++;
            }
        }
        return evenItems;
    }

    // 2.5 Получение кол-ва четных чисел
    static int getCountEvenItems(int[] array) {
        int length = array.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 0)
                count++;
        }
        return count;
    }
    // #endregion
}

// дан массив чисел, нужно сформировать новую выборку из только четных чисел
// 1. Уточнять ТЗ
// 2. Декомпозиция

// 2.0 Ввод числа
// 2.1 Создание массива
// 2.2 Заполнение массива
// 2.4 Печать результата

// 2.3 Получение только четных чисел
// 2.5 Получение кол-ва четных чисел

// 3. Алгоритм
// 4. Код
// 5. Тесты

class MyList {
    int[] data = new int[0];

    public void append(int item) {
        int size = data.length;
        int[] t = new int[size + 1];
        for (int i = 0; i < size; i++) {
            t[i] = data[i];
        }
        t[size] = item;
        data = t;
    }

    public String print() {
        return Arrays.toString(data);
    }
}

class MyLinkedList {
    int value;
    MyLinkedList next;
}