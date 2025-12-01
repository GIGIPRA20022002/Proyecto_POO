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

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

    /**
     * Reduce la durabilidad del arma al usarla
     */
    public void reduceDurability() {
        if (durability > 0) {
            durability--;
        }
    }

    public boolean isBroken() {
        return durability <= 0;
    }

    @Override
    public String use() {
        if (isBroken()) {
            return "The " + getName() + " is out of durability and cannot be used.";
        }
        
        reduceDurability();
        if (isEquipped) {
            isEquipped = false;
            return "You have unequipped " + getName() + ". Durability left: " + durability;
        } else {
            isEquipped = true;
            return "You have equipped " + getName() + ". Damage: " + damage + ". Durability: " + durability;
        }
    }

    /**
     * Método específico para usar el arma en combate
     * @return Daño infligido (0 si el arma está rota)
     */
    public int attack() {
        if (isBroken()) {
            return 0;
        }
        reduceDurability();
        return damage;
    }

    @Override
    public String toString() {
        String status = isBroken() ? "Broken" : "Durability: " + durability;
        return super.toString() + String.format(" [Weapon - Damage: %d, %s]", damage, status);
    }
}

