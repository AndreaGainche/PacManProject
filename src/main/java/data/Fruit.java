package data;
/**
 * Repr�sente un fruit du jeu.
 * @invariant Le type du fruit peut prendre uniquement les valeurs suivantes : Cerise ; Fraise ; Orange ; Pomme ; Melon ; Banane .
 * @author Alexandre
 */
public interface Fruit {

	/**
	 * @return la position du fruit sous forme d'un tableau contenant 2 entiers (coordonn�es x et y).
	 */
	public int[] getPosition();
	
	/**
	 * @return le type du fruit.
	 */
	public String getType();
	
	/**
	 * @return le nombre de points que rapporte le fruit.
	 */
	public int getNbPoints();
}
