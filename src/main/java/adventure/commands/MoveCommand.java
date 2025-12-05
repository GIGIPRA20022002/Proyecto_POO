package adventure.commands;

import adventure.game.*;
import adventure.core.*;

public class MoveCommand implements Command {
    public void execute(GameState state, String dir) {
        if (dir.isEmpty()) {
            System.out.println("Go where? Example: go north");
            return;
        }
        
        Location current = state.getCurrent();
        Location next = current.getExit(dir);
        
        if (next == null) {
            // Verificar si es la salida final (east de Room 4)
            if (current.getName().contains("Room 4") && dir.equals("east")) {
                // Verificar si hay monstruo bloqueando
                if (current.hasMonster()) {
                    System.out.println("The " + current.getMonster().getName() + 
                        " is blocking the exit! You must defeat it first.");
                    return;
                }
                
                System.out.println("You move to the east.");
                System.out.println("\n========================================");
                System.out.println("           VICTORY!");
                System.out.println("You escaped the dungeon!");
                System.out.println("========================================");
                System.exit(0);
            } else {
                System.out.println("You can't go that way.");
            }
            return;
        }
        
        // Verificar si hay monstruo bloqueando la salida
        if (current.hasMonster() && 
            ((dir.equals("north") && current.getName().contains("Room 3")) ||
             (dir.equals("east") && current.getName().contains("Room 4")))) {
            System.out.println("The " + current.getMonster().getName() + 
                " is blocking the exit! You must defeat it first.");
            return;
        }
        
        // Mover al jugador
        state.setCurrent(next);
        state.getHero().performAction();
        
        System.out.println("You move to the " + dir + ".");
        System.out.println("\n" + next.getFullDescription());
    }
}