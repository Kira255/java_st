package Exam.ToyShop.Models;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Exam.ToyShop.Classes.Buyer;
import Exam.ToyShop.Classes.Drawing;
import Exam.ToyShop.Classes.Prize;
import Exam.ToyShop.Classes.PrizeDate;
import Exam.ToyShop.Classes.Toy;

public class DrawMod {
    private String fnamePrizesToAward;
    private String fnamePrizesAwarded;
    DateTimeFormatter formatter;
    private Drawing drw; // данные о розыгрыше призов

    public DrawMod() {
        fnamePrizesToAward = "./ToyShop/db/prizestosend.csv"; // призы, которые нужно вручить
        fnamePrizesAwarded = "./ToyShop/db/prizesended.csv"; // врученные призы
        drw = new Drawing();
        formatter = DateTimeFormatter.ofPattern(
                "dd.MM.yyyy HH:mm");
    }

    public boolean loadPrizesToAward() {
        List<Prize> prizesToAward = new LinkedList<>();
        try (FileReader fr = new FileReader(fnamePrizesToAward)) {
            Scanner scanner = new Scanner(fr);
            int i = 0;
            while (scanner.hasNextLine()) {
                String curRow = scanner.nextLine();
                if (i > 0) {
                    String[] fields = curRow.split("\\|");
                    if (fields.length != 3) {
                        throw new Exception("Ошибка в исходном файле, в строке " + i);
                    }
                    int curId = Integer.parseInt(fields[0].trim());
                    String[] buFields = fields[1].trim().split(";");
                    Buyer curBuyer = new Buyer(Integer.parseInt(buFields[0].trim()),
                            buFields[1].trim(),
                            buFields[2].trim(),
                            buFields[3].trim());
                    String[] toFields = fields[2].trim().split(";");
                    Toy curToy = new Toy(Integer.parseInt(toFields[0].trim()),
                            toFields[1].trim(),
                            0,
                            Float.parseFloat(toFields[2].trim()),
                            0);
                    Prize curPrize = new Prize(curId, curBuyer, curToy);
                    prizesToAward.add(curPrize);
                }
                i++;
            }
            drw.setPrizesToAward(prizesToAward);
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Ошибка при загрузке списка призов для вручения.\n" + ex.toString());
            return false;
        }
        return true;
    }

    // загрузка списка из файла формата csv
    public boolean loadPrizesAwarded() {
        List<PrizeDate> prizesAwarded = new LinkedList<>();
        try (FileReader fr = new FileReader(fnamePrizesAwarded)) {
            Scanner scanner = new Scanner(fr);
            int i = 0;
            while (scanner.hasNextLine()) {
                String curRow = scanner.nextLine();
                if (i > 0) {
                    String[] fields = curRow.split("\\|");
                    if (fields.length != 4) {
                        throw new Exception("Ошибка в исходном файле, в строке " + i);
                    }
                    int curId = Integer.parseInt(fields[0].trim());
                    String[] buFields = fields[1].trim().split(";");
                    Buyer curBuyer = new Buyer(Integer.parseInt(buFields[0].trim()),
                            buFields[1].trim(),
                            buFields[2].trim(),
                            buFields[3].trim());
                    String[] toFields = fields[2].trim().split(";");
                    Toy curToy = new Toy(Integer.parseInt(toFields[0].trim()),
                            toFields[1].trim(),
                            0,
                            Float.parseFloat(toFields[2].trim()),
                            0);

                    LocalDateTime curDate = LocalDateTime.parse(fields[3].trim(), formatter);
                    PrizeDate curPrize = new PrizeDate(curId, curBuyer, curToy, curDate);
                    prizesAwarded.add(curPrize);
                }
                i++;
            }
            drw.setPrizesAwarded(prizesAwarded);
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Ошибка при загрузке таблицы Врученные призы.\n" + ex.toString());
            return false;
        }
        return true;
    }

    public void ShowTablePrizesToAward() {
        // вывод таблицы: Разыгранные призы
        String s1 = "Таблица Разыгранные призы";
        System.out.println("\n" + s1 + "\n" + "-".repeat(s1.length()));
        for (Prize item : drw.getPrizesToAward()) {
            System.out.println(item.toString());
        }
    }

    public void ShowTablePrizesAwarded() {
        // вывод таблицы: таблицы Врученные призы
        String s1 = "Таблица Врученные призы";
        System.out.println("\n" + s1 + "\n" + "-".repeat(s1.length()));
        for (PrizeDate item : drw.getPrizesAwarded()) {
            System.out.println(item.toString());
        }
    }

