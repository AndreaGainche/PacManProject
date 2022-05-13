package view;

import java.util.ArrayList;
import java.awt.*;
import logic.*;

/**
 * Create shapes and display them
 *
 * @author Nassim Hmamouche
 */
public class GrilleFigure {
    private PacmanFigure pacmanGraph;
    private ArrayList<Fantome> listeFantomes;
    private ArrayList<Fruit> listeFruits;
    private ArrayList<Mur> listeMurs;
    private Grille grilleLogic;

    /**
     * Create a new picture with a sun, a person and a house.
     */
    public GrilleFigure(Grille grilleLogic){
        this.grilleLogic = grilleLogic;

        pacmanGraph = new PacmanFigure(grilleLogic.getPacMan());

        listeFantomes = grilleLogic.getListeFantome();
        listeFruits = grilleLogic.getListeFruit();
        listeMurs = grilleLogic.getListMur();
    }

    /** 
     * Draws all the shapes
     */
    public void draw(){
        pacmanGraph.draw();

        for(Fantome fantome : listeFantomes){
            //System.out.println(fantome.position()[0] + "   " + fantome.position()[1]);
            FantomeFigure fantomeGraph = new FantomeFigure(fantome);
            fantomeGraph.draw();
        }
        for(Fruit fruit : listeFruits){
            FruitFigure fruitGraph = new FruitFigure(fruit);
            fruitGraph.draw();
        }
        for(Mur mur : listeMurs){
            MurFigure murGraph = new MurFigure(mur);
            murGraph.draw();
        }
    }

    /**
     * Returns the action required by user to logic package
     * 
     * @param action 0: space, 1: up, 2: right, 3: down, 4: left
     * @return the logic grid
     */
    public Grille actualisation(int action){
        System.out.println("pos " + grilleLogic.getPacMan().position()[0] + " " + grilleLogic.getPacMan().position()[1]);
        return grilleLogic.actualisation(action);
    }
}