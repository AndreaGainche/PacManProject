/**
 * 
 */
package data;

/**
 * @author Alexandre
 *
 */
public class Fantome implements Personnage {
	
	/**
	 * Le nom du fant�me.
	 * @note Le nom peut prendre uniquement les valeurs suivantes : Blinky ; Pinky ; Inky ; Clyde
	 */
	private String nom;
	
	/**
	 * La position du fant�me.
	 */
	private int[] position;
	
	/**
	 * Le nombre de vies d'un fant�me.
	 * @note Est d�finit � 1 et ne peut �tre chang�.
	 */
	private final int nbVies = 1;

	/**
	 * Cr�er un fant�me.
	 * @param nom le nom du fant�me.
	 * @param position la position du fant�me par d�faut.
	 */
	public Fantome(String nom) {
		this.nom = nom;
		
		// On consid�re que par d�faut les fant�mes apparaissent
		// en haut � gauche du plateau de jeu (premi�re case) :
		this.position = new int[] {0,0};
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
