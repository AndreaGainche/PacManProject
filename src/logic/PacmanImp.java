package logic;

import data.Data;

public class PacmanImp extends PersoImp implements Pacman {
    final static int taillePacMan = 30;

    public PacmanImp(Data donnees) {
        super(vitesseBase);
        this.x = donnees.getTaillePlateau() / 2;
        this.y = donnees.getTaillePlateau() / 2;
        this.hitbox = setHitbox(taillePacMan);
    }//todo collision mur, collision fuit, collision fantom. attention a l'input entrée par l'utilisateur
}