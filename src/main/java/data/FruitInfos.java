/**
 * 
 */
package data;

/**
 * @author Alexandre
 *
 */
public class FruitInfos implements Fruit {

	/**
	 * La position du fruit sur le plateau de jeu.
	 */
	private int[] position;
	
	/**
	 * Le type du fruit.
	 * @note Peut prendre uniquement les valeurs suivantes :
	 * Cerise ; Fraise ; Orange ; Pomme ; Melon ; Banane .
	 */
	private String type;
	
	/**
	 * Le nombre de points que rapporte le fruit.
	 */
	private int nbPoints;
	
	/**
	 * Cr�er un fruit.
	 * @param position la position du fruit sur le plateau de jeu.
	 * @param type le type du fruit.
	 * @param nbPoints le nombre de points que rapporte le fruit.
	 */
	public FruitInfos(int[] position, String type, int nbPoints) {
		this.position = position;
		this.type = type;
		this.nbPoints = nbPoints;
	}

	public int[] getPosition() {
		return this.position;
	}

	public String getType() {
		return this.type;
	}

	public int getNbPoints() {
		return this.nbPoints;
	}
}
