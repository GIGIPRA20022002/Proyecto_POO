package adventure.commands;

import adventure.game.*;
import adventure.core.*;

public class DropCommand implements Command {
    public void execute(GameState state, String item) {
        if (state.getInventory().remove(item)) {
            state.getCurrent().addItem(item);
            System.out.println("Has soltado: " + item);
        } else {
            System.out.println("No tienes ese objeto.");
        }
    }
}
