package logic;

import data.Data;
import data.Personnage;

/**
 * classe mere des 2 types de personnages : pacman et fantomes
 */

public class PersoImp implements Personnagelogic {
    static final int vitesseNull = 0, vitesseBase = 2, vitesseBoost = 4;
    static final int nul = 0, haut = 1, droite = 2, bas = 3, gauche = 4;


    int vitesse, x, y, direction, taille, nbrVie; // direction :0 = null, 1 = haut, 2 = droite, 3 = bas, 4 = gauche
    int[] hitbox;

    /**
     * @param vitesse : vitesse du perso
     */
    public PersoImp(int vitesse) {
        this.vitesse = vitesse;
        this.direction = haut;
    }

    /**
     * @return position actuel du personnage
     */

    @Override
    public int[] position() {
        return new int[]{this.x, this.y};
    }

    /**
     * @return nombre de vie du personnages
     */

    @Override
    public int getNombreDeVie() {
        return this.nbrVie;
    }

    /**
     * @param taille taile du perso
     * @return list de la hitbox du perso
     */

    public int[] setHitbox(int taille) {
        return new int[]{this.x, this.y, (this.x + taille), (this.y + taille)};
    }

    /**
     * @param grille : grille de jeux actuel
     * @param choix  : input de l'utilisateur
     * @return : true si il y a une colision entre le personnage et un mur
     */

    public boolean collisionMur(GrilleImp grille, int choix) {
        boolean resultat = false;
        switch (choix) {
            case haut:
                for (MurImp m : grille.MyListeMur) {
                    if (this.hitbox[1] - 10 - this.vitesse < m.hitbox[3] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = true;
                        break;
                    }
                }
            case droite:
                for (MurImp m : grille.MyListeMur) {//todo modifier +10
                    if (this.hitbox[2] + 10 + this.vitesse > m.hitbox[0] && this.hitbox[1] > m.hitbox[1] && this.hitbox[3] < m.hitbox[3]) {
                        resultat = true;
                        break;
                    }
                }
            case bas:
                for (MurImp m : grille.MyListeMur) {
                    if (this.hitbox[3] + 10 + this.vitesse > m.hitbox[0] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = true;
                        break;
                    }
                }
            case gauche:
                for (MurImp m : grille.MyListeMur) {
                    if (this.hitbox[0] - 10 - this.vitesse < m.hitbox[2] && this.hitbox[1] > m.hitbox[1] && this.hitbox[3] < m.hitbox[3]) {
                        resultat = true;
                        break;
                    }
                }
        }
        this.setHitbox(this.taille); // on recalcule la hitbox a chaque déplacement.
        return resultat;
    }
}