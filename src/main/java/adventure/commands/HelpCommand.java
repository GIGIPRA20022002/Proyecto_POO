package adventure.commands;

import adventure.game.*;

public class HelpCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("=== AVAILABLE COMMANDS ===");
        System.out.println("Basic commands:");
        System.out.println("  go, look, take, drop, use, inventory, help, quit");
        System.out.println("");
        System.out.println("Synonyms also work:");
        System.out.println("  move/walk/run (for go)");
        System.out.println("  grab/pick/get (for take)");
        System.out.println("  examine/see/view (for look)");
        System.out.println("  i/inv (for inventory)");
        System.out.println("  ? (for help)");
        System.out.println("  exit/leave (for quit)");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  go north, take key, use potion, look around");
        System.out.println("==========================");
    }
}