package adventure.core;

import java.util.*;
import adventure.items.*;
import adventure.characters.Monster;

public class GameMap {
    private Map<String, Location> locations;

    public GameMap() {
        locations = new HashMap<>();
        createRooms();
        placeItems();
        placeMonsters();
        setupExits();
    }

    private void createRooms() {
        Location room1 = new Location("Room 1 - Entrance", 
            "You are in a dark entrance room. There are strange symbols on the walls.");
        
        Location room2 = new Location("Room 2 - Corridor", 
            "A long corridor with flickering torches. You can hear distant noises.");
        
        Location room3 = new Location("Room 3 - Monster Lair", 
            "A damp room with bones scattered on the floor. It smells terrible here.");
        
        Location room4 = new Location("Room 4 - Final Chamber", 
            "A large chamber with a glowing exit door. This is your way out!");

        locations.put("room1", room1);
        locations.put("room2", room2);
        locations.put("room3", room3);
        locations.put("room4", room4);
    }

    private void placeItems() {
        Location room1 = locations.get("room1");
        Location room2 = locations.get("room2");
        Location room3 = locations.get("room3");
        Location room4 = locations.get("room4");

        room1.addItem(new Key("Key1", "A rusty iron key", 0.2, "exit1"));
        room1.addItem(new Weapon("Sword", "A basic iron sword", 2.0, 10, 5));
        room1.addItem(new BasicItem("Fireball Scroll", 
            "A scroll that teaches you the Fireball spell when used", 0.1));

        room2.addItem(new Key("Key2", "A silver key with strange markings", 0.2, "exit2"));
        room2.addItem(new Key("Key3", "A golden key", 0.2, "exit3"));
        room2.addItem(new Key("Key4", "A crystal key that glows softly", 0.2, "exit4"));
        room2.addItem(new Food("Bread", "Fresh bread that restores health", 0.5, 3));

        room3.addItem(new Food("Apple", "A red apple", 0.2, 2));
        room4.addItem(new Food("Potion", "A healing potion", 0.3, 5));
    }

    private void placeMonsters() {
        Location room3 = locations.get("room3");
        Location room4 = locations.get("room4");

        room3.setMonster(new Monster("Goblin", "A small but aggressive goblin", 5, false));
        room4.setMonster(new Monster("Fire Demon", 
            "A massive demon made of fire. Only magic can defeat it!", 10, true));
    }

    private void setupExits() {
        Location room1 = locations.get("room1");
        Location room2 = locations.get("room2");
        Location room3 = locations.get("room3");
        Location room4 = locations.get("room4");

        room1.addExit("north", room2);
        room2.addExit("south", room1);
        room2.addExit("east", room3);
        room3.addExit("west", room2);
        room3.addExit("north", room4);
        room4.addExit("south", room3);

        room1.lockExit("north");
        room2.lockExit("east");
        room3.lockExit("north");
        
        room4.addExit("east", null);
    }

    public Location getStart() {
        return locations.get("room1");
    }

    public Location getLocation(String name) {
        return locations.get(name.toLowerCase());
    }
}