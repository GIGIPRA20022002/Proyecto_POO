package adventure.items;

public class Food extends Item {
    private int healthPoints;
    private boolean isConsumed;

    public Food(String name, String description, double weight, int healthPoints) {
        super(name, description, weight, true);
        this.healthPoints = healthPoints;
        this.isConsumed = false;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public boolean isConsumed() {
        return isConsumed;
    }

    @Override
    public String use() {
        if (isConsumed) {
            return "You have consumed this food.";
        }
        
        isConsumed = true;
        return String.format("You have consumed %s and recovered %d health", getName(), healthPoints);
    }

    /**
     * Método específico para obtener los puntos de salud sin consumir la comida
     * @return Puntos de salud que proporciona la comida
     */
    public int getHealthBenefits() {
        return isConsumed ? 0 : healthPoints;
    }

    /**
     * Método para consumir la comida y obtener sus beneficios
     * @return Puntos de salud obtenidos
     */
    public int consume() {
        if (isConsumed) {
            return 0;
        }
        isConsumed = true;
        return healthPoints;
    }

    @Override
    public String toString() {
        String status = isConsumed ? "CONSUMIDO" : "Puntos de salud: +" + healthPoints;
        return super.toString() + " [Comida - " + status + "]";
    }
}
