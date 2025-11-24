package adventure.game;

import java.util.Scanner;
import adventure.core.*;
import adventure.commands.*;

public class Game {
    private GameMap map;
    private GameState state;
    private Scanner scanner;

    public Game() {
        map = new GameMap();
        state = new GameState(map);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Text Adventure Game!");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ", 2);
            String cmd = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1] : "";

            Command c = null;

            switch (cmd) {
                case "go": c = new MoveCommand(); break;
                case "look": c = new LookCommand(); break;
                case "take": c = new TakeCommand(); break;
                case "drop": c = new DropCommand(); break;
                case "use": c = new UseCommand(); break;
                case "inventory": c = new InventoryCommand(); break;
                case "help": c = new HelpCommand(); break;
                case "quit": 
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Command not recognized.");
            }

            if (c != null) {
                c.execute(state, arg);
            }
        }
    }
}