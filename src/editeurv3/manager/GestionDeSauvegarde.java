package editeurv3.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import editeurv3.vue.ZoneDeDessin;

public class GestionDeSauvegarde extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5288831610868630322L;
	private ZoneDeDessin zoneDeDessin;
	
	/**
	 * Action du bouton sauvegarde
	 * @author ALVIHN
	 *
	 */
	class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			zoneDeDessin.sauvegarder();
		}
	}


	/**
	 * Action du bouton restaurer
	 * @author ALVIHN
	 *
	 */
	class RestoreButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			zoneDeDessin.restaurer();
		}

	}
	/**
	 * Constructeur des actions de sauvegardes
	 * @param z : Zone de dessin
	 */
	public GestionDeSauvegarde (ZoneDeDessin z) {
		super("Fichier");
		zoneDeDessin = z;
		//Bouton sauvegarder
		ajoutBouton("Sauvegarder", new SaveButtonListener());
		//Bouton restaurer
		ajoutBouton("Restaurer", new RestoreButtonListener());
	}
	
	public void ajoutBouton(String leNomDuBouton, ActionListener actionListener) {
		JMenuItem leBouton = new JMenuItem(leNomDuBouton);
		leBouton.addActionListener(actionListener);
		add(leBouton);
	}
}
