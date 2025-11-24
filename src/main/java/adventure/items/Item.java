package adventure.items;

import adventure.game.GameState;

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public String use(GameState state) {
        return "You use the " + name + ", but nothing special happens.";
    }
}