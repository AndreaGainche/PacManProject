package logic;

import data.Data;

/**
 * classe qui implemente le fuit
 */

public class FruitImp implements Fruit {
    final static int tailleFruit = 7;
    int x, y;
    int[] hitbox;
    String nom;

    /**
     * constructeur
     * @param fruit : type de fruit
     * @param donnes : données d'ou on tir les informations
     */
    public FruitImp(int fruit, Data donnes) {
        this.x = positionIni(donnes)[fruit][0] *50;
        this.y = positionIni(donnes)[fruit][1]*50;
        this.nom = gettype(fruit, donnes);
        this.hitbox = setHitbox(tailleFruit);
    }

    /**
     *
     * @param donnes : données d'ou on tir les information
     * @return : la position initial des fruits
     */

    public int[][] positionIni(Data donnes) {
        data.Fruit[] tab = donnes.getFruits();
        int[][] tabfinal = new int[tab.length][2];
        for (int i = 0; i < tab.length; i++) {
            tabfinal[i] = tab[i].getPosition();
        }
        return tabfinal;
    }

    /**
     *
     * @param fruit : le numero du fruit
     * @param donnes : objet data d'ou on tir les donnees
     * @return : retourne le nom du fruit
     */

    public String gettype(int fruit, Data donnes) {
        data.Fruit[] tab = donnes.getFruits();
        return tab[fruit].getType();
    }

    /**
     *
     * @return : retourne la position du fruit
     */

    @Override
    public int[] position() {
        return new int[]{this.x, this.y};
    }

    /**
     *
     * @return : retourne le nopm du fruit
     */

    public String getType() {
        return this.nom;
    }

    /**
     *
     * @param taille : taille du fruit
     * @return : retoun une liste avec la hit box que l'on veux
     */

    public int[] setHitbox(int taille) { //TODO definition relative ou actualisation ?
        return new int[]{this.x, this.y, (this.x + taille), (this.y + taille)};
    }
}
