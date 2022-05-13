import data.Data;
import data.DataNiveauDeJeu;
import logic.Grille;
import logic.GrilleImp;

public class main {
    public static void main(String[] args) {
        Data data = new DataNiveauDeJeu();
        Grille grille = new GrilleImp(1, data, 3);
    }
}
