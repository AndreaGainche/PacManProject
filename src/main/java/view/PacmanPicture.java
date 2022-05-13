package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.io.File;

import logic.*;

/**
 * Create shapes and display them
 *
 * @author Nassim Hmamouche
 */
public class PacmanPicture {
    private GrilleFigure grille;
    private ImageFigure logo;

    /**
     * Create a new picture with grid.
     */
    public PacmanPicture(Grille grilleLogic) {
        grille = new GrilleFigure(grilleLogic); // grilleLogic.dimensionGrille()+20
        logo = new ImageFigure(150, 28, 175, 520, "assets" + File.separator + "logo.png");
        this.draw();
        this.animate();
    }

    /**
     * Draws all the shapes
     */
    public void draw() {
        logo.draw();
        grille.draw();
    }

    /**
     * Animates all the shapes
     */
    public void animate() {
        while (true) {
            if (CanvasFrame.getCanvas().isUpPressed()) {
                grille.actualisation(1);
                CanvasFrame.getCanvas().redraw();
            } else if (CanvasFrame.getCanvas().isRightPressed()) {
                grille.actualisation(2);
                CanvasFrame.getCanvas().redraw();
            } else if (CanvasFrame.getCanvas().isLeftPressed()) {
                grille.actualisation(3);
                CanvasFrame.getCanvas().redraw();
            } else if (CanvasFrame.getCanvas().isDownPressed()) {
                grille.actualisation(4);
                CanvasFrame.getCanvas().redraw();
            } else {
                grille.actualisation(0);
                CanvasFrame.getCanvas().redraw();
            }
            CanvasFrame.getCanvas().wait(100);
        }
    }
}