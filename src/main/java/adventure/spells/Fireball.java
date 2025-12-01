package adventure.spells;

public class Fireball {
    private String name;
    private boolean isLearned;

    public Fireball() {
        this.name = "Fireball";
        this.isLearned = false;
    }

    public Fireball(String name) {
        this.name = name;
        this.isLearned = false;
    }

    public String getName() {
        return name;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void learn() {
        this.isLearned = true;
        System.out.println("¡You have learned: " + name + "!");
    }

    /**
     * Lanza la bola de fuego contra un monstruo
     * @return true siempre (mata instantáneamente si se sabe)
     */
    public boolean cast() {
        if (!isLearned) {
            System.out.println("You don't know the spell " + name + ".");
            return false;
        }
        
        System.out.println("¡Shooting a " + name + " that burns the monster!");
        return true;
    }

    @Override
    public String toString() {
        return name + " [status: " + (isLearned ? "LEARNED" : "NOT LEARNED") + "]";
    }
}