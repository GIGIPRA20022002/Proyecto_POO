package adventure.items;

import java.util.*;

public class Inventory {
    private List<String> items;
    private int capacity;
    private int currentSize;

    public Inventory() {
        this.items = new ArrayList<>();
        this.capacity = 5; // Límite de 5 items
        this.currentSize = 0;
    }

    public boolean add(String item) {
        if (currentSize < capacity) {
            items.add(item);
            currentSize++;
            return true;
        }
        return false; // Mochila llena
    }

    public boolean remove(String item) {
        boolean removed = items.remove(item);
        if (removed) {
            currentSize--;
        }
        return removed;
    }

    public List<String> getItems() { return items; }
    public int getCapacity() { return capacity; }
    public int getCurrentSize() { return currentSize; }
    public boolean isFull() { return currentSize >= capacity; }
}