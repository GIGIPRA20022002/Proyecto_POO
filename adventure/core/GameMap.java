package adventure.core;

import java.util.*;

public class GameMap {
    private Map<String, Location> locations;

    public GameMap() {
        locations = new HashMap<>();

        Location start = new Location("Entrada", "Un inicio sencillo.");
        Location hall = new Location("Hall", "Un hall tranquilo.");

        start.addExit("norte", hall);
        hall.addExit("sur", start);

        start.addItem("linterna");
        hall.addItem("llave");

        locations.put("start", start);
        locations.put("hall", hall);
    }

    public Location getStart() {
        return locations.get("start");
    }
}
