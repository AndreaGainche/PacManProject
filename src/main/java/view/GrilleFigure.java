package view;

import java.util.ArrayList;

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
    public GrilleFigure(Grille grilleLogic) {
        this.grilleLogic = grilleLogic;

        pacmanGraph = new PacmanFigure(grilleLogic.getPacMan());

        listeFantomes = grilleLogic.getListeFantome();
        listeFruits = grilleLogic.getListeFruit();
        listeMurs = grilleLogic.getListMur();
    }

    /**
     * Draws all the shapes
     */
    public void draw() {
        pacmanGraph.draw();

        for (Fantome fantome : listeFantomes) {
            FantomeFigure fantomeGraph = new FantomeFigure(fantome);
            fantomeGraph.draw();
        }
        for (Fruit fruit : listeFruits) {
            FruitFigure fruitGraph = new FruitFigure(fruit);
            fruitGraph.draw();
        }
        for (Mur mur : listeMurs) {
            MurFigure murGraph = new MurFigure(mur);
            murGraph.draw();
        }
    }

    /**
     * Returns the action required by user to logic package
     *
     * @param action 0: space, 1: left, 2: down, 3: right, 4: up
     */
    public void actualisation(int action) {
<<<<<<< HEAD
=======
        System.out.println("PacMan pos " + grilleLogic.getPacMan().position()[0] + " " + grilleLogic.getPacMan().position()[1]);
        for(Fantome f : grilleLogic.getListeFantome()){
            System.out.println("Fantome " + f.getType() + "  pos " + f.position()[0] + " " + f.position()[1]);
        }
>>>>>>> d7758942d85bea1921238afbf583309dd30ff4dc
        grilleLogic.actualisation(action);
        pacmanGraph.deplace();
        for (Fantome fantome : listeFantomes) {
            FantomeFigure fantomeGraph = new FantomeFigure(fantome);
            fantomeGraph.deplace();
        }
    }
}