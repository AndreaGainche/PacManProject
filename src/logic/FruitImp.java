package logic;

import data.*;

public class FruitImp extends MySuperBaseClass implements Fruit {
    final static int tailleFruit = 7;
    int x, y;
    int[] hitbox;
    String nom;

    public FruitImp(int fruit, Data donnes) {
        this.x = positionIni(donnes)[fruit][0];
        this.y = positionIni(donnes)[fruit][1];
        this.nom = gettype(fruit, donnes);
        this.hitbox = setHitbox(tailleFruit);
    }

    public int[][] positionIni(Data donnes) {
        data.Fruit[] tab = (data.Fruit[]) donnes.getFruits();
        int[][] tabfinal = new int[tab.length][2];
        for (int i = 0; i < tab.length; i++) {
            tabfinal[i] = tab[i].getPosition();
        }
        return tabfinal;
    }

    public String gettype (int fruit, Data donnes){
        data.Fruit[] tab = (data.Fruit[]) donnes.getFruits();
        return tab[fruit].getType();
    }

    @Override
    public int[] position(Data donnee) {
        return new int[]{this.x, this.y};
    }

    public String getType(){
        return this.nom;
    }

    public int[] setHitbox(int taille) { //TODO definition relative ou actualisation ?
        return new int[]{this.x, this.y, (this.x + taille), (this.y + taille)};
    }
}
