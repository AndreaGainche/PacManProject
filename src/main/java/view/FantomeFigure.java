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
    private Fantome fantomeLogic;
    private static final Map<String, String> tabColor = Map.of("Pinky", "assets"+File.separator+"fantomeRose.png",
                                                                "Blinky", "assets"+File.separator+"fantomeRouge.png",
                                                                "Inky", "assets"+File.separator+"fantomeBleu.png",
                                                                "Clyde", "assets"+File.separator+"fantomeOrange.png"); // les 4 apparences de fantômes possibles
    /**
     * Initialize the figure properties
     *
     */
    public FantomeFigure(Fantome fantomeLogic){
        super(25, 25, fantomeLogic.position()[0], fantomeLogic.position()[1], tabColor.get(fantomeLogic.getType()));
        this.fantomeLogic = fantomeLogic;
    }

    /**
     * Moves the ghost into the grid
     */
    public void deplace(){
        int[] newPos = new int[]{fantomeLogic.position()[0], fantomeLogic.position()[1]};
        this.move(newPos[0] - getPosition()[0], newPos[1] - getPosition()[1]);
    }
}
