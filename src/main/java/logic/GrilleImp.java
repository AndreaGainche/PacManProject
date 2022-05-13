package logic;

import java.util.*;

import data.*;

/**
 * classe qui implemente grille et represente la grille de jeu
 */

public class GrilleImp implements Grille {
    ArrayList<FruitImp> MyListeFruit;
    ArrayList<MurImp> MyListeMur;
    ArrayList<FamtomeImp> MyListeFantome;
    PacmanImp pacman;
    Data donnees;
    int niveau;

    /**
     * constructeur
     *
     * @param niveau       : niveau du jeu
     * @param donnees      : objet data vide
     * @param nbrViePacman : nombre de vie de pacman
     */

    public GrilleImp(int niveau, Data donnees, int nbrViePacman) {
        this.niveau = niveau;
        this.donnees = donnees.getDataImpl(niveau);
        this.MyListeFruit = new ArrayList<>(nombreDeFruit());
        this.MyListeMur = new ArrayList<>(nombreDeMur());
        this.MyListeFantome = new ArrayList<>(nombreDeFantome());
        this.pacman = new PacmanImp(this.donnees, nbrViePacman);

        remplissageFantome();
        remplissageMur();
        remplissageFruit();
    }

    /**
     * @param niveau : niveau de jeu
     * @param donnees : objet data vide
     */

    public GrilleImp(int niveau, Data donnees) {
        this.niveau = niveau;
        this.donnees = donnees.getDataImpl(niveau);
        this.MyListeFruit = new ArrayList<>(nombreDeFruit());
        this.MyListeMur = new ArrayList<>(nombreDeMur());
        this.MyListeFantome = new ArrayList<>(nombreDeFantome());
        this.pacman = new PacmanImp(this.donnees, this.donnees.getPersonnages()[0].getNbVies());

        remplissageFantome();
        remplissageMur();
        remplissageFruit();
    }

    /**
     *
     * @return : taille de du plateau de jeu
     */

    @Override
    public int dimensionGrille() {
        return this.donnees.getTaillePlateau();
    }

    /**
     *
     * @return : return le nombre de nur
     */

    @Override
    public int nombreDeMur() {
        return (this.donnees.getPosMurs().length);
    }

    /**
     *
     * @return : return le nombre de fantome
     */

    @Override
    public int nombreDeFantome() {
        return (this.donnees.getPersonnages().length);
    }

    /**
     *
     * @return : retourne le nombre de fruit
     */

    @Override
    public int nombreDeFruit() {
        return (this.donnees.getFruits().length);
    }

    /**
     * remplis l'arrayList de mur en fonction des données de data
     */

    public void remplissageMur() {
        int nombre = nombreDeMur();
        for (int i = 1; i < nombre; i++) {
            this.MyListeMur.add(new MurImp(i, this.donnees));
        }
    }

    /**
     * remplis l'arrayList de Fantome en fonction des données de data
     */

    public void remplissageFantome() {
        int nombre = nombreDeFantome();
        for (Personnage f : this.donnees.getPersonnages()) {
            System.out.println(f.getPosition()[0] + "   " + f.getPosition()[1]);
        }
        for (int i = 1; i < nombre; i++) {
            this.MyListeFantome.add(new FamtomeImp(i, this.donnees, this.donnees.getPersonnages()[i].getNom()));
        }
    }

    /**
     * remplis l'arrayList de Fruit en fonction des données de data
     */

    public void remplissageFruit() {
        int nombre = nombreDeFruit();
        //System.out.println(nombre);
        for (int i = 0; i < nombre; i++) {
            this.MyListeFruit.add(new FruitImp(i, this.donnees));
        }
    }

    /**
     * cree une grilleImp
     * @param niveau : niveau de jeu actuel
     * @param nbrViePacman : nbr de vie de pacman
     * @return : Une grilleImp avec les nouveaux parametres que l'on veux
     */

    public GrilleImp Initialisation2(int niveau, int nbrViePacman) {
        return new GrilleImp(niveau, this.donnees, nbrViePacman);
    }

    /**
     *
     * @param liste : liste a transformer
     * @return : liste transformer
     */

    public ArrayList<Fruit> changementFruit(ArrayList<FruitImp> liste) {
        assert false;
        return new ArrayList<>(liste);
    }

    /**
     *
     * @param liste : liste a transformer
     * @return : liste transformer
     */

    public ArrayList<Mur> changementMur(ArrayList<MurImp> liste) {
        return new ArrayList<>(liste);
    }

    /**
     *
     * @param liste: liste a transformer
     * @return : liste transformer
     */

    public ArrayList<Fantome> changementFantome(ArrayList<FamtomeImp> liste) {
        return new ArrayList<>(liste);
    }

    /**
     *
     * @return retourn la liste de fruit actuel
     */

    @Override
    public ArrayList<Fruit> getListeFruit() {
        return changementFruit(this.MyListeFruit);
    }

    /**
     *
     * @return retourn la liste de mur actuel
     */

    @Override
    public ArrayList<Mur> getListMur() {
        return changementMur(this.MyListeMur);
    }

    /**
     *
     * @return retourn la liste de fantome actuel
     */

    @Override
    public ArrayList<Fantome> getListeFantome() {
        return changementFantome(this.MyListeFantome);
    }

    /**
     *
     * @return PacMAn actuel
     */

    @Override
    public Pacman getPacMan() {
        return this.pacman;
    }

    /**
     *
     * @param action: un int 0 = pas d'input, 1 = haut, 2 = droite, 3 = bas, 4 = gauche
     * @return : la grille actualiser
     */

    @Override
    public Grille actualisation(int action) {
        for (FamtomeImp f : this.MyListeFantome) {
            f.avance(this);
        }
        int infopacman = this.pacman.deplacement(action, this);
        if (infopacman == 1) {
            return Initialisation2(this.niveau, this.pacman.getNombreDeVie());
        } else if (infopacman == 2) {
            return null;
        }
        //this.pacman.x = this.pacman.x+1;
        return this;
    }
}