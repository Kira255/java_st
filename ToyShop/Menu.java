package ToyShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ToyShop.Classes.Buyer;
import ToyShop.Classes.Prize;
import ToyShop.Classes.Toy;
import ToyShop.Models.BuyerMod;
import ToyShop.Models.DrawMod;
import ToyShop.Models.ToyMod;
import ToyShop.Views.BuyersView;
import ToyShop.Views.ToysView;

public class Menu {
    private String prevPos;
    private String choice;
    private String newPos; // выбор пункта меню
    private boolean ShowNewChoice;
    private Scanner sc;
    DateTimeFormatter formatter; // формат для даты и времени

    // методы для обработки меню - Игрушки
    public void ToysShowTableAll() {
        // форимрование списка игрушек, вывод в консоль
        ToyMod toysModel = new ToyMod();
        if (toysModel.load()) {
            ToysView toysView = new ToysView(toysModel.getToysAll());
            toysView.ShowTable();
        }

        ReturnToPrevPos();
        showToysMenu();
    }

    public boolean ToyAddNew() {
        // добавление игрушки
        ToyMod toysModel = new ToyMod();
        if (!toysModel.load()) {
            System.out.println("\nДобавление игрушки прервано.");
            return false;
        }

        int curId = toysModel.getNewId();
        System.out.println("\nДобавление игрушки.");
        System.out.print("Название: ");
        try {
            String curName = sc.nextLine();
            System.out.print("Количество: ");
            int curCount = Integer.parseInt(sc.nextLine());
            System.out.print("Цена: ");
            float curPrice = Float.parseFloat(sc.nextLine());
            System.out.print("Вес: ");
            int curWeight = Integer.parseInt(sc.nextLine());
            Toy curToy = new Toy(curId, curName, curCount,
                    curPrice, curWeight);
            toysModel.add(curToy);
        } catch (Exception ex) {
            System.out.println("Ошибка при вводе данных.\n" + ex.toString());
            return false;
        }

        if (toysModel.save()) {
            System.out.println("Новая игрушка добавлена.");
        } else {
            System.out.println("Ошибка при добавлении новой игрушки.");
            return false;
        }
        return true;
    }

    public boolean ToyDeleteById() {
        // удаление игрушки
        ToyMod toysModel = new ToyMod();
        if (toysModel.load()) {
            ToysView toysView = new ToysView(toysModel.getToysAll());
            toysView.ShowTable();
        }
        System.out.print("\nВведите id для удаляения игрушки: ");
        try {
            int curId = Integer.parseInt(sc.nextLine());
            // удаляем запись
            if (toysModel.deleteById(curId)) {
                // сохраняем данные в файл
                toysModel.save();
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при удалении игрушки.\n" + ex.toString());
            return false;
        }
        return false;
    }

    // методы для обработки меню - Розыгрыш призов
    public void PrizesToAwardShowAll() {
        // разыгранные призы
        DrawMod drawingModel = new DrawMod();
        if (drawingModel.loadPrizesToAward()) {
            drawingModel.ShowTablePrizesToAward();
        }
        ReturnToPrevPos();

    }

    public boolean PrizeAddNew() {
        DrawMod drawingModel = new DrawMod();
        if (drawingModel.PrizesToAwardAddNew())
            return true;
        return false;
    }

    public void PrizesAwardedShowAll() {
        // разыгранные призы
        DrawMod drawingModel = new DrawMod();
        if (drawingModel.loadPrizesAwarded()) {
            drawingModel.ShowTablePrizesAwarded();
        }
        ReturnToPrevPos();
        showDrawingMenu();
    }

    public boolean PrizeSetAsAwarded() {
        // показать все разыгранные призы
        PrizesToAwardShowAll();
        System.out.print("Введите id разыгранного приза, для смены статуса на Вручен: ");
        try {
            int curId = Integer.parseInt(sc.nextLine());

            System.out.print("Введите дату, время вручения (Enter - текущая. пример: 06.07.2023 15:10): ");
            String curValue = sc.nextLine();
            LocalDateTime curDate;
            if (curValue.equals("")) {
                curDate = LocalDateTime.now();
            } else {
                curDate = LocalDateTime.parse(sc.nextLine(), formatter);
            }

            DrawMod drawingModel = new DrawMod();
            // загружаем список разыгранных призов
            if (!drawingModel.loadPrizesToAward()) {
                System.out.print("Ошибка при загрузке списка разыгранных призов!");
                return false;
            }
            // находим выбранный приз
            Prize curPrize = drawingModel.getPrizeToAwardById(curId);
            // переводим приз в другую таблицу
            if (drawingModel.PrizeToAwardSetAsAwarded(curPrize, curDate)) {

                return true;
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при редактировании игрушки.\n" + ex.toString());
            return false;
        }
        return false;
    }

    public String getPrevPos() {
        return prevPos;
    }

    public String getChoice() {
        return choice;
    }

    public String getNewPos() {
        return newPos;
    }

    public void setPrevPos(String prevPos) {
        this.prevPos = prevPos;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setNewPos(String newPos) {
        this.newPos = newPos;
    }

    public void ResetMenuPos() {
        prevPos = "";
        choice = "";
        newPos = "";
    }

    public void ReturnToPrevPos() {
        newPos = prevPos;
        choice = "";
    }

    public Menu() {
        prevPos = "";
        choice = "";
        newPos = "";
        formatter = DateTimeFormatter.ofPattern(
                "dd.MM.yyyy HH:mm");
    }

}
