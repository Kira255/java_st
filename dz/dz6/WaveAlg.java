package dz.dz6;

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

    // нахождение препятствий
    public void findPath(int x, int y, int nx, int ny) {
        if (map[y][x] == wall || map[ny][nx] == wall) {
            System.out.println("Вы выбрали препятствие!");
            return;
        }

        // волновой алгоритм поиска пути (заполнение значений достижимости)
        int[][] cloneMap = clone(map);
        List<Point> oldWave = new ArrayList<Point>();
        oldWave.add(new Point(nx, ny));
        int nstep = 0;
        map[ny][nx] = nstep;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        while (oldWave.size() > 0) {
            nstep++;
            wave.clear();
            for (Point i : oldWave) {
                for (int d = 0; d < 4; d++) {
                    nx = i.x + dx[d];
                    ny = i.y + dy[d];

                    if (map[ny][nx] == -1) {
                        wave.add(new Point(nx, ny));
                        map[ny][nx] = nstep;
                    }
                }
            }
            oldWave = new ArrayList<Point>(wave);
        }

        // волновой алгоритм поиска пути начиная от начала
        boolean flag = true;
        wave.clear();
        wave.add(new Point(x, y));
        while (map[y][x] != 0) {
            flag = true;
            for (int d = 0; d < 4; d++) {
                nx = x + dx[d];
                ny = y + dy[d];
                if (map[y][x] - 1 == map[ny][nx]) {
                    x = nx;
                    y = ny;
                    wave.add(new Point(x, y));
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Пути нет!");
                break;
            }
        }

        map = cloneMap;

        for (Point i : wave) {
            map[i.y][i.x] = 0;
        }
    }

    private class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

    public void waveOut() { // вывод координат пути
        for (Point i : wave) {
            System.out.println("x = " + i.x + ", y = " + i.y);
        }
    }
}