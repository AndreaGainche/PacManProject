package logic;

import java.util.*;

import data.*;

public class GrilleImp implements Grille {
    ArrayList<FruitImp> MyListeFruit;
    ArrayList<MurImp> MyListeMur;
    ArrayList<FamtomeImp> MyListeFantome;
    PacmanImp pacman;
    Data donnees;
    int niveau;

    //todo point (score)
    public GrilleImp(int niveau, Data donnees, int nbrViePacman) {
        this.niveau = niveau;
        this.donnees = donnees.getDataImpl(niveau);
        this.MyListeFruit = new ArrayList<>(nombreDeFruit());
        this.MyListeMur = new ArrayList<>(nombreDeMur());
        this.MyListeFantome = new ArrayList<>(nombreDeFantome());
        this.pacman = new PacmanImp(donnees, nbrViePacman);

        remplissageFantome();
        remplissageMur();
        remplissageFruit();
    }

    @Override
    public int dimensionGrille() {
        return this.donnees.getTaillePlateau();
    }

    @Override
    public int nombreDeMur() {
        return (this.donnees.getPosMurs().length);
    }

    @Override
    public int nombreDeFantome() {
        return (this.donnees.getPersonnages().length);
    }

    @Override
    public int nombreDeFruit() {
        return (this.donnees.getFruits().length);
    }

    @Override
    public Grille Initialisation(int niveau, Data donnees) {
        return new GrilleImp(niveau, donnees, 3);
    }

    public void remplissageMur() {
        int nombre = nombreDeMur();
        for (int i = 1; i < nombre; i++) {
            this.MyListeMur.add(new MurImp(i, this.donnees));
        }
    }

    public void remplissageFantome() {
        int nombre = nombreDeFantome();
        for(Personnage f : this.donnees.getPersonnages()){
            System.out.println(f.getPosition()[0] + "   " + f.getPosition()[1]);
        }
        for (int i = 1; i < nombre; i++) {
            this.MyListeFantome.add(new FamtomeImp(i, this.donnees, this.donnees.getPersonnages()[i].getNom()));
        }
    }

    public void remplissageFruit() {
        int nombre = nombreDeFruit();
        //System.out.println(nombre);
        for (int i = 0; i < nombre; i++) {
            this.MyListeFruit.add(new FruitImp(i, this.donnees));
        }
    }

    public GrilleImp Initialisation2(int niveau, int nbrViePacman) {
        return new GrilleImp(niveau, this.donnees, nbrViePacman);
    }

    public ArrayList<Fruit> changementFruit(ArrayList<FruitImp> liste) {
        assert false;
        return new ArrayList<Fruit>(liste);
    }

    public ArrayList<Mur> changementMur(ArrayList<MurImp> liste) {
        return new ArrayList<Mur>(liste);
    }

    public ArrayList<Fantome> changementFantome(ArrayList<FamtomeImp> liste) {
        return new ArrayList<Fantome> (liste);
    }

    @Override
    public ArrayList<Fruit> getListeFruit() {
        return changementFruit(this.MyListeFruit);
    }

    @Override
    public ArrayList<Mur> getListMur() {
        return changementMur(this.MyListeMur);
    }

    @Override
    public ArrayList<Fantome> getListeFantome() {
        return changementFantome(this.MyListeFantome);
    }

    public ArrayList<FamtomeImp> getListeFantomeInterne() {
        return this.MyListeFantome;
    }

    @Override
    public Pacman getPacMan() {
        return this.pacman;
    }

    @Override
    public Grille actualisation(int action) {
        Grille grille = this;
        for (FamtomeImp f : this.getListeFantomeInterne()) {
            f.avance(this);
        }
        int infopacman = this.pacman.deplacement(action, this);
        if (infopacman == 1) {
            grille = Initialisation2(this.niveau, this.pacman.getNombreDeVie());
        } else if (infopacman == 2) {
            return null;
        }
        return grille;
    }
}