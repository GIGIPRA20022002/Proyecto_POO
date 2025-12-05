package adventure.commands;

import adventure.game.*;
import adventure.core.*;
import adventure.items.Item;

public class TakeCommand implements Command {
    public void execute(GameState state, String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Take what?");
            return;
        }

        if (state.getInventory().isFull()) {
            System.out.println("Your backpack is full!");
            return;
        }

        Location loc = state.getCurrent();
        Item itemToTake = loc.getItem(itemName);
        
        if (itemToTake != null) {
            if (state.getInventory().add(itemToTake)) {
                loc.removeItem(itemName);
                System.out.println("You took: " + itemName);
            } else {
                System.out.println("Couldn't take " + itemName + ".");
            }
        } else {
            System.out.println("There is no '" + itemName + "' here.");
        }
    }
}