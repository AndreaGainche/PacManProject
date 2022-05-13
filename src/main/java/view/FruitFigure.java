package view;

import java.awt.Color;
import logic.Fruit;

/**
 * Creates a Fruit shape with a rectangle
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class FruitFigure extends Rectangle{
    /**
     * Creates an instance of fruit
     * 
     * @param fruit imported from Logic package
     */
    public FruitFigure(Fruit fruit){
        super(7, 7, fruit.position()[0], fruit.position()[1], Color.yellow);
    }
}
