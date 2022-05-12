package data;
/**
 * Couche Data pour l'acces aux donnees du jeu.
 * @author Alexandre
 */
public interface Data {

	/**
	 * @param niveau le niveau du jeu que l'on souhaite.
	 * @return un objet Data contenant toutes les informations du niveau sp�cifi� en param�tre.
	 */
	public Data getDataImpl(int niveau);
	
	/**
	 * @return la taille du plateau de jeu (qui est un carr�).
	 */
	public int getTaillePlateau();
	
	/**
	 * 
	 * @return l'ensemble des fruits pr�sents sur le plateau de jeu.
	 */
	public Fruit[] getFruits();
	
	/**
	 * @return les positions des murs du plateau de jeu.
	 * @note : Un mur est repr�sent� par une case du plateau de jeu.
	 */
	public int[][] getPosMurs();
	
	/**
	 * @return l'ensemble des personnages sur le plateau de jeu. 
	 */
	public Personnage[] getPersonnages();
	
	/**
	 * @return le nombre d'actualisation par seconde.
	 */
	public int getVitesse();
}
