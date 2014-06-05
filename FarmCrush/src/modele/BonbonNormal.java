package modele;

/**
 * Définition du Bonbon normal, bonbon standard
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonNormal extends Bonbon {
	
	public void destruction(Grille g) {
    }

	@Override
    public boolean interagir(Bonbon b, Grille g) {
		boolean res;
		if(b instanceof BonbonNormal){
			res = b.interagir((BonbonNormal) b, g);
		}
		else {
			res = false;
		}
        return res;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
        return true;
    }

	@Override
	public int getValeur() {
		return 0;
	}

	@Override
	public int getConditionLigne() {
		return 0;
	}

	@Override
	public int getConditionColonne() {
		return 0;
	}

}
