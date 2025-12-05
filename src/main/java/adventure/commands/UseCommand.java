package adventure.commands;

import adventure.game.*;
import adventure.items.Item;

public class UseCommand implements Command {
    public void execute(GameState state, String args) {
        if (args.isEmpty()) {
            System.out.println("Use what? Example: use 'item name'");
            return;
        }

        Item item = findItemInInventory(state, args);
        
        if (item == null) {
            System.out.println("You don't have '" + args + "' in your inventory.");
            return;
        }

        state.getHero().performAction();
        
        if (item.getName().equalsIgnoreCase("Fireball Scroll")) {
            state.getHero().learnFireball();
            System.out.println("You read the scroll and learn the Fireball spell!");
            System.out.println("You can now use 'attack fireball' to cast it.");
            state.getInventory().remove(item.getName());
            return;
        }
        
        System.out.println(item.use());
    }

    private Item findItemInInventory(GameState state, String searchName) {
        Item carried = state.getInventory().getContainedItem();
        if (carried == null) return null;
        
        if (carried.getName().equalsIgnoreCase(searchName)) {
            return carried;
        }
        
        if (carried.getName().toLowerCase().contains(searchName.toLowerCase()) ||
            searchName.toLowerCase().contains(carried.getName().toLowerCase())) {
            return carried;
        }
        
        return null;
    }
}