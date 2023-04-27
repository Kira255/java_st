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

    public Menu() {
        prevPos = "";
        choice = "";
        newPos = "";
        formatter = DateTimeFormatter.ofPattern(
                "dd.MM.yyyy HH:mm");
    }

    public void ReturnToPrevPos() {
        newPos = prevPos;
        choice = "";
    }

    public void ResetMenuPos() {
        prevPos = "";
        choice = "";
        newPos = "";
    }

}
