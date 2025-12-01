package adventure.commands;

import adventure.game.*;
import adventure.items.Item;

public class UseCommand implements Command {
    public void execute(GameState state, String args) {
        if (args.isEmpty()) {
            System.out.println("Use what? Example: use key or use key door");
            return;
        }

        String[] parts = args.split(" ", 2);
        String itemName = parts[0];
        String targetName = (parts.length > 1) ? parts[1] : null;

        Item item = state.getInventory().getItem(itemName);
        if (item == null) {
            System.out.println("You don't have '" + itemName + "' in your inventory.");
            return;
        }

        // Usar el item
        String result;
        if (targetName != null) {
            // use item target
            result = "You try to use " + itemName + " on " + targetName + "... ";
            // Por ahora no hay sistema de targets, pero la estructura está lista
            result += item.use();

        } else {
            // use item
            result = item.use();

        }

        System.out.println(result);
    }
}