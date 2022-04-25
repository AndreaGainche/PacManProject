package data;
/**
 * Représente un personnage du jeu : soit un fantôme, soit le PacMan.
 * @author Alexandre
 */
public interface Personnage {

	/**
	 * @return le nom du personnage, soit le nom du fantome, soit le nom "PacMan"
	 */
	public String getNom();
	
	/**
	 * @return la position du personnage sous forme d'un tableau contenant 2 entiers (coordonnées x et y).
	 */
	public int[] getPosition();
	
	/**
	 * @return la vitesse du personnage.
	 */
	public int getVitesse();
	
}
