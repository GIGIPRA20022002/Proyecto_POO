package adventure.commands;

import adventure.game.*;
import adventure.core.*;

public class TakeCommand implements Command {
    public void execute(GameState state, String item) {
        if (item.isEmpty()) {
            System.out.println("¿Qué quieres tomar?");
            return;
        }

        // Verificar si la mochila está llena
        if (state.getInventory().isFull()) {
            System.out.println("¡Tu mochila está llena! No puedes llevar más objetos.");
            return;
        }

        Location loc = state.getCurrent();
        if (loc.removeItem(item)) {
            state.getInventory().add(item);
            System.out.println("Has tomado: " + item);
            System.out.println("Espacio en mochila: " + 
                state.getInventory().getCurrentSize() + "/" + 
                state.getInventory().getCapacity());
        } else {
            System.out.println("No hay '" + item + "' aquí.");
        }
    }
}