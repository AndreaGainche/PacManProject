package logic;

public interface Grille {
    /**
     *
     * @return : liste d'int avec nombre de case en horizontal de la grille comme premier parametre et le nombre de case en vertical de la grille après
     */
    int[] dimensionGrille();

    /**
     *
     * @return : nombre de mur dans le niveau
     */
    int nombreDeMur();
    /**
     *
     * @return : nombre de Fantome dans le niveau
     */
    int nombreDeFantome();

    /**
     *
     * @return : nombre de Fruit dans le niveau
     */
    int nombreDeFruit();
}
