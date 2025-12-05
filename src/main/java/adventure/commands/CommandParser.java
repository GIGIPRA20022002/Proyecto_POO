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
        commands.put("restart", new RestartCommand());
        commands.put("quit", null);
    }

    private void setupSynonyms() {
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

        if (synonyms.containsKey(commandWord)) {
            commandWord = synonyms.get(commandWord);
        }

        Command command = commands.get(commandWord);
        if (command != null) {
            return new ParsedCommand(command, argument);
        } else if (commandWord.equals("quit")) {
            return new QuitCommand();
        } else {
            return null;
        }
    }

    public Command getCommandByName(String name) {
        return commands.get(name.toLowerCase());
    }

    public Set<String> getAvailableCommands() {
        return commands.keySet();
    }
}