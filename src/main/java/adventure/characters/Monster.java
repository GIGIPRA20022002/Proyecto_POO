package adventure.characters;

import adventure.items.Weapon;
import adventure.spells.Fireball;


public class Monster {
    private String name;
    private String description;
    private boolean isDefeated;
    private boolean requiresFireball; // Algunos monstruos solo mueren con fireball

    /**
     * Constructor para monstruo normal
     */
    public Monster(String name, String description) {
        this(name, description, false);
    }

    /**
     * Constructor para monstruo especial
     */
    public Monster(String name, String description, boolean requiresFireball) {
        this.name = name;
        this.description = description;
        this.isDefeated = false;
        this.requiresFireball = requiresFireball;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public boolean requiresFireball() {
        return requiresFireball;
    }

    /**
     * Atacar al monstruo con un arma
     * @param weapon El arma usada
     * @return true si el monstruo fue derrotado
     */
    public boolean attackWithWeapon(Weapon weapon) {
        if (isDefeated) {
            System.out.println(name + " ya está derrotado.");
            return false;
        }

        if (requiresFireball) {
            System.out.println("¡" + name + " es inmune a armas físicas!");
            System.out.println("Solo la Bola de Fuego puede derrotarlo.");
            return false;
        }

        if (weapon == null) {
            System.out.println("No tienes un arma equipada.");
            return false;
        }

        if (weapon.isBroken()) {
            System.out.println("Tu " + weapon.getName() + " está rota y no puede atacar.");
            return false;
        }

        // Usar el arma (reduce durabilidad)
        weapon.attack();
        isDefeated = true;
        System.out.println("¡Has derrotado a " + name + " con " + weapon.getName() + "!");
        return true;
    }

    /**
     * Atacar al monstruo con bola de fuego
     * @param fireball El hechizo usado
     * @return true si el monstruo fue derrotado
     */
    public boolean attackWithFireball(Fireball fireball) {
        if (isDefeated) {
            System.out.println(name + " ya está derrotado.");
            return false;
        }

        if (fireball == null) {
            System.out.println("No tienes bola de fuego disponible.");
            return false;
        }

        if (fireball.cast()) {
            isDefeated = true;
            System.out.println("¡Has incinerado a " + name + " con " + fireball.getName() + "!");
            return true;
        }
        
        return false;
    }

    /**
     * Método general para atacar (el juego decide con qué)
     */
    public boolean attack(Object attackObject) {
        if (attackObject instanceof Weapon) {
            return attackWithWeapon((Weapon) attackObject);
        } else if (attackObject instanceof Fireball) {
            return attackWithFireball((Fireball) attackObject);
        } else {
            System.out.println("No puedes atacar con eso.");
            return false;
        }
    }

    @Override
    public String toString() {
        String status = isDefeated ? "DERROTADO" : "VIVO";
        String type = requiresFireball ? " (solo vulnerable a fuego)" : "";
        return name + " - " + description + " [" + status + type + "]";
    }
}