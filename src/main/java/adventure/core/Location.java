package adventure.core;

import java.util.*;
import adventure.items.Item;

public class Location {
    private String name;
    private String description;
    private Map<String, Location> exits;
    private List<Item> items;  // Cambiar de String a Item

    public Location(String name, String desc) {
        this.name = name;
        this.description = desc;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public void addExit(String dir, Location loc) {
        exits.put(dir, loc);
    }

    public Location getExit(String dir) {
        return exits.get(dir);
    }

    public void addItem(String itemName) { 
        items.add(new Item(itemName, "Un " + itemName + " común.")); 
    }
    
    public boolean removeItem(String itemName) { 
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }
    
    public List<Item> getItems() { return items; }
    public String getDescription() { return description; }
    public String getName() { return name; }
}