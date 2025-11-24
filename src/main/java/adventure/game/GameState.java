package adventure.game;

import adventure.core.*;
import adventure.items.*;

public class GameState {
    private GameMap map;
    private Location current;
    private Inventory inventory;

    public GameState(GameMap map) {
        this.map = map;
        this.current = map.getStart();
        this.inventory = new Inventory();
    }

    public Location getCurrent() { return current; }
    public void setCurrent(Location l) { current = l; }
    public GameMap getMap() { return map; }
    public Inventory getInventory() { return inventory; }
}
