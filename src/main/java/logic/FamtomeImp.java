package logic;

import data.Data;
import data.DataNiveauDeJeu;
import data.Fruit;
import data.Personnage;

import java.util.concurrent.ThreadLocalRandom;

public class FamtomeImp extends PersoImp implements Fantome {
    final static int tailleFantome = 25;
    String nom;

    public FamtomeImp(int personnage, Data donnes, String nom) {
        super(vitesseBase);
        this.x = positionDepart(personnage, donnes)[0];
        this.y = positionDepart(personnage, donnes)[1];
        this.hitbox = setHitbox(tailleFantome);
        this.taille = tailleFantome;
        this.nom = nom;
    }

    public void avance(GrilleImp grille) { // todo attention ça repart en arrière
        switch (this.direction) {
            case haut:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                    avance(grille);
                } else {
                    this.y -= this.vitesse;
                }
                break;
            case droite:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                    avance(grille);
                } else {
                    this.x += this.vitesse;
                }
                break;

            case bas:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                    avance(grille);
                } else {
                    this.y += this.vitesse;
                }
                break;
            case gauche:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                    avance(grille);
                } else {
                    this.x -= this.vitesse;
                }
                break;
        }
    }

    @Override
    public String getType() {
        return this.nom;
    }

    /**
     * Test si notre classe DataNiveauDeJeu retourne les bonnes valeurs pour le fichier correspondant au niveau 1.
     * @author Alexandre
     *
     */
    public static class Test_Data {

        public static void main(String[] args) {

            Data testData = new DataNiveauDeJeu();
            Data infosData = testData.getDataImpl(1);

            System.out.println("La taille du plateau de jeu est : " + infosData.getTaillePlateau() + "\n");

            System.out.println("Les fruits du jeu sont :");
            data.Fruit[] tabFruits = infosData.getFruits();
            for(Fruit f : tabFruits) {
                System.out.print("type = " + f.getType());
                System.out.print(" | position = " + f.getPosition()[0] + "," + f.getPosition()[1]);
                System.out.println(" | nombre de points = " + f.getNbPoints());
            }

            System.out.println("\nLes positions des murs sont :");
            int[][] murs = infosData.getPosMurs();
            for(int[] t : murs) {
                System.out.print("(" + t[0] + "," + t[1] + ") ");
            }

            System.out.println("\n \nLes personnages du jeu sont :");
            Personnage[] persos = infosData.getPersonnages();
            for(Personnage p : persos) {
                System.out.print("nom = " + p.getNom());
                System.out.print(" | position = (" + p.getPosition()[0] + "," + p.getPosition()[1] + ")");
                System.out.println(" | nombre de vies = " + p.getNbVies());
            }

            System.out.println("\nLa vitesse du jeu est : " + infosData.getVitesse());
        }

    }
}
