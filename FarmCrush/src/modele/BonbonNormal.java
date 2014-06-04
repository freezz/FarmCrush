package modele;

/**
 * Définition du Bonbon normal, bonbon standard
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonNormal extends Bonbon {
    public boolean interagir(final Grille g) {
        return false;
    }

    public static int getValeur() {
        return 0;
    }

    public void destruction(final Grille g) {
    }

}
