package adventure.items;

public class Backpack extends Item {
    private Item containedItem;
    private double maxCapacity;

    public Backpack(String name, String description, double weight, double maxCapacity) {
        super(name, description, weight, true);
        this.maxCapacity = maxCapacity;
        this.containedItem = null;
    }

    public double getMaxCapacity() { return maxCapacity; }
    public Item getContainedItem() { return containedItem; }
    public double getTotalWeight() { return getWeight() + (containedItem != null ? containedItem.getWeight() : 0); }
    public double getAvailableSpace() { return maxCapacity - (containedItem != null ? containedItem.getWeight() : 0); }
    public boolean isEmpty() { return containedItem == null; }
    public boolean isFull() { return containedItem != null; }

    public boolean canAddItem(Item item) {
        return item.isCollectible() && isEmpty() && item.getWeight() <= maxCapacity;
    }

    public boolean addItem(Item item) {
        if (canAddItem(item)) {
            containedItem = item;
            return true;
        }
        return false;
    }

    public Item removeItem() {
        Item removedItem = containedItem;
        containedItem = null;
        return removedItem;
    }

    public boolean removeItem(Item item) {
        if (containedItem != null && containedItem.equals(item)) {
            containedItem = null;
            return true;
        }
        return false;
    }

    public Item findItem(String itemName) {
        if (containedItem != null && containedItem.getName().equalsIgnoreCase(itemName)) {
            return containedItem;
        }
        return null;
    }

    public boolean containsItem(String itemName) {
        return findItem(itemName) != null;
    }

    public Item swapItem(Item newItem) {
        Item old = containedItem;
        containedItem = newItem;
        return old;
    }

    public Item emptyBackpack() {
        Item item = containedItem;
        containedItem = null;
        return item;
    }

    public String showContents() {
        if (isEmpty()) {
            return "Backpack is empty. Capacity: " + maxCapacity + " kg.";
        }
        return "Backpack contains: " + containedItem.toString();
    }

    @Override
    public String use() {
        return "You check your backpack:\n" + showContents();
    }

    @Override
    public String toString() {
        if (isEmpty()) return super.toString() + " [Empty Backpack]";
        return super.toString() + " [Contains: " + containedItem.getName() + "]";
    }

    // Métodos compatibles con Inventory
    public boolean add(Item item) { return addItem(item); }
    
    public Item remove(String itemName) {
        if (containedItem != null && containedItem.getName().equalsIgnoreCase(itemName)) {
            return removeItem();
        }
        return null;
    }

    public Item getItem(String itemName) { return findItem(itemName); }
    public int getCapacity() { return 1; }
    public int getCurrentSize() { return isEmpty() ? 0 : 1; }
}