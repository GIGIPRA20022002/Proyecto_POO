package adventure.commands;

import adventure.game.*;

public class HelpCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("========================================");
        System.out.println("          DUNGEON ADVENTURE - HELP");
        System.out.println("========================================");
        System.out.println("GOAL: Reach Room 4 and escape through the east exit.");
        System.out.println("WARNING: Each action costs 1 HP every 3 actions!");
        System.out.println("INVENTORY: You can only carry ONE item at a time.");
        System.out.println("========================================");
        System.out.println("\n📋 COMMANDS:");
        System.out.println("  go <direction>      - Move (north, south, east, west)");
        System.out.println("  look                - Examine current room");
        System.out.println("  look <item>         - Examine specific item");
        System.out.println("  take <item>         - Pick up an item");
        System.out.println("  drop                - Drop current item");
        System.out.println("  use <item>          - Use item (eat food, learn spell)");
        System.out.println("  open <direction>    - Unlock door with key");
        System.out.println("  attack monster      - Attack monster with weapon");
        System.out.println("  attack fireball     - Cast Fireball spell");
        System.out.println("  inventory           - Show your item");
        System.out.println("  restart             - Start over from beginning");
        System.out.println("  help                - Show this help");
        System.out.println("  quit                - Exit game");
        System.out.println("========================================");

        System.out.println("\n🗝️ KEYS & DOORS:");
        System.out.println("  • Key1 opens: north exit from Room 1");
        System.out.println("  • Key2 opens: east exit from Room 2");
        System.out.println("  • Key3 opens: north exit from Room 3");
        System.out.println("  • Key4 opens: final exit (east from Room 4)");
        System.out.println("========================================");
        System.out.println("\n⚔️ MONSTERS:");
        System.out.println("  • Goblin (Room 3): Can be killed with Sword or Fireball");
        System.out.println("  • Fire Demon (Room 4): ONLY Fireball can defeat it!");
        System.out.println("========================================");

        // Mostrar estado actual del jugador ← ESTA PARTE FUE QUITADA
        System.out.println("\n" + state.getHero().getStatus());
        System.out.println("Fireball: " +
            (state.getHero().knowsFireball() ? "LEARNED ✓" : "NOT LEARNED ✗"));
        System.out.println("========================================");
    }
}