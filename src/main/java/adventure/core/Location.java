package adventure.core;

import java.util.*;
import adventure.items.Item;
import adventure.items.BasicItem;
import adventure.characters.Monster;

public class Location {
    private String name;
    private String description;
    private Map<String, Location> exits;
    private List<Item> items;
    private Monster monster;
    private Map<String, Boolean> lockedExits;

    public Location(String name, String desc) {
        this.name = name;
        this.description = desc;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.monster = null;
        this.lockedExits = new HashMap<>();
    }

    // ===== EXITS =====
    public void addExit(String dir, Location loc) {
        exits.put(dir, loc);
        lockedExits.put(dir, false);
    }

    public Map<String, Location> getExits() {  // ← MÉTODO NUEVO
        return exits;
    }

    public void lockExit(String dir) {
        lockedExits.put(dir, true);
    }

    public boolean isExitLocked(String dir) {
        return lockedExits.getOrDefault(dir, false);
    }

    public void unlockExit(String dir) {
        lockedExits.put(dir, false);
    }

    public Location getExit(String dir) {
        if (isExitLocked(dir)) {
            System.out.println("The exit to " + dir + " is locked!");
            return null;
        }
        return exits.get(dir);
    }

    // ===== ITEMS =====
    public void addItem(Item item) { 
        items.add(item); 
    }
    
    public void addItem(String itemName) {
        items.add(new BasicItem(itemName, "A " + itemName + ".", 1.0));
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
    
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    public List<Item> getItems() { return items; }

    // ===== MONSTER =====
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasMonster() {
        return monster != null && monster.isAlive();
    }

    // ===== GETTERS SIMPLES =====
    public String getDescription() { 
        return description; 
    }
    
    public String getName() { 
        return name; 
    }

    // ===== DESCRIPCIÓN COMPLETA =====
    public String getFullDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(name).append(" ===\n");
        sb.append(description).append("\n\n");
        
        // Exits
        if (!exits.isEmpty()) {
            sb.append("Exits: ");
            for (String dir : exits.keySet()) {
                sb.append(dir);
                if (isExitLocked(dir)) sb.append(" [LOCKED]");
                sb.append(" ");
            }
            sb.append("\n");
        }
        
        // Items
        if (!items.isEmpty()) {
            sb.append("Items here: ");
            for (Item item : items) {
                sb.append(item.getName()).append(" ");
            }
            sb.append("\n");
        }
        
        // Monster
        if (hasMonster()) {
            sb.append("There is a ").append(monster.getName()).append(" here!\n");
        }
        
        return sb.toString();
    }
}