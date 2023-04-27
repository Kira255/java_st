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

    // методы для обработки меню - Розыгрыш призов
    public void PrizesToAwardShowAll() {
        // разыгранные призы
        DrawMod drawingModel = new DrawMod();
        if (drawingModel.loadPrizesToAward()) {
            drawingModel.ShowTablePrizesToAward();
        }
        ReturnToPrevPos();

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
    
        
    }

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

    public String getNewPos() {
        return newPos;
    }

    public void setNewPos(String newPos) {
        this.newPos = newPos;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getPrevPos() {
        return prevPos;
    }

    public void setPrevPos(String prevPos) {
        this.prevPos = prevPos;
    }

}
