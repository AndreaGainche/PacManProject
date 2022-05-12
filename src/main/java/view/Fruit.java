package view;

import java.awt.Color;

/**
 * Creates a Fruit shape with a rectangle
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class Fruit extends Rectangle{
    private int[] position;

    /**
     * Creates an instance of fruit
     * 
     * @param fruit imported from Logic package
     */
    public Fruit(logic.Fruit fruit){
        super(7, 7, fruit.getPosition()[0], fruit.getPosition()[1], Color.yellow);
        position = fruit.getPosition();
        fruitInvariant();
    }

    /**
     * Returns the position
     * 
     * @return int array containing X-position and Y-position
     */
    public int[] getPosition(){
        return new int[]{position[0], position[1]};
    }

    /**
     * Verifies if the fruit position is positive
     */
    public final void fruitInvariant(){
        assert getPosition()[0] >=0 && getPosition()[1] >=0 : "Position de l'objet négative!";
    }
}
