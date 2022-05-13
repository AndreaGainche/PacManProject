package logic;

import data.Data;

import java.util.ArrayList;

public interface Grille {
    /**
     * @return : liste d'int avec nombre de case en horizontal de la grille comme premier parametre et le nombre de case en vertical de la grille après
     */
    int dimensionGrille();

    /**
     * @return : nombre de mur dans le niveau
     */
    int nombreDeMur();

    /**
     * @return : nombre de Fantome dans le niveau
     */
    int nombreDeFantome();

    /**
     * @return : nombre de Fruit dans le niveau
     */
    int nombreDeFruit();

    /**
     * @return : array liste de Fruit
     */
    ArrayList<Fruit> getListeFruit();

    /**
     * @return : array list de Mur
     */
    ArrayList<Mur> getListMur();

    /**
     * @return : array list de Personnage
     */
    public ArrayList<Fantome> getListeFantome();

    /**
     * @return : Objet Pacman
     */
    Pacman getPacMan();

    /**
     * @param action: un int 0 = pas d'input, 1 = haut, 2 = droite, 3 = bas, 4 = gauche
     * @return : la grille de jeu actialisé
     */
    Grille actualisation(int action);
}
