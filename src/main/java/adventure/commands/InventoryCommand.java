package adventure.commands;

import adventure.game.*;
import adventure.items.Item;  // ← AÑADIR ESTE IMPORT
import java.util.List;       // ← AÑADIR ESTE IMPORT  
import java.util.ArrayList;  // ← AÑADIR ESTE IMPORT

public class InventoryCommand implements Command {
    public void execute(GameState state, String arg) {
        List<String> itemNames = new ArrayList<>();
        for (Item item : state.getInventory().getItems()) {
            itemNames.add(item.getName());
        }
        
        System.out.println("Inventory (" + 
            state.getInventory().getCurrentSize() + "/" + 
            state.getInventory().getCapacity() + "): " + 
            itemNames);
    }

}
