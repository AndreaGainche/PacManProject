package view;

import java.io.File;
import java.util.Map;
import logic.Fantome;

/**
 * An abstract figure composed of a ghost image
 *
 * @author Nassim Hmamouche
 */
public class FantomeFigure extends ImageFigure{
    private static final Map<String, String> tabColor = Map.of("Pinky", "assets"+File.separator+"fantomeRose.png",
                                                                "Blinky", "assets"+File.separator+"fantomeRouge.png",
                                                                "Inky", "assets"+File.separator+"fantomeBleu.png",
                                                                "Clyde", "assets"+File.separator+"fantomeOrange.png"); // les 4 apparences de fantômes possibles
    /**
     * Initialize the figure properties
     *
     */
    public FantomeFigure(Fantome fantome){
        super(25, 25, fantome.position()[0], fantome.position()[1], tabColor.get(fantome.getType()));
    }
}
