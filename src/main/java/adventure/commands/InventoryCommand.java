package adventure.commands;

import adventure.game.*;
import adventure.items.Item;


public class InventoryCommand implements Command {
    public void execute(GameState state, String arg) {
        Item item = state.getInventory().getContainedItem();

        if (item == null) {
            System.out.println("Inventory: (0/1) []");
        } else {
            System.out.println("Inventory: (1/1) [" + item.getName() + "]");
        }
    }
}