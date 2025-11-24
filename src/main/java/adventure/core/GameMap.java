package adventure.core;

import java.util.*;

public class GameMap {
    private Map<String, Location> locations;

    public GameMap() {
        locations = new HashMap<>();

        Location start = new Location("Entrance", "A simple starting point.");
        Location hall = new Location("Hall", "A quiet hall.");

        start.addExit("north", hall);
        hall.addExit("south", start);

        // Add more items to test limits
        start.addItem("flashlight");
        start.addItem("map");
        start.addItem("compass");
        start.addItem("water");
        start.addItem("food");
        start.addItem("rope"); // This will be the sixth item (exceeds limit)
        
        hall.addItem("key");

        locations.put("start", start);
        locations.put("hall", hall);
    }

    public Location getStart() {
        return locations.get("start");
    }
}