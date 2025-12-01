package adventure.items;

public class Backpack extends Item {
    private Item containedItem;
    private double maxCapacity;

    public Backpack(String name, String description, double weight, double maxCapacity) {
        super(name, description, weight, true);
        this.maxCapacity = maxCapacity;
        this.containedItem = null;
    }

    // =========================================================
    // MÉTODOS ORIGINALES (NO LOS TOCO)
    // =========================================================

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public Item getContainedItem() {
        return containedItem;
    }

    public double getTotalWeight() {
        return getWeight() + (containedItem != null ? containedItem.getWeight() : 0);
    }

    public double getAvailableSpace() {
        double currentItemWeight = containedItem != null ? containedItem.getWeight() : 0;
        return maxCapacity - currentItemWeight;
    }

    public boolean isEmpty() {
        return containedItem == null;
    }

    public boolean isFull() {
        return containedItem != null;
    }

    public boolean canAddItem(Item item) {
        return item.isCollectible() &&
                isEmpty() &&
                item.getWeight() <= maxCapacity;
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
            return "Backpack is empty. You can carry 1 item up to " + maxCapacity + " kg.";
        }
        return "Backpack contains: " + containedItem.toString();
    }

    @Override
    public String use() {
        return "You check your backpack:\n" + showContents();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return super.toString() + " [Empty Backpack - " + maxCapacity + "kg]";
        return super.toString() + " [Contains: " + containedItem.getName() + "]";
    }


    // =========================================================
    // 🔥 MÉTODOS COMPATIBLES CON INVENTORY (NECESARIOS PARA LOS COMANDOS)
    // =========================================================

    // compatibility with inventory.add(Item)
    public boolean add(Item item) {
        return addItem(item);
    }

    // compatibility with inventory.remove(String)
    public Item remove(String itemName) {
        if (containedItem != null &&
            containedItem.getName().equalsIgnoreCase(itemName)) {
            return removeItem();
        }
        return null;
    }

    // compatibility with inventory.getItem(String)
    public Item getItem(String itemName) {
        return findItem(itemName);
    }

    // compatibility with inventory.getCapacity()
    public int getCapacity() {
        return 1; // solo puede contener 1 item
    }

    // compatibility with inventory.getCurrentSize()
    public int getCurrentSize() {
        return isEmpty() ? 0 : 1;
    }
}
