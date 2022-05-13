package logic;

import data.Data;

public class PacmanImp extends PersoImp implements Pacman {
    final static int taillePacMan = 25;
    int buffer;

    /**
     *
     * @param donnees : objet de type data d'ou on tir les informations
     * @param nbrvie : nombre de vie de pacman
     */

    public PacmanImp(Data donnees, int nbrvie) {
        super(vitesseBase);
        this.x = donnees.getPersonnages()[0].getPosition()[0] * 50;
        this.y = donnees.getPersonnages()[0].getPosition()[1] * 50;
        this.hitbox = setHitbox(taillePacMan);
        this.nbrVie = nbrvie;
    }

    /**
     *
     * @param grille : grille actuel de jeu
     * @return un booleen qui determine si true il y a ue collision et false il n'y a pas de collision
     */

    public FruitImp collisionFruit(GrilleImp grille) {
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

    /**
     *
     * @param grille :grille actuel de jeu
     * @return un booleen qui determine si true il y a ue collision et false il n'y a pas de collision
     */

    public boolean collisionFantome(GrilleImp grille) {
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
     * @param action : action de l'utilisateur pour pacman
     * @param grille : grille de jeu
     * @return : 0 = ça continu normal 1 = game over tout le monde reprend a sa place de départ, 2 = gameover
     */

    public int deplacement(int action, GrilleImp grille) {
        boolean effetAction = this.collisionMur(grille, action);
        boolean effetDirection = this.collisionMur(grille, this.direction);
        if (effetAction && this.direction != 0) { // on regarde si la direction de l'input nous emmene dans un mur
            this.buffer = action;
        } else if (!effetAction && action != 0) { //pacman vers l'action si pas de mur
            this.direction = action;
            this.mouvement(this.direction);
        } else if (!effetDirection && this.direction != 0) { // pas de collision mur && pas a l'arret
            this.mouvement(this.direction);
        } else if (effetDirection && buffer != 0 && !this.collisionMur(grille, this.buffer)) {//pacman vers un mur mais buffer pas contre mur
            this.direction = this.buffer;
            this.buffer = 0;
            this.mouvement(this.direction);
        } else if (effetDirection && buffer != 0 && this.collisionMur(grille, this.buffer)) {//pacman vers un mur et buffer vers un mur
            this.buffer = 0;
        }

        FruitImp fruit = this.collisionFruit(grille); // si pacman touche un fruit on l'enleve
        if (fruit != null) {
            grille.MyListeFruit.remove(fruit);
        }

        if (this.collisionFantome(grille)) { // si pacman touche un fantome il meure et on regarde ses vies
            if (this.nbrVie == 1) {
                return 2;
            } else {
                this.nbrVie -= 1;
                return 1;
            }
        }

        return 0;
    }

    /**
     *
     * @param direct : sens de mouvmenet de pacman
     */

    public void mouvement(int direct) {
        final int haut = 1, droite = 2, bas = 3, gauche = 4;
        switch (direct) {
            case haut:
                this.x -= vitesse;
                break;
            case droite:
                this.y += vitesse;
                break;
            case bas:
                this.x += vitesse;
            case gauche:
                this.y -= vitesse;
        }
    }
}