package view;

import logic.GrilleImp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.io.File;

/**
 * Create shapes and display them
 *
 * @author Nassim Hmamouche
 */
public class PacmanPicture {
    private Grille grille;
    private ImageFigure logo;

    /**
     * Create a new picture with grid.
     */
    public PacmanPicture(logic.Grille grilleLogic){
        grille = new Grille(grilleLogic);
        logo = new ImageFigure(150, 28, 175, grilleLogic.dimensionGrille()+20, "assets"+File.separator+"logo.png");
    }

    /**
     * Main method : creates a picture, displays walls and characters and animates them
     */
    public static void main(String args[]){
        PacmanPicture jeu = new PacmanPicture(new GrilleImp(0, new Data(), 3));
        jeu.draw();
        jeu.animate();
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