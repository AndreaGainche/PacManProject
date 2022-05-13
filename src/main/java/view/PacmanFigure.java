package view;

import java.io.File;
import logic.Pacman;
import logic.Personnagelogic;

/**
 * An abstract figure composed of a pacman image
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class PacmanFigure extends ImageFigure{
    private Personnagelogic pacmanLogic;

    /**
     * Initialize the figure properties
     *
     */
    public PacmanFigure(Personnagelogic pacman){
        super(25, 25, pacman.position()[0], pacman.position()[1], "assets"+File.separator+"pacman.gif"); // séparateur de fichier différant selon l'OS (/ sur Linux, \ sur Windows
        pacmanLogic = pacman;
    }

    /**
     * Moves Pacman into the grid
     */
    public void deplace(){
        int[] newPos = new int[]{pacmanLogic.position()[0], pacmanLogic.position()[1]};
        this.move(newPos[0] - getPosition()[0], newPos[1] - getPosition()[1]);
    }
}
