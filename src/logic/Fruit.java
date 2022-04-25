package logic;

import data.Data;

public interface Fruit {
    /**
     *
     * @return : list d'int de la position du fruit
     */
    int[] position(Data donnee);

    /**
     *
     * @return : String avec le type du fruit
     */
    String getType();

}
