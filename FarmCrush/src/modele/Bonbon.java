package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ca716144-55b1-46f7-ac56-56f197c56bcd")
public abstract class Bonbon {
    @objid ("1d81d032-738c-4d3e-9891-46b299b530dc")
    private int conditionNbLigne;

    @objid ("a1afeef5-dedc-4dd8-9a79-6b1016609fba")
    private int conditionNbColonne;

    @objid ("9b819b9b-8c74-40a2-b061-7cfee340a738")
    private Couleur couleur;

    @objid ("def28c11-7f92-4d24-a092-c496f8cb3e97")
    public Historique historique;

    @objid ("c10cce21-b1ed-40b1-a8b2-cb354eb87655")
    public void getCouleur() {
    }

    @objid ("b5de7ec2-ffee-47b8-9a52-86bf655a8eb8")
    public abstract static int getValeur();

    @objid ("0bd14fd1-9758-41d5-bc98-b35096ed2cc6")
    public abstract void destruction(final Grille g);

    @objid ("eab5539e-f25f-49f8-9ae0-3fcecb0e4362")
    public abstract void interagir(final Grille g);

    @objid ("4d3ebafc-b22c-4038-b6a6-f2d46e0db893")
    private Couleur choisirCouleurRandom() {
        // TODO Auto-generated return
        return null;
    }

    @objid ("a133bebc-05f1-4395-b9d1-8f11971bf492")
    public int getConditionLigne() {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("bcd588ca-e0e0-4c82-bee0-f1b904deb8cc")
    public int getConditionColonne() {
        // TODO Auto-generated return
        return 0;
    }

}
