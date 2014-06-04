package modele;

/**
 * Définition du Bonbon emballé
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonEmballe extends Bonbon {
    public static int getValeur() {
        return 0;
    }

    public void destruction(final Grille g) {
    }

    public boolean interagir(final Grille g) {
        return false;
    }

}
