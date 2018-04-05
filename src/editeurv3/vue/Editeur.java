package editeurv3.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import editeurv3.manager.GestionDeChoixCouleur;
import editeurv3.manager.GestionDeChoixForme;
import editeurv3.manager.GestionDeSauvegarde;


public class Editeur extends JFrame {

	class Fermeur extends WindowAdapter {
		public void windowClosing (WindowEvent e) {
			System.exit (0) ;
		}
	}
	/**
	 * Constructeur de l'editeur version 3
	 * 
	 */
	private static final long serialVersionUID = 6624334025583896166L;
	
	public Editeur () {
		super ("Editeur v1.3");
		addWindowListener(new Fermeur ());
		
		ZoneDeDessin zoneDeDessin = new ZoneDeDessin();
		zoneDeDessin.setPreferredSize(new Dimension(800, 600));

		//Mise en place du preview
		JPanel previewPanel = new JPanel();
		//previewPanel.setBackground(Color.BLACK);
		previewPanel.setPreferredSize(new Dimension(100,100));
		Preview preview = new Preview();
		previewPanel.add(preview);
		

		//On abonne le preview aux changement de la zone de dessin
		zoneDeDessin.addPropertyChangeListener("foreground", preview); 
		zoneDeDessin.addPropertyChangeListener("creator", preview);
		
		
		//Panneau et Menu Couleur
		GestionDeChoixCouleur gestionaireDeCouleur = new GestionDeChoixCouleur(zoneDeDessin);
		JPanel colorPanel = gestionaireDeCouleur.retournePanel();
		//colorPanel.setPreferredSize(new Dimension(100, 100));
		JMenu colorMenu = gestionaireDeCouleur.retourneMenu();
		
		//Panneau et Menu Forme
		GestionDeChoixForme gestionnaireDeForme = new GestionDeChoixForme(zoneDeDessin);
		JPanel shapePanel = gestionnaireDeForme.retournePanel();
		//shapePanel.setPreferredSize(new Dimension(100, 100));
		JMenu shapeMenu = gestionnaireDeForme.retourneMenu();
		
		//Menu de sauvegarde
		GestionDeSauvegarde saveMenu = new GestionDeSauvegarde(zoneDeDessin);
		
		//Mise en place des menus
		JMenuBar barreDeMenu = new JMenuBar();
		barreDeMenu.add(colorMenu);
		barreDeMenu.add(shapeMenu);
		barreDeMenu.add(saveMenu);
		setJMenuBar(barreDeMenu);
		
		//Organisation de l'editeur
		getContentPane().add(BorderLayout.CENTER, zoneDeDessin);
		getContentPane().add(BorderLayout.EAST, colorPanel);
		getContentPane().add(BorderLayout.WEST, shapePanel);
		getContentPane().add(BorderLayout.SOUTH, previewPanel);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		//repaint();
	}
}
