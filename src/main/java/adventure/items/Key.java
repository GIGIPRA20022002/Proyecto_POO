package adventure.items;

public class Key extends Item {
        private String doorCode; // Código de la puerta que abre esta llave

    public Key(String name, String description, double weight, String doorCode) {
        super(name, description, weight, true);
        this.doorCode = doorCode;
    }

    public String getDoorCode() {
        return doorCode;
    }

    @Override
    public String use() {
        return "This key seems to fit a specific door. Look for a door with the same code.";
    }

    /**
     * Método específico para verificar si la llave abre una puerta específica
     * @param exitCode Código de la salida a verificar
     * @return true si la llave abre esa salida
     */
    public boolean opensDoor(String exitCode) {
        return this.doorCode.equals(exitCode);
    }

    @Override
    public String toString() {
        return super.toString() + " [Key for: " + doorCode + "]";
    }
}
