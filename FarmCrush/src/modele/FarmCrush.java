package modele;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("eddbc88d-d4a1-4177-b359-c3fcb0738bc9")
public class FarmCrush {
    @objid ("a38e9223-2912-406b-8171-79520e636a40")
    private int scoreaActuel;

    @objid ("26266a9b-62c6-4a1b-bf9e-35f42baaa283")
    private int nbCoupJouer;

    @objid ("89485065-ac05-4e60-a0dd-5faf857d5cce")
    public Grille grille;

    @objid ("b54c4336-0be9-4fb3-90d6-9ea76e9cdcec")
    public Objectif objectif;

    @objid ("71906a67-c8da-4d21-942c-528e87741740")
    public void jouer(final Coordonnee c1, final Coordonnee c2) {
    }

    @objid ("f347e9f0-93fb-4896-b80b-a393962b1f5a")
    public void initialisationNiveau() {
    }

    @objid ("4b817065-b2a4-4075-bec3-201eaa0a5664")
    public int getScoreActuel() {
        // TODO Auto-generated return
        return 0;
    }

    @objid ("303ad3f7-c6ed-45bf-bd4d-01e0f72fd1f7")
    public int getNbCoupJouer() {
        // TODO Auto-generated return
        return 0;
    }

}
