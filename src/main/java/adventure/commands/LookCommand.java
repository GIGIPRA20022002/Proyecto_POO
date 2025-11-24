package adventure.commands;

import adventure.game.*;
import adventure.items.Item;

public class LookCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println(state.getCurrent().getDescription());
        if (!state.getCurrent().getItems().isEmpty()) {
            System.out.print("You see: ");
            for (Item item : state.getCurrent().getItems()) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        }
    }
}