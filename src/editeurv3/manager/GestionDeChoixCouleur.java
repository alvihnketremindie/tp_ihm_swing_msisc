package editeurv3.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JColorChooser;

import editeurv3.vue.ZoneDeDessin;

public class GestionDeChoixCouleur extends GestionDeChoix{
	LinkedList<Color> lesCouleurs = new LinkedList<Color>();

	/**
	 * Listener choix d'une couleur
	 * @author ALVIHN
	 *
	 */
	class ColorRadioButtonListener implements ActionListener {

		Color color;
		public ColorRadioButtonListener (Color c) {
			color = c;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			zoneDeDessin.setForeground(color);
		}

	}

	/**
	 * ColorChooser manager
	 * @author ALVIHN
	 *
	 */
	class ColorChooserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color couleur = JColorChooser.showDialog(null, "couleur du fond", zoneDeDessin.getForeground());
			zoneDeDessin.setForeground(couleur);
		}

	}

	/**
	 * Constructeur des choix de couleur
	 * 1 - La liste des couleurs est initialisée
	 * 2 - Une boucle est chargé de créer les boutons (Leur ajoutant le listener par la même occasion)
	 * 3 - Ajout du bouton autre (JColorChooser)
	 * @param z : Zone de dessin
	 */
	public GestionDeChoixCouleur (ZoneDeDessin z) {
		zoneDeDessin = z;
		nomDuGestionaire = "Couleur";
		Collections.addAll(lesNoms, "Rouge", "Bleu", "Vert", "Jaune");
		Collections.addAll(lesCouleurs, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
		for(int i = 0;i<lesNoms.size();i++) {
			ajoutBouton(lesNoms.get(i), new ColorRadioButtonListener(lesCouleurs.get(i)));
		}
		//Gestion des autres couleurs
		ajoutBouton("Autres", new ColorChooserListener());
		//Action par defaut
		lesBoutons.getFirst().doClick();
	}
}
