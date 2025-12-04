package adventure.commands;

import adventure.game.*;
import adventure.characters.Hero;
import adventure.characters.Monster;
import adventure.items.Item;
import adventure.items.Weapon;

public class AttackCommand implements Command {
    public void execute(GameState state, String target) {
        if (target.isEmpty()) {
            System.out.println("Attack what? Example: attack monster");
            return;
        }

        Hero hero = state.getHero();
        
        // Obtener ubicación actual
        adventure.core.Location current = state.getCurrent(); // ← Especificar paquete completo
        
        // Verificar si hay monstruo en la sala
        if (current.getMonster() == null) {
            System.out.println("There's nothing to attack here.");
            return;
        }
        
        Monster monster = current.getMonster();
        
        // Verificar si el monstruo ya está derrotado
        if (!monster.isAlive()) {
            System.out.println("The " + monster.getName() + " is already defeated.");
            return;
        }
        
        hero.performAction(); // Contar como acción
        
        // Decidir qué usar para atacar
        Item currentItem = hero.getBackpack().getContainedItem();
        boolean useFireball = target.toLowerCase().contains("fireball") || 
                              (currentItem == null && hero.knowsFireball());
        
        String result;
        if (useFireball && hero.knowsFireball()) {
            result = "You cast Fireball at the " + monster.getName() + "!";
            if (monster.attackWithFireball(hero.getFireball())) {
                result += "\nThe " + monster.getName() + " is defeated!";
            } else {
                result += "\nThe " + monster.getName() + " resists the attack!";
            }
        } else if (currentItem instanceof Weapon) {
            result = "You attack the " + monster.getName() + " with " + currentItem.getName() + "!";
            if (monster.attackWithWeapon((Weapon) currentItem)) {
                result += "\nThe " + monster.getName() + " is defeated!";
            } else {
                result += "\nThe " + monster.getName() + " is too strong for your weapon!";
            }
        } else {
            result = "You have no weapon! Find a sword or learn Fireball first.";
        }
        
        System.out.println(result);
    }
}