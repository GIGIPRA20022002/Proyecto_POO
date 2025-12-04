package adventure.game;

import adventure.items.Backpack;
import adventure.core.GameMap;
import adventure.core.Location;
import adventure.characters.Hero;

public class GameState {
    private GameMap map;
    private Location current;
    private Hero hero;

    public GameState(GameMap map) {
        this.map = map;
        this.current = map.getStart();
        this.hero = new Hero("Adventurer", 10); // 10 HP inicial
    }

    public GameMap getMap() { return map; }

    public Location getCurrent() {
        return current;
    }

    public void setCurrent(Location loc) {
        this.current = loc;
        hero.performAction(); // Cambiar de sala cuenta como acción
    }

    public Hero getHero() {
        return hero;
    }

    // Método compatible con comandos existentes
    public Backpack getInventory() {
        return hero.getBackpack();
    }
}