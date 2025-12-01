package adventure.commands;

import adventure.game.*;
import adventure.items.Item;

public class DropCommand implements Command {

    @Override
    public void execute(GameState state, String itemName) {

        // Remove devuelve un Item, NO un boolean
        Item removed = state.getInventory().remove(itemName);

        if (removed != null) {
            // Ahora sí agregamos el Item a la Location
            state.getCurrent().addItem(removed);

            System.out.println("You dropped: " + removed.getName());
        } else {
            System.out.println("You don't have that item.");
        }
    }
}
