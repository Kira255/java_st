package Exam.ToyShop.Views;

import java.util.List;

import Exam.ToyShop.Classes.Buyer;

public class BuyersView {
    List<Buyer> buyers;

    public BuyersView(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public void ShowTable() {
        // Вывести в консоль таблицу игрушек
        System.out.println("\nТаблица Покупатели\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Buyer item : buyers) {
            System.out.println(item.toString());
        }
    }
}
