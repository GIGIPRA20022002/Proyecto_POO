package adventure.items;

import java.util.*;

public class Inventory {
    private List<Item> items;  // Cambiar de String a Item
    private int capacity;
    private int currentSize;

    public Inventory() {
        this.items = new ArrayList<>();
        this.capacity = 5;
        this.currentSize = 0;
    }

    public boolean add(Item item) {
        if (currentSize < capacity) {
            items.add(item);
            currentSize++;
            return true;
        }
        return false;
    }

    public boolean remove(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                currentSize--;
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
    public int getCapacity() { return capacity; }
    public int getCurrentSize() { return currentSize; }
    public boolean isFull() { return currentSize >= capacity; }
}