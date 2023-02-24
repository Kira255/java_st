import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class WaveAlg {

    int width;
    int height;
    int wall = 99;
    int[][] map;
    List<Point> wave = new ArrayList<Point>();

    // волновой алгоритм
    public WaveAlg(int width, int height) {
        this.width = width;
        this.height = height;
        map = new int[width][height];

        // инициализируем карту
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = -1;
            }
        }
        // заполнение границ карты препятствиями
        for (int i = 0; i < width; i++) {
            map[i][0] = wall;
            map[width - 1][i] = wall;
        }
        for (int i = 0; i < height; i++) {
            map[0][i] = wall;
            map[i][height - 1] = wall;
        }
    }

    // заполняем карту препятствиями
    public void block(int x, int y) {
        map[y][x] = wall;
    }
}