package adventure.commands;

import adventure.game.*;
import adventure.items.Item;


public class LookCommand implements Command {
    public void execute(GameState state, String arg) {
        state.getHero().performAction(); // Mirar consume acción
        
        if (arg.isEmpty()) {
            // Mostrar descripción completa de la sala
            System.out.println(state.getCurrent().getFullDescription());
            
            // Mostrar estado del héroe
            System.out.println("\n" + state.getHero().getStatus());
        } else {
            // Mirar un objeto específico
            Item item = state.getCurrent().getItem(arg);
            if (item != null) {
                System.out.println("You examine the " + arg + ":");
                System.out.println("  " + item.getDescription());
                System.out.println("  Use: " + item.use());
            } else {
                System.out.println("You don't see any " + arg + " here.");
            }
        }
    }
}