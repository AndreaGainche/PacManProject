package logic;

import data.Data;

public class MurImp implements Mur {
    final static int tailleMur = 50;
    int[] hitbox;
    int x, y;

    /**
     *
     * @param mur : numero du mur
     * @param donnes : objet de type data d'ou on tir les informations
     */

    public MurImp(int mur, Data donnes) {
        int[] pos = this.positionDepart(mur, donnes);
        this.x = pos[0] * 50;
        this.y = pos[1] * 50;
        this.hitbox = setHitbox(tailleMur);
    }

    /**
     *
     * @param mur : le numero du mur (1 pour le premier, 2 pour le 2eme ...)
     * @param donnes : objet de type data d'ou on tir les informations
     * @return les positions de depart de chaque mur
     */

    @Override
    public int[] positionDepart(int mur, Data donnes) {
        return donnes.getPosMurs()[mur];
    }

    /**
     *
     * @return la position actuel du mur
     */

    @Override
    public int[] getPosition() {
        return new int[]{this.x, this.y};
    }

    /**
     *
     * @param taille : la taille du mur
     * @return : liste qui syntetise la hitbox
     */

    public int[] setHitbox(int taille) { //TODO definition relative ou actualisation ?
        return new int[]{this.x, this.y, (this.x + taille), (this.y + taille)};
    }
}
