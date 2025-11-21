package adventure.commands;

import adventure.game.*;
import adventure.core.*;

public class MoveCommand implements Command {
    public void execute(GameState state, String dir) {
        if (dir.isEmpty()) {
            System.out.println("¿A dónde quieres ir?");
            return;
        }
        Location next = state.getCurrent().getExit(dir);
        if (next == null) {
            System.out.println("No puedes ir por ahí.");
        } else {
            state.setCurrent(next);
            System.out.println("Ahora estás en: " + next.getName());
            System.out.println(next.getDescription());
        }
    }
}
