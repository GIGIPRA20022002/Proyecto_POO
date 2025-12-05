package adventure.items;

public abstract class Item {
    private String name;
    private String description;
    private double weight;
    private boolean isCollectible;

    public Item(String name, String description, double weight, boolean isCollectible) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.isCollectible = isCollectible;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getWeight() { return weight; }
    public boolean isCollectible() { return isCollectible; }

    public abstract String use();

    @Override
    public String toString() {
        return String.format("%s: %s (Weight: %.1f)", name, description, weight);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}