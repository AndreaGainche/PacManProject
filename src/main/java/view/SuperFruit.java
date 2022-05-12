package view;

import java.io.File;
import java.util.Map;

/**
 * Create a superFruit shape with an image
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class SuperFruit extends ImageFigure{
    private static final Map<String, String> tabColor = Map.of("Cerise", "assets"+File.separator+"cerise.png",
                                                                "Fraise", "assets"+File.separator+"fraise.png",
                                                                "Banane", "assets"+File.separator+"banane.png",
                                                                "Pomme", "assets"+File.separator+"pomme.png",
                                                                "Orange", "assets"+File.separator+"orange.png",
                                                                "Melon", "assets"+File.separator+"melon.png"); // les 6 apparences de fruits possibles   
    private String type;
    private int[] position;

    /**
     * Constructs a SuperFruit
     * 
     * @param fruit implementation from logic package
     */
    public SuperFruit(logic.Fruit fruit){
        super(25, 25, fruit.positionIni()[0], fruit.positionIni()[1], tabColor.get(fruit.gettype()));
        position = fruit.positionIni();
        this.type = fruit.getType();
        superFruitInvariant();
    }

    /**
     * Returns the name of the fruit
     * 
     * @return fruit name
     */
    public String getType(){
        return type;
    }
    /**
     * Returns the position of the fruit
     * 
     * @return array of 2 int (X-position, Y-position)
     */
    public int[] getPosition(){
        return new int[]{position[0], position[1]};
    }

    /**
     * Verifies if the fruit position is positive
     */
    public final void superFruitInvariant(){
        assert getPosition()[0] >=0 && getPosition()[1] >=0;
    }
}
