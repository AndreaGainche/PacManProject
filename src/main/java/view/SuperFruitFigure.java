package view;

import java.io.File;
import java.util.Map;
import logic.Fruit;

/**
 * Create a superFruit shape with an image
 *
 * @inv table of colors contains the name of fruit
 * @author Nassim Hmamouche
 */
public class SuperFruitFigure extends ImageFigure{
    private static final Map<String, String> tabColor = Map.of("Cerise", "assets"+File.separator+"cerise.png",
                                                                "Fraise", "assets"+File.separator+"fraise.png",
                                                                "Banane", "assets"+File.separator+"banane.png",
                                                                "Pomme", "assets"+File.separator+"pomme.png",
                                                                "Orange", "assets"+File.separator+"orange.png",
                                                                "Melon", "assets"+File.separator+"melon.png"); // les 6 apparences de fruits possibles   
    private String type;

    /**
     * Constructs a SuperFruit
     * 
     * @param fruit implementation from logic package
     */
    public SuperFruitFigure(Fruit fruit){
        super(25, 25, fruit.position()[0], fruit.position()[1], tabColor.get(fruit.getType()));
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
     * Checks if the fruit name exists
     */
    public final void superFruitInvariant(){
        assert tabColor.containsKey(this.getType()) : "Nom de fruit inexistant!";
    }
}
