package view;

import java.io.File;

/**
 * An abstract figure composed of a pacman image
 *
 * @inv position(x,y) with x>=0 and y>=0
 * @author Nassim Hmamouche
 */
public class Pacman extends ImageFigure{
    private int[] position;

    /**
     * Initialize the figure properties
     *
     */
    public Pacman(logic.Personnagelogic pacman){
        super(25, 25, pacman.position()[0], pacman.position()[1], "assets"+File.separator+"pacman.gif"); // séparateur de fichier différant selon l'OS (/ sur Linux, \ sur Windows)
        position = new int[]{pacman.position()[0], pacman.position()[1]};
        pacmanInvariant();
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
     * Verifies if the pacman position is positive
     */
    public final void pacmanInvariant(){
        assert getPosition()[0] >=0 && getPosition()[1] >=0 : "Position de l'objet négative!";
    }
}
