package adventure.commands;

import java.util.*;

public class CommandParser {
    private Map<String, Command> commands;
    private Map<String, String> synonyms;

    public CommandParser() {
        commands = new HashMap<>();
        synonyms = new HashMap<>();
        setupCommands();
        setupSynonyms();
    }

private void setupCommands() {
    commands.put("go", new MoveCommand());
    commands.put("look", new LookCommand());
    commands.put("take", new TakeCommand());
    commands.put("drop", new DropCommand());
    commands.put("use", new UseCommand());
    commands.put("attack", new AttackCommand());
    commands.put("open", new OpenCommand());
    commands.put("inventory", new InventoryCommand());
    commands.put("help", new HelpCommand());
    commands.put("restart", new RestartCommand());  // ← NUEVO
    commands.put("quit", null);
}


private void setupSynonyms() {
    // Sinónimos existentes...
    synonyms.put("move", "go");
    synonyms.put("walk", "go");
    synonyms.put("run", "go");
    synonyms.put("grab", "take");
    synonyms.put("pick", "take");
    synonyms.put("get", "take");
    synonyms.put("examine", "look");
    synonyms.put("see", "look");
    synonyms.put("view", "look");
    synonyms.put("i", "inventory");
    synonyms.put("inv", "inventory");
    synonyms.put("?", "help");
    synonyms.put("exit", "quit");
    synonyms.put("leave", "quit");
    
    // Nuevos sinónimos
    synonyms.put("unlock", "open");
    synonyms.put("fight", "attack");
    synonyms.put("kill", "attack");
    synonyms.put("hit", "attack");
    synonyms.put("reset", "restart");
    synonyms.put("new", "restart");
    synonyms.put("startover", "restart");
}

    public Command parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] parts = input.trim().split("\\s+", 2);
        String commandWord = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1] : "";

        // Log simple
        log("User entered: '" + input + "' -> command: '" + commandWord + "', arg: '" + argument + "'");

        // Buscar sinónimos
        if (synonyms.containsKey(commandWord)) {
            commandWord = synonyms.get(commandWord);
            log("Converted to: '" + commandWord + "'");
        }

        // Buscar comando
        Command command = commands.get(commandWord);
        if (command != null) {
            log("Command found: " + commandWord);
            return new ParsedCommand(command, argument);
        } else if (commandWord.equals("quit")) {
            log("Quit command detected");
            return new QuitCommand();
        } else {
            log("Unknown command: " + commandWord);
            return null;
        }
    }

    public Command getCommandByName(String name) {
        return commands.get(name.toLowerCase());
    }

    public Set<String> getAvailableCommands() {
        return commands.keySet();
    }

    // Log simple
    private void log(String message) {
        System.err.println("[DEBUG] " + message);
    }
}