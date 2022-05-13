package logic;

/**
 * classe qui représente un fruit
 */

public interface Fruit {
    /**
     *
     * @return : list d'int de la position du fruit
     */
    int[] position();

    /**
     *
     * @return : String avec le type du fruit
     */
    String getType();

}