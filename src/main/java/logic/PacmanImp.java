package logic;

import data.Data;

public class PacmanImp extends PersoImp implements Pacman {
    final static int taillePacMan = 25;

    public PacmanImp(Data donnees, int nbrvie) {
        super(vitesseBase);
        this.x = donnees.getPersonnages()[0].getPosition()[0] * 50;
        this.y = donnees.getPersonnages()[0].getPosition()[1] * 50;
        this.hitbox = setHitbox(taillePacMan);
        this.nbrVie = nbrvie;
    }//todo collision fantom

    public FruitImp collisionFruit(GrilleImp grille){
        FruitImp resultat = null;
        switch (this.direction) {
            case haut:
                for (FruitImp m : grille.MyListeFruit) {
                    if (this.hitbox[1] - 10 - this.vitesse < m.hitbox[3] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = m;
                        break;
                    }
                }
            case droite:
                for (FruitImp m : grille.MyListeFruit) {
                    if (this.hitbox[2] + 10 + this.vitesse > m.hitbox[0] && this.hitbox[1] > m.hitbox[1] && this.hitbox[3] < m.hitbox[3]) {
                        resultat = m;
                        break;
                    }
                }
            case bas:
                for (FruitImp m : grille.MyListeFruit) {
                    if (this.hitbox[3] + 10 + this.vitesse > m.hitbox[0] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = m;
                        break;
                    }
                }
            case gauche:
                for (FruitImp m : grille.MyListeFruit) {
                    if (this.hitbox[0] - 10 - this.vitesse < m.hitbox[2] && this.hitbox[1] > m.hitbox[1] && this.hitbox[3] < m.hitbox[3]) {
                        resultat = m;
                        break;
                    }
                }
        }
        this.setHitbox(this.taille); // on recalcule la hitbox a chaque déplacement.
        return resultat;
    }

    public boolean collisionFantome(GrilleImp grille){
        boolean resultat = false;
        switch (this.direction) {
            case haut:
                for (FamtomeImp m : grille.MyListeFantome) {
                    if (this.hitbox[1] - 10 - this.vitesse < m.hitbox[3] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = true;
                        break;
                    }
                }
            case droite:
                for (FamtomeImp m : grille.MyListeFantome) {
                    if (this.hitbox[2] + 10 + this.vitesse > m.hitbox[0] && this.hitbox[1] > m.hitbox[1] && this.hitbox[3] < m.hitbox[3]) {
                        resultat = true;
                        break;
                    }
                }
            case bas:
                for (FamtomeImp m : grille.MyListeFantome) {
                    if (this.hitbox[3] + 10 + this.vitesse > m.hitbox[0] && this.hitbox[0] > m.hitbox[0] && this.hitbox[2] < m.hitbox[2]) {
                        resultat = true;
                        break;
                    }
                }
            case gauche:
                for (FamtomeImp m : grille.MyListeFantome) {
                    if (this.hitbox[0] - 10 - this.vitesse < m.hitbox[2] && this.hitbox[1] > m.hitbox[1] && this.hitbox[3] < m.hitbox[3]) {
                        resultat = true;
                        break;
                    }
                }
        }
        this.setHitbox(this.taille); // on recalcule la hitbox a chaque déplacement.
        return resultat;
    }

    /**
     *
     * @param action : action de l'utilisateur pour pacman
     * @param grille : grille de jeu
     * @return : 0 = ça continu normal 1 = game over tout le monde reprend a sa place de départ, 2 = gameover
     */
    public int deplacement(int action, GrilleImp grille){
        if (action != 0){
            this.direction = action;
        }
        if(this.collisionMur(grille)){
            this.vitesse = 0;
        }
        FruitImp fruit = this.collisionFruit(grille);
        if(fruit != null){
            grille.MyListeFruit.remove(fruit);
        }
        if(this.collisionFantome(grille)){
            if(this.nbrVie == 1){
                return 2;
            }else{
                this.nbrVie -=1;
                return 1;
            }
        }
        return 0;

    }
}