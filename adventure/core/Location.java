package adventure.core;

import java.util.*;

public class Location {
    private String name;
    private String description;
    private Map<String, Location> exits;
    private List<String> items;

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

    public void addItem(String i) { items.add(i); }
    public boolean removeItem(String i) { return items.remove(i); }
    public List<String> getItems() { return items; }
    public String getDescription() { return description; }
    public String getName() { return name; }
}