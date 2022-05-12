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
    public PacmanPicture(Grille grilleLogic){
        grille = new GrilleFigure(grilleLogic);
        logo = new ImageFigure(150, 28, 175, grilleLogic.dimensionGrille()+20, "assets"+File.separator+"logo.png");
        this.draw();
        this.animate();
    }

    /** 
     * Draws all the shapes
     */
    public void draw(){
        grille.draw();
        logo.draw();
    }
    
    /**
     * Animates all the shapes
     */
    public void animate(){
        while(true){
            CanvasFrame.getCanvas().wait(50);

            if(CanvasFrame.getCanvas().isSpacePressed()){
                grille.actualisation(0);
                CanvasFrame.getCanvas().redraw();
            }
            if(CanvasFrame.getCanvas().isUpPressed()){
                grille.actualisation(1);
                CanvasFrame.getCanvas().redraw();
            }
            if(CanvasFrame.getCanvas().isUpPressed()){
                grille.actualisation(1);
                CanvasFrame.getCanvas().redraw();
            }      
            if(CanvasFrame.getCanvas().isRightPressed()){
                grille.actualisation(2);
                CanvasFrame.getCanvas().redraw();
            }
            if(CanvasFrame.getCanvas().isLeftPressed()){
                grille.actualisation(3);
                CanvasFrame.getCanvas().redraw();
            }
            if(CanvasFrame.getCanvas().isDownPressed()){
                grille.actualisation(4);
                CanvasFrame.getCanvas().redraw();
            }
        }
    }
}