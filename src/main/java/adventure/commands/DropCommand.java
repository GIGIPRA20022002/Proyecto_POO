package adventure.commands;

import adventure.game.*;


public class DropCommand implements Command {
    public void execute(GameState state, String itemName) {
        if (state.getInventory().remove(itemName)) {
            state.getCurrent().addItem(itemName);
            System.out.println("You dropped: " + itemName);
        } else {
            System.out.println("You don't have that item.");
        }
    }

}