package adventure.characters;

import adventure.items.Backpack;
import adventure.items.Item;
import adventure.items.Weapon;
import adventure.spells.Fireball;

/**
 * Clase del héroe/jugador con sistema de inventario limitado a 1 item
 * y capacidad de usar bola de fuego.
 */
public class Hero {
    private String name;
    private int healthPoints;
    private int maxHealthPoints;
    private Backpack backpack;
    private Fireball fireball; // El hechizo de bola de fuego

    public Hero(String name, int maxHealthPoints) {
        this.name = name;
        this.maxHealthPoints = maxHealthPoints;
        this.healthPoints = maxHealthPoints;
        this.fireball = null; // Inicialmente sin hechizo
        
        // Crear una mochila que solo permite 1 item
        this.backpack = new Backpack("Backpack",
                "A backpack to carry 1 item",
                0.5, 5.0);
    }

    /**
     * Aprender el hechizo de bola de fuego
     */
    public void learnFireball() {
        if (fireball == null) {
            fireball = new Fireball();
        }
        fireball.learn();
    }

    /**
     * Aprender un hechizo específico
     */
    public void learnFireball(Fireball spell) {
        this.fireball = spell;
        fireball.learn();
    }

    public Fireball getFireball() {
        return fireball;
    }

    public boolean knowsFireball() {
        return fireball != null && fireball.isLearned();
    }

    /**
     * Atacar a un monstruo usando el arma actual o bola de fuego
     */
    public boolean attackMonster(Monster monster, boolean useFireball) {
        if (useFireball && knowsFireball()) {
            return monster.attackWithFireball(fireball);
        } else {
            // Buscar un arma en la mochila
            Item currentItem = backpack.getContainedItem();
            if (currentItem instanceof Weapon) {
                return monster.attackWithWeapon((Weapon) currentItem);
            } else {
                System.out.println("You've got not weapon equipped for attack.");
                return false;
            }
        }
    }

    /**
     * Método general de ataque (para comandos)
     */
    public String attack(String target, boolean useFireball) {
        // Este método se integraría con tu sistema de comandos
        // target sería el nombre del monstruo
        return "Comannd ATTACK implemented here...";
    }

    // ... resto de los métodos existentes de Hero (takeItem, dropItem, etc.)
    
    /**
     * Mostrar habilidades del héroe
     */
    public String showAbilities() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hero abilities ").append(name).append(":\n");
        
        // Ver si tiene arma
        Item currentItem = backpack.getContainedItem();
        if (currentItem instanceof Weapon) {
            Weapon weapon = (Weapon) currentItem;
            sb.append("- Weapon: ").append(weapon.getName());
            sb.append(weapon.isEquipped() ? " (equipped)" : " (not equipped)").append("\n");
        }
        
        // Ver si tiene bola de fuego
        if (knowsFireball()) {
            sb.append("- Spell: ").append(fireball.toString()).append("\n");
        } else {
            sb.append("- Spell: No spell known\n");
        }
        
        return sb.toString();
    }

    //FALTA AÑADIR QUE CUANDO EL HEROE HAGA UNA ACCION (COMANDO) PIERDA 1 PUNTO DE VIDA
}