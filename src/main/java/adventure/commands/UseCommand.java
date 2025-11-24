package adventure.commands;

import adventure.game.*;
import adventure.items.Item;

public class UseCommand implements Command {
    public void execute(GameState state, String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Use what?");
            return;
        }

        Item item = state.getInventory().getItem(itemName);
        if (item == null) {
            System.out.println("You don't have '" + itemName + "' in your inventory.");
            return;
        }

        String result = item.use(state);
        System.out.println(result);
    }
}