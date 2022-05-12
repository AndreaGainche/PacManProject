package data;
/**
 * Repr�sente un personnage du jeu : soit un fant�me, soit le PacMan.
 * @author Alexandre
 */
public interface Personnage {

	/**
	 * @return le nom du personnage, soit le nom du fantome, soit le nom "PacMan"
	 */
	public String getNom();
	
	/**
	 * @return la position du personnage sous forme d'un tableau contenant 2 entiers (coordonn�es x et y).
	 */
	public int[] getPosition();
	
	/**
	 * @return le nombre de vies du personnage.
	 * (On considere que PacMan peut avoir plusieurs vies et que les fant�mes en ont 1).
	 */
	public int getNbVies();
	
}
