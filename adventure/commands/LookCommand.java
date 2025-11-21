package adventure.commands;

import adventure.game.*;

public class LookCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println(state.getCurrent().getDescription());
        if (!state.getCurrent().getItems().isEmpty()) {
            System.out.println("Ves: " + state.getCurrent().getItems());
        }
    }
}
