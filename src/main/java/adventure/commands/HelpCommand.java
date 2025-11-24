package adventure.commands;

import adventure.game.*;

public class HelpCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("Available commands:");
        System.out.println(" go <direction>");
        System.out.println(" look");
        System.out.println(" take <item>    (max " + state.getInventory().getCapacity() + " items)");
        System.out.println(" drop <item>");
        System.out.println(" use <item>");
        System.out.println(" inventory");
        System.out.println(" help");
        System.out.println(" quit");
    }
}