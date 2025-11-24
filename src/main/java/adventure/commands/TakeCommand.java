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
            System.out.println("Your backpack is full! You can't carry more items.");
            return;
        }

        Location loc = state.getCurrent();
        if (loc.removeItem(itemName)) {
            // Crear un objeto Item y añadirlo al inventario
            Item newItem = new Item(itemName, "A " + itemName + ".");
            state.getInventory().add(newItem);  // ← Ahora usa Item, no String
            System.out.println("You took: " + itemName);
            System.out.println("Backpack space: " + 
                state.getInventory().getCurrentSize() + "/" + 
                state.getInventory().getCapacity());
        } else {
            System.out.println("There is no '" + itemName + "' here.");
        }
    }
}