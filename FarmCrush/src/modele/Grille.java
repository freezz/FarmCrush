package modele;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("869bfca2-7370-46ad-abc4-1445a3c2fca4")
public class Grille {
    @objid ("66694cd1-5f49-407e-a4a9-8a1a7fc3e8f5")
    public static int TAILLE_LIGNE_MAX = 9;

    @objid ("3ff9f1df-e5a9-48ed-b42e-a16f0f8ea9cd")
    public static String TAILLE_COLONNE_MAX;

    @objid ("d8475530-d47f-4033-995e-973b28f7f375")
    private int nbColonne;

    @objid ("6f4b13a9-a4ca-436c-8cc4-ba3b9778f727")
    private int nbLigne;

    @objid ("67dcf257-4252-4df1-b31a-0ae1309a37bc")
    public List<Case> cases = new ArrayList<Case> ();

    @objid ("baea0443-71fc-40c6-8a0a-fe3b5b11dfdd")
    public void effectuerGraviter() {
    }

    @objid ("447b0445-0b64-4354-9953-9f60d37aeca4")
    public boolean checkGrille() {
        // TODO Auto-generated return
        return false;
    }

    @objid ("86d05db0-2b9d-4b79-bab8-40218aa8484d")
    public int getNbLigne() {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("44f2e206-7a15-4c81-a3d0-fe634a73db0d")
    public int getNbColonne() {
        // TODO Auto-generated return
        return 0;
    }

}
