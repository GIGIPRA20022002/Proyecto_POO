package adventure.items;

import adventure.characters.Character;
import adventure.game.GameState;

public class Item implements Usable {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    // Implementación básica de la interfaz Usable
    public String use(Character user, Character target) {
        return "You use " + name + ", but nothing special happens.";
    }

    // Método use antiguo (para compatibilidad)
    public String use(GameState state) {
        return use(null, null);
    }
}