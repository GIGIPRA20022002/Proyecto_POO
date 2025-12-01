package adventure.items;

public class Backpack extends Item {
    private Item containedItem;
    private double maxCapacity;

    /**
     * Constructor par a la mochila de 1 item
     * @param name Nombre de la mochila
     * @param description Descripción
     * @param weight Peso de la mochila vacía
     * @param maxCapacity Capacidad máxima de peso que puede cargar (para el item)
     */
    public Backpack(String name, String description, double weight, double maxCapacity) {
        super(name, description, weight, true);
        this.maxCapacity = maxCapacity;
        this.containedItem = null;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public Item getContainedItem() {
        return containedItem;
    }

    /**
     * Calcula el peso total (mochila + item contenido)
     * @return Peso total
     */
    public double getTotalWeight() {
        return getWeight() + (containedItem != null ? containedItem.getWeight() : 0);
    }

    /**
     * Obtiene el espacio disponible restante
     * @return Espacio disponible en la mochila
     */
    public double getAvailableSpace() {
        double currentItemWeight = containedItem != null ? containedItem.getWeight() : 0;
        return maxCapacity - currentItemWeight;
    }

    /**
     * Verifica si la mochila está vacía
     * @return true si no contiene ningún item
     */
    public boolean isEmpty() {
        return containedItem == null;
    }

    /**
     * Verifica si la mochila está llena
     * @return true si contiene un item
     */
    public boolean isFull() {
        return containedItem != null;
    }

    /**
     * Verifica si un item puede ser añadido a la mochila
     * @param item Item a verificar
     * @return true si la mochila está vacía y el item cabe
     */
    public boolean canAddItem(Item item) {
        return item.isCollectible() && 
               isEmpty() && 
               item.getWeight() <= maxCapacity;
    }

    /**
     * Añade un item a la mochila
     * @param item Item a añadir
     * @return true si se añadió exitosamente
     */
    public boolean addItem(Item item) {
        if (canAddItem(item)) {
            containedItem = item;
            return true;
        }
        return false;
    }

    /**
     * Remueve el item de la mochila
     * @return El item removido o null si estaba vacía
     */
    public Item removeItem() {
        Item removedItem = containedItem;
        containedItem = null;
        return removedItem;
    }

    /**
     * Remueve un item específico de la mochila (solo si es el que contiene)
     * @param item Item a remover
     * @return true si se removió exitosamente
     */
    public boolean removeItem(Item item) {
        if (containedItem != null && containedItem.equals(item)) {
            containedItem = null;
            return true;
        }
        return false;
    }

    /**
     * Busca un item en la mochila por nombre
     * @param itemName Nombre del item a buscar
     * @return El item encontrado o null si no existe o la mochila está vacía
     */
    public Item findItem(String itemName) {
        if (containedItem != null && containedItem.getName().equalsIgnoreCase(itemName)) {
            return containedItem;
        }
        return null;
    }

    /**
     * Verifica si la mochila contiene un item específico
     * @param itemName Nombre del item
     * @return true si contiene el item
     */
    public boolean containsItem(String itemName) {
        return findItem(itemName) != null;
    }

    /**
     * Intercambia el item actual por uno nuevo
     * @param newItem Nuevo item a guardar
     * @return El item que estaba en la mochila, o null si estaba vacía
     */
    public Item swapItem(Item newItem) {
        if (canAddItem(newItem)) {
            return null; // No había item para intercambiar, simplemente se añade
        }
        
        Item oldItem = containedItem;
        containedItem = newItem;
        return oldItem;
    }

    /**
     * Vacía la mochila
     * @return El item que contenía, o null si estaba vacía
     */
    public Item emptyBackpack() {
        Item item = containedItem;
        containedItem = null;
        return item;
    }

    /**
     * Muestra el contenido de la mochila
     * @return String con la información del item contenido
     */
    public String showContents() {
        if (isEmpty()) {
            return "Backpack is empty. You can carry up to 1 item that weights up to" + maxCapacity + " kg.";
        }

        return "Backpack contains: " + containedItem.toString() + 
               "\nWeight used: " + containedItem.getWeight() + "/" + maxCapacity + " kg";
    }

    @Override
    public String use() {
        return "You check your Backpack.\n" + showContents();
    }

    /**
     * Método específico para equipar/desplegar la mochila
     * @return Mensaje descriptivo
     */
    public String equip() {
        return "You have equipped " + getName() + ". You can carry up to 1 item (up to " + maxCapacity + " kg).";
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return super.toString() + " [Empty Backpack - Capacity: " + maxCapacity + " kg]";
        } else {
            return super.toString() + 
                   String.format(" [Backpack - Contains: %s (%.1f/%.1f kg)]", 
                               containedItem.getName(), containedItem.getWeight(), maxCapacity);
        }
    }
}
