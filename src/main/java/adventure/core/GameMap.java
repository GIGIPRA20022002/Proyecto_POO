package adventure.core;

import java.util.*;

public class GameMap {
    private Map<String, Location> locations;

    public GameMap() {
        locations = new HashMap<>();

        Location start = new Location("Entrance", "A simple starting point.");
        Location hall = new Location("Hall", "A quiet hall.");

        // En el constructor de GameMap, después de crear las ubicaciones:
        start.addExit("north", hall);
        hall.addExit("south", start);

        // Añadir items específicos para probar 'use'
        start.addItem("flashlight");
        start.addItem("map");
        start.addItem("key");  // Este item será usado en el ejemplo
        hall.addItem("potion");

        System.out.println("Map loaded with 2 locations and example items for testing 'use' command.");

        locations.put("start", start);
        locations.put("hall", hall);
    }

    public Location getStart() {
        return locations.get("start");
    }
}