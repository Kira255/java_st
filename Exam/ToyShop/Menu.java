package Exam.ToyShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Exam.ToyShop.Classes.Buyer;
import Exam.ToyShop.Classes.Prize;
import Exam.ToyShop.Classes.Toy;
import Exam.ToyShop.Models.BuyerMod;
import Exam.ToyShop.Models.DrawMod;
import Exam.ToyShop.Models.ToyMod;
import Exam.ToyShop.Views.BuyersView;
import Exam.ToyShop.Views.ToysView;

public class Menu {
    private String prevPos;
    private String choice;
    private String newPos; // выбор пункта меню
    private boolean ShowNewChoice;
    private Scanner sc;
    DateTimeFormatter formatter; // формат для даты и времени

    public void run() {
        showProgramGreeting();

        // меню
        sc = new Scanner(System.in);
        while (true) {
            ShowNewChoice = true;
            // выбор пункта из меню
            if (getChoice() != "") {
                if (getPrevPos() != "") {
                    setNewPos((getPrevPos() + "," +
                            getChoice()));
                } else {
                    setNewPos(getChoice());
                }
            } else {
                if (getPrevPos() != "") {
                    setNewPos(getPrevPos());
                } else {
                    setNewPos("");
                }
            }
            if (getChoice().equals("0")) {
                // переход в главное меню
                showMainMenu();
            } else if (getChoice().equals("X")) {
                // выход из программы
                showProgramExit();
                return;
            } else {
                switch (getNewPos()) {
                    case (""): // главное меню
                        showMainMenu();
                        break;

                    // меню Покупатели
                    case ("1"): // просмотор меню
                        showBuyersMenu();
                        break;

                    case ("1,1"): // просмотор таблицы
                        BuyersShowTableAll();
                        break;

                    case ("1,2"): // добавление
                        if (BuyerAddNew()) {
                            BuyersShowTableAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    case ("1,3"): // редактирование
                        if (BuyerEdit()) {
                            BuyersShowTableAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    case ("1,4"): // удаление
                        if (BuyerDeleteById()) {
                            BuyersShowTableAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    // меню Игрушки
                    case ("2"): // просмотор меню
                        showToysMenu();
                        break;

                    case ("2,1"): // просмотор таблицы
                        ToysShowTableAll();
                        break;

                    case ("2,2"): // добавление
                        if (ToyAddNew() == true) {
                            ToysShowTableAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    case ("2,3"): // редактирование
                        if (ToyEdit()) {
                            ToysShowTableAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    case ("2,4"): // удаление
                        if (ToyDeleteById()) {
                            ToysShowTableAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    // меню Розыгрыш призов
                    case ("3"): // просмотор меню
                        showDrawingMenu();
                        break;

                    case ("3,1"): // просмотор разыгранных призов
                        PrizesToAwardShowAll();
                        showDrawingMenu();
                        break;

                    case ("3,2"): // следующий розыгрыш приза
                        if (PrizeAddNew()) {
                            PrizesToAwardShowAll();
                            showDrawingMenu();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    case ("3,3"): // отметка - приз разыгран
                        if (PrizeSetAsAwarded()) {
                            PrizesAwardedShowAll();
                        } else {
                            setChoice("");
                            ShowNewChoice = false;
                        }
                        break;

                    case ("3,4"): // просмотор врученных призов
                        PrizesAwardedShowAll();
                        break;

                    default:
                        showMenuItemNotFound();
                        setChoice("");
                        ShowNewChoice = false;
                        break;
                }
            }

            if (ShowNewChoice) {
                System.out.printf("Выберите пункт меню: ");
                try {
                    setChoice(sc.nextLine().trim());
                } catch (NoSuchElementException exception) {
                    System.out.println("Пункт меню не выбран");
                    setChoice("");
                }
            }
        }
    }

    public void showProgramGreeting() {
        System.out.println();
        String s1 = "Розыгрыш призов в магазине игрушек";
        System.out.println(s1);
        System.out.println("-".repeat(s1.length()));
    }

    public void showMainMenu() {
        // меню
        String s1 = "Главное меню";
        System.out.println("\n" + s1 + "\n" + "-".repeat(s1.length()));
        System.out.println("1. Покупатели.");
        System.out.println("2. Игрушки.");
        System.out.println("3. Розыгрыш призов.");
        System.out.println("X. Выход из программы.");
        ResetMenuPos();
    }

    public void showBuyersMenu() {
        // меню Покупатели
        String s1 = "Меню-Таблица Покупатели (Участники розыгрыша)";
        System.out.println("\n" + s1 + "\n" + "-".repeat(s1.length()));
        System.out.println("1. Показать таблицу.");
        System.out.println("2. Добавить покупателя.");
        System.out.println("3. Редактировать покупателя.");
        System.out.println("4. Удалить покупателя.");
        System.out.println("0. Возвращение в Главное меню.");
        System.out.println("X. Выход.");
        setPrevPos(getNewPos());
    }

    public void showToysMenu() {
        // меню Игрушки
        String s1 = "Меню-Таблица Игрушки";
        System.out.println("\n" + s1 + "\n" + "-".repeat(s1.length()));
        System.out.println("1. Показать таблицу.");
        System.out.println("2. Добавить игрушку.");
        System.out.println("3. Редактировать игрушку.");
        System.out.println("4. Удалить игрушку.");
        System.out.println("0. Возвращение в Главное меню.");
        System.out.println("X. Выход.");
        setPrevPos(getNewPos());
    }

    public void showDrawingMenu() {
        // меню Розыгрыш призов
        System.out.println("\nМеню-Розыгрыш призов\n----------------");
        System.out.println("1. Показать таблицу-Разыгранные призы.");
        System.out.println("2. Разыграть следующий приз.");
        System.out.println("3. Отметить приз как врученный.");
        System.out.println("4. Показать таблицу-Врученные призы.");
        System.out.println("0. Возвращение в Главное меню.");
        System.out.println("X. Выход.");
        setPrevPos(getNewPos());
    }

    public void showProgramExit() {
        System.out.println();
        System.out.println("Завершение работы");
    }

    public void showMenuItemNotFound() {
        System.out.println("Не найден обработчик для указанного пункта меню.");
    }

    // методы для обработки меню - Покупатели
    public void BuyersShowTableAll() {
        BuyerMod buyersModel = new BuyerMod();
        if (buyersModel.load()) {
            BuyersView buyersView = new BuyersView(buyersModel.getBuyersAll());
            buyersView.ShowTable();
        }
        ReturnToPrevPos();
        showBuyersMenu();
    }

    public boolean BuyerAddNew() {
        // добавление покупателя
        BuyerMod buyersModel = new BuyerMod();
        if (!buyersModel.load()) {
            System.out.println("\nФункция добавления покупателя прервана.");
            return false;
        }

        int curId = buyersModel.getNewId();
        System.out.print("ФИО: ");
        try {
            String curFullName = sc.nextLine();
            System.out.print("Номер чека: ");
            String curCheckNumber = sc.nextLine();
            System.out.print("Номер телефона: ");
            String curPhone = sc.nextLine();
            Buyer curBuyer = new Buyer(curId, curFullName, curCheckNumber,
                    curPhone);
            buyersModel.add(curBuyer);
        } catch (Exception ex) {
            System.out.println("Ошибка при вводе данных о покупателе.\n" + ex.toString());
            return false;
        }

        if (buyersModel.save()) {
            System.out.println("Новый покупатель успешно добавлен!");
        } else {
            System.out.println("Ошибка при добавлении нового покупателя.");
            return false;
        }
        return true;
    }

    public boolean BuyerDeleteById() {
        // удаление покупателя
        BuyerMod buyersModel = new BuyerMod();
        if (buyersModel.load()) {
            BuyersView buyersView = new BuyersView(buyersModel.getBuyersAll());
            buyersView.ShowTable();
        }
        System.out.print("\nВведите id удаляемого покупателя: ");
        try {
            int curId = Integer.parseInt(sc.nextLine());
            // удаляем запись
            if (buyersModel.deleteById(curId)) {
                // сохраняем данные в файл
                buyersModel.save();
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при удалении покупателя.\n" + ex.toString());
            return false;
        }
        return false;
    }

    public boolean BuyerEdit() {
        // редактирование данных покупателя
        Buyer editedBuyer;
        BuyerMod buyersModel = new BuyerMod();
        if (buyersModel.load()) {
            BuyersView buyersView = new BuyersView(buyersModel.getBuyersAll());
            buyersView.ShowTable();
        }
        System.out.print("\nВведите id редактируемого покупателя: ");
        try {
            int curId = Integer.parseInt(sc.nextLine());
            editedBuyer = buyersModel.getBuyerById(curId);
            String curValue;
            // ввод новых значений полей
            System.out.print("ФИО: " +
                    editedBuyer.getName() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedBuyer.setName(curValue);

            System.out.print("Чек: " +
                    editedBuyer.getCheckNumber() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedBuyer.setCheckNumber(curValue);

            System.out.print("Телефон: " +
                    editedBuyer.getPhone() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedBuyer.setPhone(curValue);
            if (buyersModel.save()) {
                System.out.println("Данные покупателя с id=" + curId + " отредактированы.");
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Ошибка при редактировании данных покупателя.\n" + ex.toString());
            return false;
        }
        return false;
    }

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

    public boolean ToyEdit() {
        // pедактирование игрушки
        Toy editedToy;
        // список игрушек
        ToyMod toysModel = new ToyMod();
        if (toysModel.load()) {
            ToysView toysView = new ToysView(toysModel.getToysAll());
            toysView.ShowTable();
        }
        System.out.print("\nВведите id редактируемой игрушки: ");
        try {
            int curId = Integer.parseInt(sc.nextLine());
            editedToy = toysModel.getToyById(curId);
            String curValue;
            System.out.print("Название: " +
                    editedToy.getName() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedToy.setName(curValue);

            System.out.print("Количество: " +
                    editedToy.getCount() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedToy.setCount(Integer.parseInt(curValue));

            System.out.print("Цена: " +
                    editedToy.getPrice() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedToy.setPrice(Float.parseFloat(curValue));

            System.out.print("Вес: " +
                    editedToy.getWeight() +
                    "\nНовое значение: ");
            curValue = sc.nextLine();
            if (!curValue.equals(""))
                editedToy.setWeight(Integer.parseInt(curValue));
            if (toysModel.save()) {
                System.out.println("Игрушка с id=" + curId + " отредактирована.");
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Ошибка при редактировании игрушки.\n" + ex.toString());
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
        System.out.print("Введите id разыгранного приза: ");
        try {
            int curId = Integer.parseInt(sc.nextLine());

            System.out.print("Введите дату, время вручения (шаблон: 06.07.2023 15:10): ");
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
