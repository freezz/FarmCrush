package vue;
import controleur.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import modele.Bonbon;
import modele.Case;
import modele.Couleur;
import modele.FarmCrush;

public class CrushGUI implements Observer{
	
	/* Ensemble des icons */
	private static final ImageIcon orange = new ImageIcon("img/orange.ico");
    private static final ImageIcon rouge = new ImageIcon("img/rouge.ico");
    private static final ImageIcon vert = new ImageIcon("img/vert.ico");
    private static final ImageIcon bleu = new ImageIcon("img/bleu.ico");
    private static final ImageIcon violet = new ImageIcon("img/violet.ico");
    private static final ImageIcon jaune = new ImageIcon("img/jaune.ico");
    private static final ImageIcon orange_raye = new ImageIcon("img/orange_raye.ico");
    private static final ImageIcon rouge_raye = new ImageIcon("img/rouge_raye.ico");
    private static final ImageIcon vert_raye = new ImageIcon("img/vert_raye.ico");
    private static final ImageIcon bleu_raye = new ImageIcon("img/bleu_raye.ico");
    private static final ImageIcon violet_raye = new ImageIcon("img/violet_raye.ico");
    private static final ImageIcon jaune_raye = new ImageIcon("img/jaune_raye.ico");
    private static final ImageIcon orange_emballe = new ImageIcon("img/orange_emballe.ico");
    private static final ImageIcon rouge_emballe = new ImageIcon("img/rouge_emballe.ico");
    private static final ImageIcon vert_emballe = new ImageIcon("img/vert_emballe.ico");
    private static final ImageIcon bleu_emballe = new ImageIcon("img/bleu_emballe.ico");
    private static final ImageIcon violet_emballe = new ImageIcon("img/violet_emballe.ico");
    private static final ImageIcon jaune_emballe = new ImageIcon("img/jaune_emballe.ico");
    private static final ImageIcon multicolore = new ImageIcon("img/multicolore.ico");

    /** Fenêtre principale */
    private JFrame fenetre;
    
    /** Cases du jeu */
    private JLabel[][] cases;
    
    /** Le modèle - nécessaire pour les controleurs  */
    private FarmCrush modele;
    
    
    /*Labels des objectifs*/
    private JLabel score;
    JProgressBar progressbar;
    
    private JLabel coupsRestants;
    
    private JLabel vertRestant;
    private JLabel rougeRestant;
    private JLabel violetRestant;
    private JLabel bleuRestant;
    private JLabel jauneRestant;
    private JLabel orangeRestant;
    
    private JLabel emballeRestant;
    private JLabel rayeRestant;
    private JLabel multicolorRestant;
    
    /**
     * Construit l'interface graphique
     * @param m modele de l'application
     */
    public CrushGUI(FarmCrush m) {
    	
    	this.modele = m;
    	
    	//Création des cases
    	for (int i = 0 ; i < m.grille.getLigne() ; i++) {
		    for (int j = 0 ; j < m.grille.getColonne() ; j++) {
				cases[i][j] = new JLabel();
				//attribut public interdit...
				cases[i][j].setIcon(contenu2Image(m.grille.getCase(i, j)));
				//GELATINE ??
				//case[i][j].
				
				//cases[i][j].addMouseListener(new ClickLabel());
		    }
		}
    	
    	//ajout des elements de la vue 
    	Container contenu = fenetre.getContentPane();
    	
    	/* Le menu */
		JMenuBar barreMenu = new JMenuBar();
		JMenu menus = new JMenu("Jeu");
		JMenuItem itemNouvellePartie = new JMenuItem("Nouvelle Partie");
		//itemNouvellePartie.addActionListener(new ActionNouvellePartie());
		JMenuItem itemQuitter = new JMenuItem("Quitter");
		//itemQuitter.addActionListener(new ActionQuitter());
		menus.add(itemNouvellePartie);
		menus.add(itemQuitter);
		barreMenu.add(menus);
    	
    	/* La fenetre entiere */
    	JPanel pFenetre = new JPanel(new BorderLayout());
    	
    	/* Les objectifs */
    	JPanel pObjectifs = new JPanel(new FlowLayout());
    	// Ensemble des objectifs //
    	JLabel lScore = new JLabel("Score :");
    	score = new JLabel(""+m.objectif.getTargetScore());
    	JLabel lCoupRestant = new JLabel("Coups Restant :");
    	coupsRestants = new JLabel(""+m.objectif.getTargetScore());
    	JLabel lVertRestant = new JLabel("Vert :");
    	vertRestant = new JLabel(""+m.objectif.getNbVertRestant());
    	JLabel lRougeRestant = new JLabel("Rouge :");
    	rougeRestant = new JLabel(""+m.objectif.getNbRougeRestant());
    	JLabel lBleuRestant = new JLabel("Bleu :");
    	bleuRestant = new JLabel(""+m.objectif.getNbBleuRestant());
    	JLabel lVioletRestant = new JLabel("Violet :");
    	violetRestant = new JLabel(""+m.objectif.getNbVioletRestant());
    	JLabel lJauneRestant = new JLabel("Jaune :");
    	jauneRestant = new JLabel(""+m.objectif.getNbJauneRestant());
    	JLabel lOrangeRestant = new JLabel("Orange :");
    	orangeRestant = new JLabel(""+m.objectif.getNbOrangeRestant());
    	JLabel lEmballeRestant = new JLabel("Emballé :");
    	emballeRestant = new JLabel(""+m.objectif.getNbEmballeRestant());
    	JLabel lRayeRestant = new JLabel("Rayé :");
    	rayeRestant = new JLabel(""+m.objectif.getNbRayeRestant());
    	JLabel lMultiRestant = new JLabel("Multicolor :");
    	multicolorRestant = new JLabel(""+m.objectif.getNbMultiRestant());
    	/*pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);
    	pObjectifs.add(...);*/
    	
		
		/* La grille */
		JPanel pGrille = new JPanel(new GridLayout(m.grille.getLigne(), m.grille.getColonne()));
		for (int i = 0; i < m.grille.getLigne(); i++) {
		    for (int j = 0; j < m.grille.getColonne(); j++) {
		    	pGrille.add(cases[i][j]);
		    }
		}
		
		/* Barre de progression ... a voir*/
		progressbar = new JProgressBar(0, 100);
		progressbar.setValue(0);
		progressbar.setStringPainted(true);
		
		pFenetre.add(barreMenu, BorderLayout.NORTH);
		pFenetre.add(pGrille, BorderLayout.EAST);
		pFenetre.add(pObjectifs, BorderLayout.WEST);
		
		contenu.add(pFenetre);
		
		fenetre.pack();
		fenetre.setVisible(true);
    	
    }
    
    /**
     * Fais le lien entre le contenu d'une case et l'icon correspondant
     * @param contenu Case
     * @return L'icon correspondant
     */
    static private Icon contenu2Image(Case contenu)
    {
		Icon resultat = null;
		Bonbon bonbonContenu = contenu.getBonbon();
		switch (bonbonContenu.getCouleur()) {
		    case ORANGE:
		    	
		    	resultat = orange;
			break;
	
		    case ROUGE:
		    	resultat = rouge;
			break;
	
		    case VERT:
		    	resultat = vert;
			break;
			
		    case BLEU:
		    	resultat = bleu;
			break;
			
		    case VIOLET:
		    	resultat = violet;
			break;
			
		    case JAUNE:
		    	resultat = jaune;
			break;
		default:
			//fail
			break;
		}
		return resultat;
    }
    
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
