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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

import org.apache.logging.log4j.LogManager;

import modele.Bonbon;
import modele.BonbonEmballe;
import modele.BonbonNormal;
import modele.BonbonRaye;
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
    private static final ImageIcon inconnu = new ImageIcon("img/inconnu.png");

    /** Fenêtre principale */
    private JFrame fenetre;
    
    /** Cases du jeu */
    private JToggleButton[][] cases ;
    
    public JToggleButton[][] getCases() {
    	return cases;
    }
    
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
    
    private CrushControleur controleur;
    
    /**
     * Construit l'interface graphique
     * @param m modele de l'application
     */
    public CrushGUI(FarmCrush m) {
    	controleur = new CrushControleur(m,this);
    	this.modele = m;
    	//Création des cases
    	cases = new JToggleButton[m.grille.getLigne()][m.grille.getColonne()];
    	for (int j = m.grille.getLigne() -1 ; j >= 0 ; j--) {
		    for (int i = 0 ; i < m.grille.getColonne() ; i++) {
				cases[i][j] = new JToggleButton();
				//attribut public interdit...
				cases[i][j].setIcon(contenu2Image(m.grille.getCase(i, j)));
				int coucheGelatine = m.grille.getCase(i, j).getGelatine().getCoucheGelatine();
				if( coucheGelatine != 0) {
					cases[i][j].setBackground(new Color(0, 255 / coucheGelatine, 0));
				}
				
				cases[i][j].addActionListener(controleur);
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
		for (int j = m.grille.getLigne() -1 ; j >= 0 ; j--) {
		    for (int i = 0 ; i < m.grille.getColonne() ; i++) {
		    	cases[i][j].setText(""+i+","+j);
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
		    	if(bonbonContenu instanceof BonbonRaye){
		    		resultat = orange_raye;
		    	}
		    	else if(bonbonContenu instanceof BonbonEmballe){
		    		resultat = orange_emballe;
		    	}
		    	else if(bonbonContenu instanceof BonbonNormal){
		    		resultat = orange;
		    	}
		    	else{
		    		resultat = inconnu;
		    	}
			break;
	
		    case ROUGE:
		    	if(bonbonContenu instanceof BonbonRaye){
		    		resultat = rouge_raye;
		    	}
		    	else if(bonbonContenu instanceof BonbonEmballe){
		    		resultat = rouge_emballe;
		    	}
		    	else if(bonbonContenu instanceof BonbonNormal){
		    		resultat = rouge;
		    	}
		    	else{
		    		resultat = inconnu;
		    	}
			break;
	
		    case VERT:
		    	if(bonbonContenu instanceof BonbonRaye){
		    		resultat = vert_raye;
		    	}
		    	else if(bonbonContenu instanceof BonbonEmballe){
		    		resultat = vert_emballe;
		    	}
		    	else if(bonbonContenu instanceof BonbonNormal){
		    		resultat = vert;
		    	}
		    	else{
		    		resultat = inconnu;
		    	}
		    	resultat = vert;
			break;
			
		    case BLEU:
		    	if(bonbonContenu instanceof BonbonRaye){
		    		resultat = bleu_raye;
		    	}
		    	else if(bonbonContenu instanceof BonbonEmballe){
		    		resultat = bleu_emballe;
		    	}
		    	else if(bonbonContenu instanceof BonbonNormal){
		    		resultat = bleu;
		    	}
		    	else{
		    		resultat = inconnu;
		    	}
			break;
			
		    case VIOLET:
		    	if(bonbonContenu instanceof BonbonRaye){
		    		resultat = violet_raye;
		    	}
		    	else if(bonbonContenu instanceof BonbonEmballe){
		    		resultat = violet_emballe;
		    	}
		    	else if(bonbonContenu instanceof BonbonNormal){
		    		resultat = violet;
		    	}
		    	else{
		    		resultat = inconnu;
		    	}
			break;
			
		    case JAUNE:
		    	if(bonbonContenu instanceof BonbonRaye){
		    		resultat = jaune_raye;
		    	}
		    	else if(bonbonContenu instanceof BonbonEmballe){
		    		resultat = jaune_emballe;
		    	}
		    	else if(bonbonContenu instanceof BonbonNormal){
		    		resultat = jaune;
		    	}
		    	else{
		    		resultat = inconnu;
		    	}
			break;
			
		    case MULTI:
		    	resultat = multicolore;
		    	break;
		default:
			//fail
			break;
		}
		return resultat;
    }
    
	@Override
	public void update(Observable arg0, Object arg1) {
		//On met a jour la vue de toute les cases
		System.out.println("Vu mise a jour");
		for (int j = this.modele.grille.getLigne() -1 ; j >= 0 ; j--) {
		    for (int i = 0 ; i < this.modele.grille.getColonne() ; i++) {
				cases[i][j].setIcon(contenu2Image(this.modele.grille.getCase(i, j)));
				int coucheGelatine = this.modele.grille.getCase(i, j).getGelatine().getCoucheGelatine();
				if( coucheGelatine != 0) {
					cases[i][j].setBackground(new Color(0, 255 / coucheGelatine, 0));
				}
				else {
					cases[i][j].setBackground(null);
				}
				this.selectionerCase(i, j, false);
		    }
		}
		
		majObjectifs();
		
	}
	
	private void majObjectifs(){
		//score
    	score.setText(""+this.modele.getScoreActuel());
    	//coup restant
    	coupsRestants.setText(""+(this.modele.objectif.getNbVertRestant() - this.modele.getNbCoupJouer()));
    	//vert restant
    	vertRestant.setText(""+this.modele.objectif.getNbVertRestant());
    	//rouge restant
    	rougeRestant.setText(""+this.modele.objectif.getNbRougeRestant());
    	//bleu restant
    	bleuRestant.setText(""+this.modele.objectif.getNbBleuRestant());
    	//violet restant
    	violetRestant.setText(""+this.modele.objectif.getNbVioletRestant());
    	//jaune restant
    	jauneRestant.setText(""+this.modele.objectif.getNbJauneRestant());
    	//orange restant
    	orangeRestant.setText(""+this.modele.objectif.getNbOrangeRestant());
    	//emballe restant
    	emballeRestant.setText(""+this.modele.objectif.getNbEmballeRestant());
    	//raye restant
    	rayeRestant.setText(""+this.modele.objectif.getNbRayeRestant());
    	//multi restant
    	multicolorRestant.setText(""+this.modele.objectif.getNbMultiRestant());
	}
	
	public void selectionerCase(int i, int j, boolean selected){
		cases[i][j].setSelected(selected);
	}

}
