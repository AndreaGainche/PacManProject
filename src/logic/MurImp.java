package logic;

import data.Data;

public class MurImp extends MySuperBaseClass implements Mur {
    final static int tailleMur = 50;
    int[] hitbox;
    int x, y;

    public MurImp(int mur, Data donnes) {
        int[] pos = this.positionDepart(mur, donnes);
        this.x = pos[0];
        this.y = pos[1];
        this.hitbox = setHitbox(tailleMur);
    }

    @Override
    public int[] positionDepart(int mur, Data donnes) {
        return donnes.getPosMurs()[mur];
    }

    public int[] setHitbox(int taille) { //TODO definition relative ou actualisation ?
        return new int[]{this.x, this.y, (this.x + taille), (this.y + taille)};
    }

    public int[] getHitbox() {
        return hitbox;
    }
}
