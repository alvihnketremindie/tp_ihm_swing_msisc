package editeurv3.manager;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import editeurv3.vue.ZoneDeDessin;

/**
 * @author ALVIHN
 * Classe de gestion de choix pr�sent dans les menus et panneau
 */
public abstract class GestionDeChoix {

	ZoneDeDessin zoneDeDessin;
	String nomDuGestionaire = "";
	LinkedList<JRadioButton> lesBoutons = new LinkedList<JRadioButton>();
	LinkedList<String> lesNoms = new LinkedList<String>();
	ButtonGroup groupeDeBoutton = new ButtonGroup();

	/**
	 * Creer un menu associ� � un gestionnaire particulier (Couleur, Forme, Fichier)
	 * @return Le menu correspondant
	 */
	public JMenu retourneMenu() {
		JMenu menu = new JMenu(nomDuGestionaire);
		//Mise en place des boutons radio
		for (JRadioButton leBouton : lesBoutons) {
			JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem(leBouton.getText());
			jRadioButtonMenuItem.setModel(leBouton.getModel());
			menu.add(jRadioButtonMenuItem);
		}
		return menu;
	}

	/**
	 * Cr�er un panneau associ� � un gestionnaire particulier (Couleur, Forme, Fichier)
	 * @return Le panneau correspondant
	 */
	public JPanel retournePanel() {
		JPanel panneau = new JPanel();
		//Creation d'un panneau intermediare pour un meilleur affichage
		JPanel panelIntermediare = new JPanel();
		panelIntermediare.setLayout(new GridLayout(lesBoutons.size(),1));
		//Mise en place des boutons radio
		for (JRadioButton leBouton : lesBoutons) {
			panelIntermediare.add(leBouton);
		}
		panneau.add(panelIntermediare);
		return panneau;
	}

	/**
	 * Ajoute un bouton � une liste d�finie de boutons (Le groupe de bouton est aussi mis � jour).
	 * @param leNomDuBouton : Le nom du Bouton
	 * @param actionListener : L'action li� au Bouton
	 */
	public void ajoutBouton(String leNomDuBouton, ActionListener actionListener) {
		JRadioButton leBouton = new JRadioButton(leNomDuBouton);
		leBouton.addActionListener(actionListener);
		lesBoutons.add(leBouton);
		groupeDeBoutton.add(leBouton);
	}

}
