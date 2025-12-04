package adventure.commands;

import adventure.game.*;
import adventure.items.Item;

public class UseCommand implements Command {
    public void execute(GameState state, String args) {
        if (args.isEmpty()) {
            System.out.println("Use what? Examples:");
            System.out.println("  use \"Fireball Scroll\"  - Learn Fireball spell");
            System.out.println("  use Sword              - Equip/unequip weapon");
            System.out.println("  use Key                - Check key description");
            System.out.println("  use Bread              - Eat food to regain HP");
            return;
        }

        // Buscar el item en el inventario (permitir nombres con espacios)
        Item item = findItemInInventory(state, args);
        
        if (item == null) {
            System.out.println("You don't have '" + args + "' in your inventory.");
            System.out.println("Your inventory: " + 
                (state.getInventory().getContainedItem() != null ? 
                 state.getInventory().getContainedItem().getName() : "empty"));
            return;
        }

        state.getHero().performAction(); // Contar como acción
        
        // CASO ESPECIAL: Fireball Scroll
        if (item.getName().equalsIgnoreCase("Fireball Scroll")) {
            state.getHero().learnFireball();
            System.out.println("You read the scroll and learn the Fireball spell!");
            System.out.println("You can now use 'attack fireball' to cast it.");
            // Quitar el scroll del inventario después de usarlo
            state.getInventory().remove(item.getName());
            return;
        }
        
        // Otros usos normales
        String result = item.use();
        System.out.println(result);
    }

    private Item findItemInInventory(GameState state, String searchName) {
        Item carried = state.getInventory().getContainedItem();
        if (carried == null) return null;
        
        // Buscar por nombre exacto
        if (carried.getName().equalsIgnoreCase(searchName)) {
            return carried;
        }
        
        // Buscar por nombre parcial (para "Fireball Scroll" con "scroll")
        if (carried.getName().toLowerCase().contains(searchName.toLowerCase()) ||
            searchName.toLowerCase().contains(carried.getName().toLowerCase())) {
            return carried;
        }
        
        return null;
    }
}