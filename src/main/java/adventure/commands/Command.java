package adventure.commands;

import adventure.game.*;

public interface Command {
    void execute(GameState state, String arg);
}
