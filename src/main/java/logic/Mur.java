package logic;

import data.Data;

public interface Mur {
    /**
     * @param mur : le numero du mur (1 pour le premier, 2 pour le 2eme ...)
     * @return : list de 2 int avec la position en x puis la pisition en y du mur dans la grille
     */
    int[] positionDepart(int mur, Data donnes);

     /**
     * @return : la position des murs
     */
    int[] getPosition();
}
