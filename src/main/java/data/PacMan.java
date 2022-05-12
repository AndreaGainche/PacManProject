/**
 * 
 */
package data;

/**
 * @author Alexandre
 *
 */
public class PacMan implements Personnage {

	private final String nom = "PacMan";
	
	/**
	 * Position par d�faut du PacMan.
	 */
	private int[] position;
	
	/**
	 * Nombre de vies de PacMan.
	 */
	private int nbVies;
	
	/**
	 * Cr�er le personnage PacMan.
	 * @param position sa position par d�faut.
	 * @param nbVies son nombre de vies.
	 */
	public PacMan(int[] position, int nbVies) {
		this.position = position;
		this.nbVies = nbVies;
	}

	public String getNom() {
		return this.nom;
	}

	public int[] getPosition() {
		return this.position;
	}

	public int getNbVies() {
		return this.nbVies;
	}

}
