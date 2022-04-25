package logic;

import java.util.*;

import data.*;

//TODO interface avec view gestion au niveau+1 en fct de l'input
public class GrilleImp implements Grille {
    List<FruitImp> MyListeFruit;
    List<MurImp> MyListeMur;
    List<FamtomeImp> MyListeFantome;
    Pacman pacman;
    Data donnees;

    public GrilleImp(int niveau, Data donnees) {
        this.donnees = donnees.getDataImpl(niveau);
        this.MyListeFruit = new ArrayList<>(nombreDeFruit(this.donnees));
        this.MyListeMur = new ArrayList<>(nombreDeMur(this.donnees));
        this.MyListeFantome = new ArrayList<>(nombreDeFantome(this.donnees));
        this.pacman = new PacmanImp(donnees);
        remplissageFruit(donnees);
        remplissageMur();
        remplissageFruit(donnees);
    }

    @Override
    public int dimensionGrille(Data donnees) {
        return donnees.getTaillePlateau();
    }

    @Override
    public int nombreDeMur(Data donnees) {
        return (donnees.getPosMurs().length);
    }

    @Override
    public int nombreDeFantome(Data donnees) {
        return (donnees.getPersonnages().length);
    }

    @Override
    public int nombreDeFruit(Data donnees) {
        return (donnees.getFruits().length);
    }

    public void remplissageMur() {
        int nombre = nombreDeMur(this.donnees);
        for (int i = 1; i < nombre; i++) {
            this.MyListeMur.add(new MurImp(i, this.donnees));
        }
    }

    public void remplissageFruit(Data donnees) {
        int nombre = nombreDeFantome(this.donnees);
        for (int i = 1; i < nombre; i++) {
            this.MyListeFantome.add(new FamtomeImp(i, this.donnees));
        }
    }

    public Grille Initialisation(int niveau, Data donnees) {
        return new GrilleImp(niveau, donnees);
    }

    @Override
    public ArrayList<Fruit> getListeFruit(Grille grille) {
        return grille.getListeFruit(grille);
    }

    @Override
    public ArrayList<Mur> getListMur(Grille grille) {
        return grille.getListMur(grille);
    }

    @Override
    public ArrayList<FamtomeImp> getListeFantome(Grille grille) {
        return grille.getListeFantome(grille);
    }

    @Override
    public Pacman getPacMan(Grille grille) {
        return grille.getPacMan(grille);
    }

    @Override
    public Grille actualisation(Grille grille, int action) { //todo déplacment de pacman
        for (FamtomeImp f : grille.getListeFantome(grille)){
            f.avance((GrilleImp) grille); //todo attention
        }

        return grille;
    }
}