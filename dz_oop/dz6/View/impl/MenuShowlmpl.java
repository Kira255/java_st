package dz_oop.dz6.View.impl;

import dz_oop.dz6.View.MenuGet;
import dz_oop.dz6.View.MenuShow;

public class MenuShowlmpl implements MenuShow {
    @Override
    public void showMessage(String message, String example) {
        System.out.println(message + ": " + example);
    }

    @Override
    public String showMenu(MenuGet menuGet) {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1 - Divide");
            System.out.println("2 - Sum");
            System.out.println("3 - Difference");
            System.out.println("4 - Multiplication");
            System.out.println("0 - exit");
            String action = menuGet.getInputValue();
            if ("01234".contains(action) && action.length() == 1) {
                return action;
            }
        }
    }
}
