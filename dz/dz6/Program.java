package dz.dz6;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Program {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;

        int height = 20;
        int width = 20;
        WaveAlg Path = new WaveAlg(width, height);

        Path.traceOut();
        System.out.println();

        try {
            System.out.println("Введите x начала ");
            x = scan.nextInt();
            System.out.println("Введите y начала ");
            y = scan.nextInt();
            System.out.println("Введите x конца ");
            nx = scan.nextInt();
            System.out.println("Введите y конца ");
            ny = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
        }

        Path.findPath(x, y, nx, ny);

        Path.traceOut();
        System.out.println();

        Path.waveOut();
    }
}