package adventure.items;

import java.util.*;

public class Inventory {
    private List<String> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void add(String i) { items.add(i); }
    public boolean remove(String i) { return items.remove(i); }
    public List<String> getItems() { return items; }
}
