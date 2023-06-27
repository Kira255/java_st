package dz_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        exercise_4();
        // exercise_2();
        // exercise_3();
        // exercise_4();
    }

    public static void exercise_1() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            float result = getFloatFromUser(bufferedReader);
            bufferedReader.close();
            System.out.println(result);
        } catch (IOException ex) {
            System.out.println("Ошибка при работе с файлом.");
            return;
        }

    }

    public static void exercise_2() {
        try {
            int d = 0;
            int[] intArray = new int[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    public static void exercise_3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("");
        } catch (NullPointerException ex) {
            System.out.println("Указатель на null.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Выход за пределы массива.");
        } catch (Exception ex) {
            System.out.println("Произошла ошибка.");
        }
    }

    public static void exercise_4() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isContinue = true;
            while (isContinue) {
                try {
                    System.out.println("Введите строку: ");
                    String text = getTextFromUser(bufferedReader);
                    System.out.println(text);
                    isContinue = false;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка при работе с консолью.");
        }

    }

    public static String getTextFromUser(BufferedReader bufferedReader) throws IOException {
        String text = bufferedReader.readLine();

        if (text.isEmpty()) {
            throw new RuntimeException("Введена пустая строка.");
        }

        return text;
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static float getFloatFromUser(BufferedReader bufferedReader) {
        System.out.print("Введите число: ");
        float result;
        try {
            result = Float.parseFloat(bufferedReader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка в преобразовании.");
            return getFloatFromUser(bufferedReader);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при получении числа.");
            return getFloatFromUser(bufferedReader);
        }
        return result;
    }

}