package logic;

public interface Personnage {
    /**
     *
     * @param personnage : numero du personnage (0 pacman, 1 le premier fantome, 2 le 2eme fantome...)
     * @return : list d'int avec en premier la position x du personnage et y en 2eme
     */
    int[] positionDepart(int personnage);

}
