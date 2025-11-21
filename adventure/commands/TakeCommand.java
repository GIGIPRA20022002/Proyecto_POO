package adventure.commands;

import adventure.game.*;
import adventure.core.*;

public class TakeCommand implements Command {
    public void execute(GameState state, String item) {
        if (item.isEmpty()) {
            System.out.println("¿Qué quieres tomar?");
            return;
        }
        Location loc = state.getCurrent();
        if (loc.removeItem(item)) {
            state.getInventory().add(item);
            System.out.println("Has tomado: " + item);
        } else {
            System.out.println("No está aquí.");
        }
    }
}
