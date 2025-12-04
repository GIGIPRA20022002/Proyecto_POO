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
            System.out.println("You can't go that way.");
            return;
        }
        
        // Verificar si hay monstruo bloqueando la salida (solo sala 3 y 4)
        if (current.hasMonster() && 
            ((dir.equals("north") && current.getName().contains("Room 3")) ||
             (dir.equals("east") && current.getName().contains("Room 4")))) {
            System.out.println("The " + current.getMonster().getName() + 
                " is blocking the exit! You must defeat it first.");
            return;
        }
        
        // Mover al jugador
        state.setCurrent(next);
        state.getHero().performAction(); // Contar como acción
        
        System.out.println("You move to the " + dir + ".");
        System.out.println("\n" + next.getFullDescription());
        
        // Verificar si llegó a la salida final (victoria)
        if (next.getName().contains("Room 4") && dir.equals("east")) {
            System.out.println("\n========================================");
            System.out.println("           VICTORY!");
            System.out.println("You escaped the dungeon!");
            System.out.println("========================================");
            System.exit(0);
        }
    }
}