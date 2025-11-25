package adventure.commands;

import adventure.game.GameState;

public class ParsedCommand implements Command {
    private Command realCommand;
    private String argument;

    public ParsedCommand(Command realCommand, String argument) {
        this.realCommand = realCommand;
        this.argument = argument;
    }

    public void execute(GameState state, String arg) {
        // Ignorar el arg que viene y usar el que ya tenemos
        realCommand.execute(state, argument);
    }
    
    // El método execute(GameState) se hereda automáticamente del default
}