package adventure.commands;

import adventure.game.GameState;

public class QuitCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}