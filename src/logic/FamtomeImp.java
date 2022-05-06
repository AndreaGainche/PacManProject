package logic;

import data.Data;

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
}
