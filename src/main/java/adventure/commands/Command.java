package adventure.commands;

import adventure.game.GameState;

public interface Command {
    void execute(GameState state, String arg);  // Mantener este método
    
    // Añadir método sobrecargado para compatibilidad
    default void execute(GameState state) {
        execute(state, "");
    }
}