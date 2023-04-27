package Exam.ToyShop.Models;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Exam.ToyShop.Classes.Toy;

public class ToyMod {
    private List<Toy> toys; // список игрушек
    private String fnameToys;

    public ToyMod() {
        fnameToys = "./ToyShop/db/toys.csv";
    }

    public void add(Toy rec) {
        // добавление новой записи в список toys
        toys.add(rec);
    }

    public boolean deleteById(int curId) {
        // удаление записи по идентификатору
        for (Toy item : toys) {
            if (item.getId() == curId) {
                toys.remove(item);
                System.out.println("Игрушка с id =" + curId + " удалена.");
                return true;
            }
        }
        System.out.println("Игрушка с id =" + curId + " не найдена.");
        return false;
    }

    public boolean save() {
        // сохранение списка
        try {
            FileWriter fr1 = new FileWriter(fnameToys);
            fr1.append("id|name|count|price|weight\n");
            // основная таблица
            for (Toy item : toys) {
                fr1.append(item.getId() + "|" +
                        item.getName() + "|" +
                        item.getCount() + "|" +
                        item.getPrice() + "|" +
                        item.getWeight() + "\n");
            }
            fr1.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean load() {
        toys = new LinkedList<>();
        try (FileReader fr = new FileReader(fnameToys)) {
            Scanner scanner = new Scanner(fr);
            int i = 0;
            while (scanner.hasNextLine()) {
                String curRow = scanner.nextLine();
                if (i > 0) {
                    String[] fields = curRow.split("\\|");
                    if (fields.length != 5) {
                        throw new Exception("Ошибка в исходном файле, в строке " + i);
                    }
                    int curId = Integer.parseInt(fields[0].trim());
                    String curName = fields[1].trim();
                    int curCount = Integer.parseInt(fields[2].trim());
                    float curPrice = Float.parseFloat(fields[3].trim());
                    int curWeight = Integer.parseInt(fields[4].trim());

                    Toy curToy = new Toy(curId, curName, curCount,
                            curPrice, curWeight);
                    toys.add(curToy);
                }
                i++;
            }
            scanner.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
        return true;
    }

    public List<Toy> getToysAll() {
        return toys;
    }

    public int getNewId() {
        int maxId = -1;
        for (Toy item : toys) {
            if (item.getId() > maxId)
                maxId = item.getId();
        }
        return maxId + 1;
    }

    public Toy getToyById(int curToyId) {
        for (Toy item : toys) {
            if (item.getId() == curToyId)
                return item;
        }
        return null;
    }

    public Toy getRandomToyByWeight() {
        // возвращает игрушку выбранную случайным образом с учетом веса
        if (toys.size() == 0) {
            System.out.println("Игрушки закончились.");
            return null;
        }

        int SumWt = 0;
        List<Toy> selToys = new LinkedList<>();
        // 1. Делаем выборку игрушек и находим сумму их весов
        for (Toy item : toys) {
            if (item.getCount() > 0) {
                selToys.add(item);
                SumWt += item.getWeight();
            }
        }

        if (selToys.size() == 0) {
            System.out.println("Закончились игрушки для призов.");
            return null;
        }

        // 2. Берем случайный вес от 0 до TotalWt
        int RndWt = new Random().nextInt(SumWt + 1);
        // 3. Ищем элемент, который попал под это значение
        SumWt = 0;
        for (Toy item : selToys) {
            SumWt += item.getWeight();
            if (SumWt >= RndWt) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "";
        for (Toy item : toys) {
            res += item.toString();
        }
        return "Таблица Игрушки\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n: " + res;
    }
}
