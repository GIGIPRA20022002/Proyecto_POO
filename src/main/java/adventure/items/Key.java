package adventure.items;

public class Key extends Item {
    private String doorCode;

    public Key(String name, String description, double weight, String doorCode) {
        super(name, description, weight, true);
        this.doorCode = doorCode;
    }

    public String getDoorCode() { return doorCode; }

    @Override
    public String use() {
        return "This key opens a specific door.";
    }

    public boolean opensDoor(String exitCode) {
        return this.doorCode.equals(exitCode);
    }

    @Override
    public String toString() {
        return super.toString() + " [Key for: " + doorCode + "]";
    }
}