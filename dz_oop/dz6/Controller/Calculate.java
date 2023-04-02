package dz_oop.dz6.Controller;

import java.io.IOException;

import dz_oop.dz6.Config.LoggerConfig;
import dz_oop.dz6.Model.RationalExample;
import dz_oop.dz6.Service.Solve;
import dz_oop.dz6.Service.impl.Solvelpml;
import dz_oop.dz6.View.MenuGet;
import dz_oop.dz6.View.MenuShow;
import dz_oop.dz6.View.impl.MenuGetlmpl;
import dz_oop.dz6.View.impl.MenuShowlmpl;

public class Calculate {
    public Solve solve = new Solvelpml();

    public void start() {
        MenuGet menuGet = new MenuGetlmpl();
        MenuShow menuShow = new MenuShowlmpl();
        try {
            LoggerConfig.config();
        } catch (IOException e) {
            menuShow.showMessage("Error", "Problem with logging");
        }

        String action;
        do {
            action = menuShow.showMenu(menuGet);
            if (action.equals("0")) {
                return;
            }
            RationalExample example = new RationalExample(solve.checkOperation(action));
            Number[] values = menuGet.getValuesForExpression();
            example.setVariableA(values[0]);
            example.setVariableB(values[1]);
            try {
                menuShow.showMessage("Result", solve.solve(example));
            } catch (NullPointerException e) {
                menuShow.showMessage("Error", "Incorrect data. Please, input values again");
            }
        } while (true);
    }
}
