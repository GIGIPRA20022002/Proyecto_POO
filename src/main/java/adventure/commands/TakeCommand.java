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
        
        // Buscar el item REAL en la sala (no crear uno nuevo)
        Item itemToTake = loc.getItem(itemName);
        
        if (itemToTake != null) {
            // Intentar añadir el item real al inventario
            if (state.getInventory().add(itemToTake)) {
                loc.removeItem(itemName);
                System.out.println("You took: " + itemName);
                System.out.println("Backpack space: " + 
                    state.getInventory().getCurrentSize() + "/" + 
                    state.getInventory().getCapacity());
                
                // DEBUG: Mostrar tipo de item
                System.out.println("DEBUG: This is a " + itemToTake.getClass().getSimpleName());
                if (itemToTake instanceof adventure.items.Key) {
                    System.out.println("DEBUG: It's definitely a Key!");
                }
            } else {
                System.out.println("Couldn't take " + itemName + ".");
            }
        } else {
            System.out.println("There is no '" + itemName + "' here.");
        }
    }
}