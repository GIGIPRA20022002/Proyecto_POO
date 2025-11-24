package adventure.commands;

import adventure.game.*;
import adventure.core.*;

public class MoveCommand implements Command {
    public void execute(GameState state, String dir) {
        if (dir.isEmpty()) {
            System.out.println("Go where?");
            return;
        }
        Location next = state.getCurrent().getExit(dir);
        if (next == null) {
            System.out.println("You can't go that way.");
        } else {
            state.setCurrent(next);
            System.out.println("You are now in: " + next.getName());
            System.out.println(next.getDescription());
        }
    }
}
