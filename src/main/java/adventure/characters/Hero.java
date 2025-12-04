package adventure.characters;

import adventure.items.Backpack;
import adventure.items.Item;
import adventure.items.Weapon;
import adventure.spells.Fireball;

public class Hero extends Character {
    private Backpack backpack;
    private Fireball fireball;
    private int actionsCount; // Para contar acciones y perder vida

    public Hero(String name, int maxHealth) {
        super(name, maxHealth);
        this.backpack = new Backpack("Backpack", "Your backpack", 0.5, 10);
        this.fireball = null;
        this.actionsCount = 0;
    }

    // ===== SISTEMA DE ACCIONES Y VIDA =====
    public void performAction() {
        actionsCount++;
        // Cada 3 acciones, pierde 1 de vida
        if (actionsCount % 3 == 0) {
            takeDamage(1);
            System.out.println("You feel tired... (-1 HP)");
        }
    }

    // ===== MÉTODOS DE HECHIZOS =====
    public void learnFireball() {
        if (fireball == null) {
            fireball = new Fireball();
            fireball.learn();
        }
    }

    public Fireball getFireball() {
        return fireball;
    }

    public boolean knowsFireball() {
        return fireball != null && fireball.isLearned();
    }

    // ===== MÉTODOS DE MOCHILA =====
    public Backpack getBackpack() {
        return backpack;
    }

    public boolean takeItem(Item item) {
        performAction(); // Contar como acción
        return backpack.addItem(item);
    }

    public Item dropItem(String itemName) {
        performAction(); // Contar como acción
        return backpack.remove(itemName);
    }

    public Item getItem(String itemName) {
        return backpack.findItem(itemName);
    }

    // ===== ATAQUE SIMPLIFICADO =====
    public String attackMonster(Monster monster, boolean useFireball) {
        performAction(); // Contar como acción
        
        if (useFireball && knowsFireball()) {
            if (monster.attackWithFireball(fireball)) {
                return "You cast Fireball and defeat " + monster.getName() + "!";
            }
            return "Fireball failed against " + monster.getName();
        } else {
            Item item = backpack.getContainedItem();
            if (item instanceof Weapon) {
                if (monster.attackWithWeapon((Weapon) item)) {
                    return "You attack with " + item.getName() + " and defeat " + monster.getName() + "!";
                }
                return "Your weapon is ineffective against " + monster.getName();
            }
            return "You have no weapon to attack with!";
        }
    }

    // ===== INFO =====
    public String showStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(name).append(" ===\n");
        sb.append("HP: ").append(health).append("/").append(maxHealth).append("\n");
        sb.append("Fireball: ").append(knowsFireball() ? "LEARNED" : "NOT LEARNED").append("\n");
        sb.append(backpack.showContents()).append("\n");
        return sb.toString();
    }
}