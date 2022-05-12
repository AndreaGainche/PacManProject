package view;

import java.util.ArrayList;
import java.awt.*;

/**
 * Create shapes and display them
 *
 * @author Nassim Hmamouche
 */
public class Grille {
    private logic.Grille grille;
    private Pacman pacmanGraph;
    private ArrayList<logic.Fantome> listeFantomes;
    private ArrayList<logic.Fruit> listeFruits;
    private ArrayList<logic.Mur> listeMurs;

    /**
     * Create a new picture with a sun, a person and a house.
     */
    public Grille(logic.Grille grille){
        this.grille = grille;
        pacmanGraph = new Pacman(grille.getPacMan());

        listeFantomes = grille.getListeFantome();
        listeFruits = grille.getListeFruit();
        listeMurs = grille.getListMur();
    }

    /** 
     * Draws all the shapes
     */
    public void draw(){
        pacmanGraph.draw();

        for(logic.Fantome fantome : listeFantomes){
            Fantome fantomeGraph = new Fantome(fantome);
            fantomeGraph.draw();
        }
        for(logic.Fruit fruit : listeFruits){
            Fruit fruitGraph = new Fruit(fruit);
            fruitGraph.draw();
        }
        for(logic.Mur mur : listeMurs){
            Mur murGraph = new Mur(mur);
            murGraph.draw();
        }
    }

    /**
     * Returns the action required by user to logic package
     * 
     * @param action 0: space, 1: up, 2: right, 3: down, 4: left
     * @return the logic grid
     */
    public logic.Grille actualisation(int action){
        return grille.actualisation(action);
    }
}