package adventure.items;

public class BasicItem extends Item {
    public BasicItem(String name, String description, double weight) {
        super(name, description, weight, true);
    }

    @Override
    public String use() {
        return "You use the " + getName() + ".";
    }
}
