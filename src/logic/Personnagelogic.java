package logic;

import data.Data;

public interface Personnagelogic {
    /**
     *
     * @param personnage : numero du personnage
     * @return : list d'int avec en premier la position x du personnage et y en 2eme
     */
    int[] positionDepart(int personnage, Data donnes);

    int[] position();
}
