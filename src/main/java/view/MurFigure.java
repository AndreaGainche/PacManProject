package view;

import java.awt.Color;
import logic.Mur;

/**
 * Creates a Mur shape with a blue square
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class MurFigure extends Rectangle {
    private static int size = 50;

    public MurFigure(Mur mur){
        super(size, size, mur.getPosition()[0], mur.getPosition()[1], Color.blue);
    }
}