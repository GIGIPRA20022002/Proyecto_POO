package adventure.commands;

import adventure.game.*;
import adventure.core.Location;
import adventure.items.Item;
import adventure.items.Key;

public class OpenCommand implements Command {
    public void execute(GameState state, String args) {
        if (args.isEmpty()) {
            System.out.println("Open what? Example: open north");
            return;
        }

        String direction = args.toLowerCase();
        Location current = state.getCurrent();
        String currentRoom = current.getName();
        
        // Verificar si hay una salida en esa dirección
        if (!current.getExits().containsKey(direction)) {
            System.out.println("There's no exit to the " + direction + ".");
            return;
        }

        // Verificar si está bloqueada
        if (!current.isExitLocked(direction)) {
            System.out.println("The " + direction + " exit is already open.");
            return;
        }

        // Obtener el item que lleva el jugador
        Item carriedItem = state.getInventory().getContainedItem();
        
        if (carriedItem == null) {
            System.out.println("You need a key to unlock the " + direction + " exit.");
            System.out.println("Your backpack is empty.");
            return;
        }
        
        if (!(carriedItem instanceof Key)) {
            System.out.println("You need a KEY to unlock the " + direction + " exit.");
            System.out.println("You're carrying: " + carriedItem.getName() + " (not a key)");
            return;
        }
        
        // Tenemos una llave
        Key key = (Key) carriedItem;
        String requiredKeyCode = getRequiredKeyCode(currentRoom, direction);
        
        System.out.println("DEBUG: You have " + key.getName() + " (opens: " + key.getDoorCode() + ")");
        System.out.println("DEBUG: This door requires key for: " + requiredKeyCode);
        
        if (key.getDoorCode().equals(requiredKeyCode)) {
            current.unlockExit(direction);
            System.out.println("✓ You unlock the " + direction + " exit with " + key.getName() + "!");
            System.out.println("The " + direction + " exit is now open.");
        } else {
            System.out.println("✗ The " + key.getName() + " doesn't fit this door.");
            System.out.println("This key opens: " + key.getDoorCode());
            System.out.println("This door needs: " + requiredKeyCode);
        }
    }

    private String getRequiredKeyCode(String roomName, String direction) {
        // Mapeo EXACTO según tu GameMap.java:
        // Room 1, north → "exit1" (Key1)
        // Room 2, east → "exit2" (Key2)
        // Room 3, north → "exit3" (Key3)
        // Room 4, east → "exit4" (Key4)
        
        if (roomName.contains("Room 1") && direction.equals("north")) {
            return "exit1";
        } else if (roomName.contains("Room 2") && direction.equals("east")) {
            return "exit2";
        } else if (roomName.contains("Room 3") && direction.equals("north")) {
            return "exit3";
        } else if (roomName.contains("Room 4") && direction.equals("east")) {
            return "exit4";
        }
        
        return "unknown";
    }
}