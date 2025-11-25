package adventure.game;

import java.util.Scanner;
import adventure.core.*;
import adventure.commands.*;

public class Game {
    private GameMap map;
    private GameState state;
    private Scanner scanner;
    private CommandParser parser;

    public Game() {
        map = new GameMap();
        state = new GameState(map);
        scanner = new Scanner(System.in);
        parser = new CommandParser(); // Nuevo parser
    }

    public void start() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Type 'help' for available commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            Command command = parser.parse(input);
            
            if (command == null) {
                System.out.println("I don't understand. Type 'help' for available commands.");
                continue;
            }

            command.execute(state);
        }
    }
}