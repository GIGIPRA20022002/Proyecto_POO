package adventure.core;

import java.util.*;

import adventure.items.BasicItem;
import adventure.items.Item;

public class Location {
    private String name;
    private String description;
    private Map<String, Location> exits;
    private List<Item> items;

    public Location(String name, String desc) {
        this.name = name;
        this.description = desc;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    // =============================
    // EXITS
    // =============================
    public void addExit(String dir, Location loc) {
        exits.put(dir, loc);
    }

    public Location getExit(String dir) {
        return exits.get(dir);
    }

    // =============================
    // ITEMS (VERSIÓN CORRECTA)
    // =============================

    /** Añadir un Item real (usado por Take, Drop, etc.) */
    public void addItem(Item item) {
        items.add(item);
    }

    /** Compatibilidad: crear un BasicItem si solo te dan un String */
    public void addItem(String itemName) {
        items.add(new BasicItem(itemName, "Un " + itemName + " común.", 1.0));
    }

    /** Eliminar por nombre */
    public boolean removeItem(String itemName) {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getName().equalsIgnoreCase(itemName)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /** Obtener un item exacto */
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
