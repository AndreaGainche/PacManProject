package logic;

import data.Data;
import data.Personnage;


public class PersoImp extends MySuperBaseClass implements Personnagelogic {
    static final int vitesseNull = 0, vitesseBase = 2, vitesseBoost = 4;
    static final int nul = 0, haut = 1, droite = 2, bas = 3, gauche = 4;


    int vitesse, x, y, direction, taille; // direction :0 = null, 1 = haut, 2 = droite, 3 = bas, 4 = gauche
    int[] hitbox;


    public PersoImp(int vitesse) {
        this.vitesse = vitesse;
        this.direction = haut;
    }

    @Override
    public int[] positionDepart(int personnage, Data donnes) {
        Personnage[] tab = donnes.getPersonnages();
        return tab[personnage].getPosition();
    }

    @Override
    public int[] position() {
        return new int[]{this.x, this.y};
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int[] setHitbox(int taille) {
        return new int[]{this.x, this.y, (this.x + taille), (this.y + taille)};
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean collisionMur(GrilleImp grille) {
        boolean resultat = false;
        switch (this.direction) {
            case haut:
                for (MurImp m : grille.MyListeMur) {
                    if (this.hitbox[1] - 10 - this.vitesse < m.hitbox[3] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = true;
                        break;
                    }
                }
            case droite:
                for (MurImp m : grille.MyListeMur) {
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