/**
 * Couche Data pour l'acces aux donnees du jeu.
 * @author Alexandre
 */
public interface Data {

	/**
	 * @return la taille du plateau de jeu.
	 */
	public int getTaillePlateau();
	
	/**
	 * 
	 * @return l'ensemble des fruits présents sur le plateau de jeu.
	 */
	public Fruit[] getFruits();
	
	/**
	 * Le nombre de murs correspond à la longueur du tableau.
	 * @return les positions des murs du plateau de jeu.
	 */
	public String[] getPosMurs();
	
	/**
	 * @return l'ensemble des personnages sur le plateau de jeu. 
	 */
	public Personnage[] getPersonnages();
	
	/**
	 * @return le nombre d'actualisation par seconde.
	 */
	public double getVitesse();
	
}
