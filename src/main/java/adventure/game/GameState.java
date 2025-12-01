package adventure.game;

import adventure.items.Backpack;
import adventure.core.GameMap;
import adventure.core.Location;

public class GameState {
    private GameMap map;        // ← FALTABA ESTO
    private Location current;
    private Backpack inventory;

    public GameState(GameMap map) {
        this.map = map;
        this.current = map.getStart();
        this.inventory = new Backpack("Backpack", "Your backpack", 0.5, 10);
    }

    public GameMap getMap() { return map; }

    public Location getCurrent() {
        return current;
    }

    public void setCurrent(Location loc) {
        this.current = loc;
    }

    public Backpack getInventory() {
        return inventory;
    }
}
