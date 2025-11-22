package adventure.commands;

import adventure.game.*;

public class InventoryCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("Inventario (" + 
            state.getInventory().getCurrentSize() + "/" + 
            state.getInventory().getCapacity() + "): " + 
            state.getInventory().getItems());
    }
}