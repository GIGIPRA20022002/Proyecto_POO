package adventure.commands;

import adventure.game.*;

public class HelpCommand implements Command {
    public void execute(GameState state, String arg) {
        System.out.println("Comandos:");
        System.out.println(" ir <dir>");
        System.out.println(" mirar");
        System.out.println(" tomar <obj>    (máximo " + state.getInventory().getCapacity() + " objetos)");
        System.out.println(" soltar <obj>");
        System.out.println(" inventario");
        System.out.println(" ayuda");
        System.out.println(" salir");
    }
}