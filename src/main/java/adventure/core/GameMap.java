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
        
        System.out.println("Dungeon loaded with 4 rooms.");
    }

    private void createRooms() {
        // Crear las 4 salas exactas como especificaste
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

    // === CORREGIDO ===
    // Sala 1: Solo Key1, Sword, Fireball Scroll
    room1.addItem(new Key("Key1", "A rusty iron key", 0.2, "exit1"));
    room1.addItem(new Weapon("Sword", "A basic iron sword", 2.0, 10, 5));
    room1.addItem(new BasicItem("Fireball Scroll", 
        "A scroll that teaches you the Fireball spell when used", 0.1));

    // Sala 2: Key2, Key3, Key4, Bread
    room2.addItem(new Key("Key2", "A silver key with strange markings", 0.2, "exit2"));
    room2.addItem(new Key("Key3", "A golden key", 0.2, "exit3"));
    room2.addItem(new Key("Key4", "A crystal key that glows softly", 0.2, "exit4"));
    room2.addItem(new Food("Bread", "Fresh bread that restores health", 0.5, 3));

    // Sala 3: Comida
    room3.addItem(new Food("Apple", "A red apple", 0.2, 2));

    // Sala 4: Comida
    room4.addItem(new Food("Potion", "A healing potion", 0.3, 5));
    
    System.out.println("Items placed correctly:");
    System.out.println("  Room 1: Key1, Sword, Fireball Scroll");
    System.out.println("  Room 2: Key2, Key3, Key4, Bread");
    System.out.println("  Room 3: Apple");
    System.out.println("  Room 4: Potion");
}

    private void placeMonsters() {
        Location room3 = locations.get("room3");
        Location room4 = locations.get("room4");

        // Monstruo normal en sala 3 (se puede vencer con espada o fireball)
        room3.setMonster(new Monster("Goblin", "A small but aggressive goblin", 5, false));
        
        // Monstruo final en sala 4 (solo se vence con fireball)
        room4.setMonster(new Monster("Fire Demon", 
            "A massive demon made of fire. Only magic can defeat it!", 10, true));
    }

    private void setupExits() {
        Location room1 = locations.get("room1");
        Location room2 = locations.get("room2");
        Location room3 = locations.get("room3");
        Location room4 = locations.get("room4");

        // Conectar salas
        room1.addExit("north", room2);  // Salida 1 → sala 2
        room2.addExit("south", room1);  // Entrada 1 → sala 1
        room2.addExit("east", room3);   // Salida 2 → sala 3
        room3.addExit("west", room2);   // Entrada 2 → sala 2
        room3.addExit("north", room4);  // Salida 3 → sala 4
        room4.addExit("south", room3);  // Entrada 3 → sala 3

        // Bloquear salidas con llaves
        room1.lockExit("north");    // Salida 1 necesita Key1
        room2.lockExit("east");     // Salida 2 necesita Key2
        room3.lockExit("north");    // Salida 3 necesita Key3
        
        // Salida 4 (final) bloqueada por monstruo, no por llave
        room4.addExit("east", null); // Salida final (victoria)
        System.out.println("Exits configured. Some are locked!");
    }

    public Location getStart() {
        return locations.get("room1");
    }

    public Location getLocation(String name) {
        return locations.get(name.toLowerCase());
    }
}