    public boolean PrizeToAwardSetAsAwarded(Prize curPrize, LocalDateTime curDate) {
        // выручение, разыгранного приза
        int curID = curPrize.getId();
        this.loadPrizesAwarded();
        List<PrizeDate> prizesAwarded = drw.getPrizesAwarded();
        int newId = getPrizesAwardedNewId();

        PrizeDate newPrizeAwarded = new PrizeDate(newId,
                curPrize.getBuyer(),
                curPrize.getToy(),
                curDate);

        // добавление нового врученного приза к общему списку врученных призов
        if (!prizesAwarded.add(newPrizeAwarded)) {
            System.out.print("Ошибка при добавлении врученного приза.");
            return false;
        }

        // удаляем разыгранный приз
        List<Prize> prizesToAward = drw.getPrizesToAward();
        for (Prize item : prizesToAward) {
            if (item.getId() == curID) {
                prizesToAward.remove(item);
                break;
            }
        }

        // сохраняем врученные призы
        drw.setPrizesAwarded(prizesAwarded);
        savePrizesAwarded();

        // сохраняем разыгранные призы
        drw.setPrizesToAward(prizesToAward);
        savePrizesToAward();

        System.out.println("Приз вручен. id врученного приза=" + newId + ".");
        return true;
    }

    public boolean PrizesToAwardAddNew() {
        loadPrizesToAward(); // обновить данные по разыгранным призам

        ToyMod toysModel = new ToyMod();
        if (!toysModel.load()) {
            return false;
        }
        // Получаем случайную игрушку с учетом веса и количества > 0
        Toy RandomToy = toysModel.getRandomToyByWeight();
        if (RandomToy == null) {
            System.out.println("Ошибка. Игрушка не выбрана.");
            return false;
        }

        // загрузить список покупателей
        BuyerMod buyersModel = new BuyerMod();
        if (!buyersModel.load()) {
            return false;
        }
        // полный список покупателей
        List<Buyer> buyersAll = buyersModel.getBuyersAll();
        // инициализация списка покупателей без призов
        List<Buyer> buyersNotAwarded = new LinkedList<>();
        for (Buyer buyer : buyersAll) {
            boolean isPresent = false;
            for (Prize prize : drw.getPrizesToAward()) {
                if (buyer.getId() == prize.getBuyer().getId()) {
                    isPresent = true;
                    break;
                }
            }
            // если покупателя нет в списке награжденных, добавляем покупателя в
            // buyersNotAwarded
            if (!isPresent) {
                buyersNotAwarded.add(buyer);
            }
        }

        if (buyersNotAwarded.size() == 0) {
            System.out.println("Нет покупателей без призов.");
            return false;
        }

        // выбор случайного покупателя, без приза
        int RndNumber = new Random().nextInt(buyersNotAwarded.size());
        Buyer RandomBuyer = buyersNotAwarded.get(RndNumber);
        // получаем идентификатор для новой записи приза
        int NewId = getPrizesToAwardNewId();
        // создаем новый объект - приз для вручения
        Prize newPrize = new Prize(NewId, RandomBuyer, RandomToy);
        // добавляем новый приз в таблицу призов для выдачи.
        drw.getPrizesToAward().add(newPrize);
        // сохраняем список в файл
        if (!savePrizesToAward()) {
            System.out.println("Ошибка при сохранении списка призов для вручения.");
            return false;
        }
        RandomToy.setCount(RandomToy.getCount() - 1);
        // обновление данных об игрушках
        toysModel.save();

        System.out.println("Был розыгран новый приз. id=" + NewId + ".");
        return true;
    }

    public boolean savePrizesToAward() {
        // сохранение списка
        try {
            FileWriter fr1 = new FileWriter(fnamePrizesToAward);
            fr1.append("id|Buyer=id;fullName;checkNumber;phone|Toy=id;name;price\n");
            for (Prize item : drw.getPrizesToAward()) {
                fr1.append(item.getId() + "|" +
                        item.getBuyer().toSavePrize() + "|" +
                        item.getToy().toSavePrize() + "\n");
            }
            fr1.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean savePrizesAwarded() {
        // сохранение списка
        try {
            FileWriter fr1 = new FileWriter(fnamePrizesAwarded);
            fr1.append("id|Buyer=id;fullName;checkNumber;phone|Toy=id;name;price|dateAward\n");
            for (PrizeDate item : drw.getPrizesAwarded()) {
                fr1.append(item.getId() + "|" +
                        item.getBuyer().toSavePrize() + "|" +
                        item.getToy().toSavePrize() + "|" +
                        item.getDateAwardString() + "\n");
            }
            fr1.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public int getPrizesToAwardNewId() {
        int maxId = -1;
        for (Prize item : drw.getPrizesToAward()) {
            if (item.getId() > maxId)
                maxId = item.getId();
        }
        return maxId + 1;
    }

    public int getPrizesAwardedNewId() {
        int maxId = -1;
        for (Prize item : drw.getPrizesAwarded()) {
            if (item.getId() > maxId)
                maxId = item.getId();
        }
        return maxId + 1;
    }

    public Prize getPrizeToAwardById(int curPrizeId) {
        for (Prize item : drw.getPrizesToAward()) {
            if (item.getId() == curPrizeId)
                return item;
        }
        return null;
    }
}
