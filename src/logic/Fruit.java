package logic;

public interface Fruit {
    /**
     * @param fruit : le numero du fruit (1 pour le premier fruit, 2 pour le 2eme ...)
     * @return : list d'int avec en premier la position x du personnage et y en 2eme
     */
    int[] positionDepart(int fruit);
}
