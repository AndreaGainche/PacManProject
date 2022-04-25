package logic;

import data.Data;
import java.util.concurrent.ThreadLocalRandom;

public class FamtomeImp extends PersoImp {
    final static int tailleFantome = 30;

    public FamtomeImp(int personnage, Data donnes) {
        super(vitesseBase);
        this.x = positionDepart(personnage, donnes)[0];
        this.y = positionDepart(personnage, donnes)[1];
        this.hitbox = setHitbox(tailleFantome);
        this.taille = tailleFantome;
    }

    public void avance(GrilleImp grille) {
        switch (this.direction) {
            case haut:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1,4+1);
                    avance(grille);
                }else {
                    this.y -= this.vitesse;
                }
                break;
            case droite:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1,4+1);
                    avance(grille);
                }else{
                    this.x += this.vitesse;
                }
                break;

            case bas:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1,4+1);
                    avance(grille);
                }else{
                    this.y += this.vitesse;
                }
                break;
            case gauche:
                if (collisionMur(grille)) {
                    this.direction = ThreadLocalRandom.current().nextInt(1,4+1);
                    avance(grille);
                }else{
                    this.x -= this.vitesse;
                }
                break;
        }
    }

}
