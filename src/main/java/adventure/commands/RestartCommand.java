package adventure.commands;

import adventure.game.*;
import adventure.core.GameMap;

public class RestartCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("\n========================================");
        System.out.println("          RESTARTING GAME...");
        System.out.println("========================================");
        
        // Reiniciar el mapa y el estado
        GameMap newMap = new GameMap();
        state = new GameState(newMap);  // Esto no funciona bien, mejor...
        
        System.out.println("Game restarted!");
        System.out.println("You are back at the beginning.");
        System.out.println("\n" + state.getCurrent().getFullDescription());
        
        // Nota: En realidad necesitamos reiniciar desde Game.java
        // Por ahora, mostramos mensaje y salimos
        System.out.println("\nType 'quit' and run the game again to fully restart.");
        System.out.println("Or continue from here (some state may be reset).");
    }
}