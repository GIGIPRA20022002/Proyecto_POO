package adventure.commands;

import adventure.game.*;


public class RestartCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("\n========================================");
        System.out.println("          RESTARTING GAME...");
        System.out.println("========================================");
        
        System.out.println("Game restarted!");
        System.out.println("You are back at the beginning.");
        
        System.out.println("\nType 'quit' and run the game again to fully restart.");
    }
}