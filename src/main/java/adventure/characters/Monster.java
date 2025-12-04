package adventure.characters;

import adventure.items.Weapon;
import adventure.spells.Fireball;

public class Monster extends Character {
    private boolean requiresFireball;

    public Monster(String name, String description, int health, boolean requiresFireball) {
        super(name, health);
        this.requiresFireball = requiresFireball;
    }

    public boolean requiresFireball() {
        return requiresFireball;
    }

    public boolean attackWithWeapon(Weapon weapon) {
        if (requiresFireball) {
            System.out.println(name + " is immune to physical weapons!");
            return false;
        }
        takeDamage(weapon.getDamage());
        return !isAlive();
    }

    public boolean attackWithFireball(Fireball fireball) {
        if (fireball != null && fireball.isLearned()) {
            takeDamage(50); // Daño alto
            return !isAlive();
        }
        return false;
    }

    public String getDescription() {
        return name + (requiresFireball ? " (requires Fireball)" : "");
    }
}