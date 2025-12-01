package adventure.game;

import adventure.core.*;
import adventure.items.*;

public class GameState {
    private GameMap map;
    private Location current;

    public GameState(GameMap map) {
        this.map = map;
        this.current = map.getStart();
    }

    public Location getCurrent() { return current; }
    public void setCurrent(Location l) { current = l; }
    public GameMap getMap() { return map; }
}
