package modele;

/**
 * Définition du Bonbon emballé
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonEmballe extends Bonbon {
	public void destruction(Grille g) {
    }

    public boolean interagir(Bonbon b, Grille g) {
    	boolean res;
		if(b instanceof BonbonNormal){
			res = b.interagir((BonbonNormal) b, g);
		}
		else if(b instanceof BonbonRaye){
			res = b.interagir((BonbonRaye) b, g);
		}
		else if (b instanceof BonbonEmballe){
			res = b.interagir((BonbonEmballe) b, g);
		}
		else {
			res = false;
		}
        return res;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
        return true;
    }
    
    public boolean interagir(BonbonRaye b, Grille g) {
        return true;
    }
    
    public boolean interagir(BonbonEmballe b, Grille g) {
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
