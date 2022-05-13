package data;

import java.io.File;



import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Alexandre
 *
 */
public class DataNiveauDeJeu implements Data {

	/**
	 * Tableau contenant tous les personnages du jeu.
	 */
	private Personnage[] tabPersos;
	
	/**
	 * La taille du plateau.
	 * @note Le plateau est un carr�.
	 */
	private int taillePlateau;
	
	/**
	 * Tableau contenant tous les fruits du jeu.
	 */
	private Fruit[] tabFruits;
	
	/**
	 * Tableau contenant les positions de tous les murs du jeu.
	 * @note La position d'un mur est repr�sent�e par un tableau d'entiers de taille 2 (coordonn�es x et y).
	 */
	private int[][] tabMurs;
	
	/**
	 * Vitesse du jeu (nombre d'actualisations par secondes).
	 */
	private int vitesse;
	
	public Data getDataImpl(int niveau) {

		String fileTitle = "niveau" + niveau + ".json";

		try {
			URL url = getClass().getResource(fileTitle);
			
			// On cr�er un fichier avec l'url du fichier json correspondant au niveau souhait�.
			File file = new File(url.getPath());
			//File file = new File("D:\\Cours\\Semestre 6\\java\\PacManProject\\target\\classes\\data\\niveau1.json");
			return new DataNiveauDeJeu(file);
		}
		catch(NullPointerException e) {
			System.out.println("Error : File not found.");
			return new DataNiveauDeJeu();
		}
	}
	
	/**
	 * Constructeur vide servant � utiliser la m�thode getDataImpl dans la version finale du projet.
	 */
	public DataNiveauDeJeu() {}
	
	/**
	 * Cr�er les objets contenant toutes les informations du jeu pour le niveau donn� � partir d'un fichier json.
	 * @param file le fichier du niveau de jeu.
	 */
	public DataNiveauDeJeu(File file) {
			
		// On initialise le tableau contenant les personnages comme un tableau vide de taille 5 (car
		// on sait qu'il y aura tout le temps 1 seul PacMan et 4 fant�mes).
		this.tabPersos = new Personnage[5];
		
		try {
			
			/* On transforme le fichier json en HashMap :
			 * 
			 * Chaque cl� de la HashMap sera est un String.
			 * Les cl�s ne peuvent prendre que les valeurs suivantes (indiquant l'information de leur valeur) :
			 * 
			 * Les valeurs de la HashMap seront prises du fichier json en tant que String.
			 * Elles peuvent parfois contenir des s�parateurs.
			 * 
			 * Exemple :
			 * 
			 * Key = "Fruits_position" et Valeur =  "0,0_8,6"
			 * La valeur contient les positions de tous les fruits (regroup�s par 2 pour les coordonn�es x et y).
			 * Le s�parateur ',' indique la s�paration entre la coordonn�e x et la coordonn�e y.
			 * Le s�parateur '_' indique la s�paration entre 2 couples de coordonn�es.
			 * 
			*/
			Map<String, String> mapping = new ObjectMapper().readValue(file, HashMap.class);
			
			
			// On parcourt les cl�s de la HashMap et on cr�er les objets correspondants :
			for(Map.Entry<String, String> entry : mapping.entrySet()) {

				// On charge le cl� et la valeur de chaque Entry :
			    String key = entry.getKey();
			    String value = entry.getValue();
							    
				switch(key) {
				
				case "PacMan_nbVies_position" :
					String[] temp1 = value.split("_"); // temp1 = {"nbVies", "x,y"}
					String[] temp2 = temp1[1].split(",");
					
					this.tabPersos[0] = new PacMan(new int[] {Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1])}, Integer.parseInt(temp1[0]));
					break;
					
				case "Fantomes_nom" :
					// value = Blinky,Pinky,Inky,Clyde
					String[] nomsFantome = value.split(",");
					for(int i=1;i<this.tabPersos.length;i++) {
						this.tabPersos[i] = new Fantome(nomsFantome[i-1]);
					}
					break;
					
				case "TaillePlateau" :
					this.taillePlateau = Integer.parseInt(value);
					break;
					
				case "Fruits_position_type_points" :

					// On cr�er des tableaux de String temporaire pour s�parer la String originelle :
					String[] fruitsTemp = value.split("::"); // fruitsTemp = {"x1,y1_x2,y2_..._xn,yn", "Cerise,...,Fraise", "100,...,300"}

					String[] fruitsPositionTemp = fruitsTemp[0].split("_");
					String[] fruitsTypeTemp = fruitsTemp[1].split(",");
					String[] fruitsPointsTemp = fruitsTemp[2].split(",");

					this.tabFruits = new Fruit[fruitsTypeTemp.length];
					
					// On cr�er tous les fruits et on les ajoute au tableau :
					for(int i=0; i<fruitsTypeTemp.length; i++) {
						String[] fruitsPositionTemp2 = fruitsPositionTemp[i].split(","); // Tableau contenant les 2 coordonn�es x et y du fruit de l'it�ration.
						this.tabFruits[i] = new FruitInfos(new int[] {Integer.parseInt(fruitsPositionTemp2[0]), Integer.parseInt(fruitsPositionTemp2[1])}, fruitsTypeTemp[i], Integer.parseInt(fruitsPointsTemp[i]));
					}
					break;
					
				case "Murs_position" :
					
					// On cr�er un tableau de String temporaire pour s�parer la String originelle afin d'obtenir la position de chaque mur :
					String[] mursTemp = value.split("_");
					
					this.tabMurs = new int[mursTemp.length][2];
					
					// On cr�er un tableau contenant la position de chaque mur et on l'ajoute au tableau principal :
					for(int i=0; i<mursTemp.length; i++) {
						String[] mursTemp2 = mursTemp[i].split(",");
						this.tabMurs[i] = new int[] {Integer.parseInt(mursTemp2[0]), Integer.parseInt(mursTemp2[1])};
					}
					
					break;
					
				case "Vitesse_jeu" :
					
					this.vitesse = Integer.parseInt(value);
					
					break;
					
				default :
					break;
				}
				
			}
		}
		
		catch (JsonParseException e) {
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getTaillePlateau() {
		return this.taillePlateau;
	}

	public Fruit[] getFruits() {
		return this.tabFruits;
	}

	public int[][] getPosMurs() {
		return this.tabMurs;
	}

	public Personnage[] getPersonnages() {
		return this.tabPersos;
	}

	public int getVitesse() {
		return this.vitesse;
	}
}
