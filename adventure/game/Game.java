package adventure.game;

import java.util.Scanner;
import adventure.core.*;
import adventure.items.*;
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
        System.out.println("Bienvenido al juego (versión simplificada estilo A).");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ", 2);
            String cmd = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1] : "";

            Command c = null;

            switch (cmd) {
                case "ir": c = new MoveCommand(); break;
                case "mirar": c = new LookCommand(); break;
                case "tomar": c = new TakeCommand(); break;
                case "soltar": c = new DropCommand(); break;
                case "inventario": c = new InventoryCommand(); break;
                case "ayuda": c = new HelpCommand(); break;
                case "salir": 
                    System.out.println("Saliendo.");
                    return;
                default:
                    System.out.println("Comando no reconocido.");
            }

            if (c != null) {
                c.execute(state, arg);
            }
        }
    }
}
