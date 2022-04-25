package logic;

import data.Data;

import java.util.ArrayList;

public interface Grille {
    /**
     * @return : liste d'int avec nombre de case en horizontal de la grille comme premier parametre et le nombre de case en vertical de la grille après
     */
    int dimensionGrille(Data donnees);

    /**
     * @return : nombre de mur dans le niveau
     */
    int nombreDeMur(Data donnees);

    /**
     * @return : nombre de Fantome dans le niveau
     */
    int nombreDeFantome(Data donnees);

    /**
     * @return : nombre de Fruit dans le niveau
     */
    int nombreDeFruit(Data donnees);

    /**
     * @param niveau  : int du niveau qu'on veut jouer
     * @param donnees : objet de type data "vide" qui ne contient pas d'information car on le remet a jour dedans
     * @return : Grille contenant les positions des murs, personnages et fruit;
     */
    Grille Initialisation(int niveau, Data donnees);

    /**
     * @param grille : grille de jeux
     * @return : array liste de Fruit
     */
    ArrayList<Fruit> getListeFruit(Grille grille);

    /**
     * @param grille : grille de jeux
     * @return : array list de Mur
     */
    ArrayList<Mur> getListMur(Grille grille);

    /**
     * @param grille: grille de jeux
     * @return : array list de Personnage
     */
    ArrayList<FamtomeImp> getListeFantome(Grille grille);

    /**
     * @param grille: grille de jeux
     * @return : Objet Pacman
     */
    Pacman getPacMan(Grille grille);

    /**
     * @param grille : grille de jeu actuel
     * @param action: un int 0 = pas d'input, 1 = haut, 2 = droite, 3 = bas, 4 = gauche
     * @return : la grille de jeu actialisé
     */
    Grille actualisation(Grille grille, int action);
}
