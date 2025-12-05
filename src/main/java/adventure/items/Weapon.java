package adventure.items;

public class Weapon extends Item {
    private int damage;
    private int durability;
    private boolean isEquipped;

    public Weapon(String name, String description, double weight, int damage, int durability) {
        super(name, description, weight, true);
        this.damage = damage;
        this.durability = durability;
        this.isEquipped = false;
    }

    public int getDamage() { return damage; }
    public int getDurability() { return durability; }
    public boolean isEquipped() { return isEquipped; }
    public void setEquipped(boolean equipped) { isEquipped = equipped; }

    public void reduceDurability() {
        if (durability > 0) durability--;
    }

    public boolean isBroken() { return durability <= 0; }

    @Override
    public String use() {
        if (isBroken()) {
            return "The " + getName() + " is out of durability.";
        }
        
        reduceDurability();
        if (isEquipped) {
            isEquipped = false;
            return "You unequipped " + getName() + ". Durability: " + durability;
        } else {
            isEquipped = true;
            return "You equipped " + getName() + ". Damage: " + damage;
        }
    }

    public int attack() {
        if (isBroken()) return 0;
        reduceDurability();
        return damage;
    }

    @Override
    public String toString() {
        String status = isBroken() ? "Broken" : "Durability: " + durability;
        return super.toString() + String.format(" [Weapon - Damage: %d, %s]", damage, status);
    }
}