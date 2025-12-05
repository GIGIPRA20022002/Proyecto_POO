package adventure.game;

import java.util.Scanner;
import adventure.core.*;
import adventure.commands.*;

public class Game {
    private GameMap map;
    private GameState state;
    private Scanner scanner;
    private CommandParser parser;
    private boolean restartRequested;

    public Game() {
        restartRequested = false;
        initializeGame();
    }

    private void initializeGame() {
        map = new GameMap();
        state = new GameState(map);
        scanner = new Scanner(System.in);
        parser = new CommandParser();
    }

    public void start() {
        boolean playing = true;
        
        while (playing) {
            showIntroduction();
            
            while (true) {
                System.out.print("\n> ");
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) continue;
                
                if (input.equalsIgnoreCase("restart")) {
                    System.out.println("\n========================================");
                    System.out.println("          RESTARTING GAME...");
                    System.out.println("========================================");
                    restartRequested = true;
                    break;
                }
                
                Command command = parser.parse(input);
                
                if (command == null) {
                    System.out.println("Unknown command. Type 'help'.");
                    continue;
                }

                command.execute(state);
                
                if (checkGameEnd()) {
                    break;
                }
            }
            
            if (restartRequested) {
                restartRequested = false;
                initializeGame();
                continue;
            } else {
                playing = false;
            }
        }
        
        scanner.close();
    }

    private void showIntroduction() {
    System.out.println("========================================");
    System.out.println("         DUNGEON ADVENTURE");
    System.out.println("========================================");
    System.out.println("Your goal: Reach the final exit (Room 4).");
    System.out.println("Be careful: You can only carry ONE item at a time.");
    System.out.println("Each action consumes your energy...");
    System.out.println("Type 'restart' to start over anytime.");
    System.out.println("Type 'help' for commands.");
    System.out.println("========================================");
    System.out.println(state.getCurrent().getFullDescription());
    System.out.println("\n" + state.getHero().getStatus());
}

    private boolean checkGameEnd() {
        if (!state.getHero().isAlive()) {
            System.out.println("\n========================================");
            System.out.println("           GAME OVER");
            System.out.println("Your health reached 0. You died.");
            System.out.println("Type 'restart' to try again.");
            System.out.println("========================================");
            return true;
        }
        
        return false;
    }
}