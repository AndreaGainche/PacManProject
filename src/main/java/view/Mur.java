package view;

import java.awt.Color;

/**
 * Creates a Mur shape with a blue square
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class Mur extends Rectangle {
    private static int size = 50;
    private int[] position;

    public Mur(logic.Mur mur){
        super(size, size, mur.getPosition()[0], mur.getPosition()[1], Color.blue);
        position =  new int[]{mur.getPosition()[0], mur.getPosition()[1]};
        murInvariant();
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
     * Verifies if the wall position is positive
     */
    public final void murInvariant(){
        assert getPosition()[0] >=0 && getPosition()[1] >=0 : "Position de l'objet négative!";
    }
}