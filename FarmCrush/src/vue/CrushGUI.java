package vue;
import controleur.*;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JToggleButton;

import modele.Bonbon;
import modele.Case;
import modele.Couleur;
import modele.FarmCrush;

public class CrushGUI implements Observer{
	
	/* Ensemble des icons */
	private static final ImageIcon orange = new ImageIcon("img/orange.png");
    private static final ImageIcon rouge = new ImageIcon("img/rouge.png");
    private static final ImageIcon vert = new ImageIcon("img/vert.png");
    private static final ImageIcon bleu = new ImageIcon("img/bleu.png");
    private static final ImageIcon violet = new ImageIcon("img/violet.png");
    private static final ImageIcon jaune = new ImageIcon("img/jaune.png");
    private static final ImageIcon orange_raye = new ImageIcon("img/orange_raye.png");
    private static final ImageIcon rouge_raye = new ImageIcon("img/rouge_raye.png");
    private static final ImageIcon vert_raye = new ImageIcon("img/vert_raye.png");
    private static final ImageIcon bleu_raye = new ImageIcon("img/bleu_raye.png");
    private static final ImageIcon violet_raye = new ImageIcon("img/violet_raye.png");
    private static final ImageIcon jaune_raye = new ImageIcon("img/jaune_raye.png");
    private static final ImageIcon orange_emballe = new ImageIcon("img/orange_emballe.png");
    private static final ImageIcon rouge_emballe = new ImageIcon("img/rouge_emballe.png");
    private static final ImageIcon vert_emballe = new ImageIcon("img/vert_emballe.png");
    private static final ImageIcon bleu_emballe = new ImageIcon("img/bleu_emballe.png");
    private static final ImageIcon violet_emballe = new ImageIcon("img/violet_emballe.png");
    private static final ImageIcon jaune_emballe = new ImageIcon("img/jaune_emballe.png");
    private static final ImageIcon multicolore = new ImageIcon("img/multicolore.png");

    /** Fenêtre principale */
    private JFrame fenetre;
    
    /** Cases du jeu */
    private JToggleButton[][] cases ;
    
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
    	cases = new JToggleButton[m.grille.getLigne()][m.grille.getColonne()];
    	for (int i = 0 ; i < m.grille.getLigne() ; i++) {
		    for (int j = 0 ; j < m.grille.getColonne() ; j++) {
				cases[i][j] = new JToggleButton();
				//attribut public interdit...
				cases[i][j].setIcon(contenu2Image(m.grille.getCase(i, j)));
				int coucheGelatine = m.grille.getCase(i, j).getGelatine().getCoucheGelatine();
				if( coucheGelatine != 0) {
					cases[i][j].setBackground(new Color(0, 255 / coucheGelatine, 0));
				}
				
				//cases[i][j].addMouseListener(new ClickLabel());
		    }
		}
    	
    	// Construction de la vue (présentation)
		fenetre = new JFrame("FarmCrush");
		fenetre.setLocation(300,200);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
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
    	JPanel pObjectifs = new JPanel(new GridLayout(11,1));
    	pObjectifs.setSize(50, 1000);
    	// Ensemble des objectifs //
    	JPanel[] pElementsObjectifs = new JPanel[11];
    	for(int i = 0 ; i < 11 ; i++) {
    		pElementsObjectifs[i] = new JPanel(new FlowLayout());
    		pObjectifs.add(pElementsObjectifs[i]);
    	}
    	//score
    	score = new JLabel(""+m.objectif.getTargetScore());
    	pElementsObjectifs[0].add(new JLabel("Score :"));
    	pElementsObjectifs[0].add(score);
    	//coup restant
    	coupsRestants = new JLabel(""+m.objectif.getNbCoupMax());
    	pElementsObjectifs[1].add(new JLabel("Coups Restant :"));
    	pElementsObjectifs[1].add(coupsRestants);
    	//vert restant
    	vertRestant = new JLabel(""+m.objectif.getNbVertRestant());
    	pElementsObjectifs[2].add(new JLabel("Vert :"));
    	pElementsObjectifs[2].add(vertRestant);
    	//
    	rougeRestant = new JLabel(""+m.objectif.getNbRougeRestant());
    	pElementsObjectifs[3].add(new JLabel("Rouge :"));
    	pElementsObjectifs[3].add(rougeRestant);
    	//
    	bleuRestant = new JLabel(""+m.objectif.getNbBleuRestant());
    	pElementsObjectifs[4].add(new JLabel("Bleu :"));
    	pElementsObjectifs[4].add(bleuRestant);
    	//
    	violetRestant = new JLabel(""+m.objectif.getNbVioletRestant());
    	pElementsObjectifs[5].add(new JLabel("Violet :"));
    	pElementsObjectifs[5].add(violetRestant);
    	//
    	jauneRestant = new JLabel(""+m.objectif.getNbJauneRestant());
    	pElementsObjectifs[6].add(new JLabel("Jaune :"));
    	pElementsObjectifs[6].add(jauneRestant);
    	//
    	orangeRestant = new JLabel(""+m.objectif.getNbOrangeRestant());
    	pElementsObjectifs[7].add(new JLabel("Orange :"));
    	pElementsObjectifs[7].add(orangeRestant);
    	//
    	emballeRestant = new JLabel(""+m.objectif.getNbEmballeRestant());
    	pElementsObjectifs[8].add(new JLabel("Emballé :"));
    	pElementsObjectifs[8].add(emballeRestant);
    	//
    	rayeRestant = new JLabel(""+m.objectif.getNbRayeRestant());
    	pElementsObjectifs[9].add(new JLabel("Rayé :"));
    	pElementsObjectifs[9].add(rayeRestant);
    	//
    	multicolorRestant = new JLabel(""+m.objectif.getNbMultiRestant());
    	pElementsObjectifs[10].add(new JLabel("Multicolor :"));
    	pElementsObjectifs[10].add(multicolorRestant);
    	
		
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
		pFenetre.add(pGrille, BorderLayout.CENTER);
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
