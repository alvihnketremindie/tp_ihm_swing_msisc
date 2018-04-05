package editeurv3.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import editeurv3.createur.CreateurEllipse;
import editeurv3.createur.CreateurEllipsePleine;
import editeurv3.createur.CreateurForme;
import editeurv3.createur.CreateurRectangle;
import editeurv3.createur.CreateurRectanglePlein;
import editeurv3.vue.ZoneDeDessin;

public class GestionDeChoixForme extends GestionDeChoix {
	LinkedList<CreateurForme> lesFormes = new LinkedList<CreateurForme>();

	/**
	 * Listener choix d'une forme
	 * @author ALVIHN
	 *
	 */
	class ShapeRadioButtonListener implements ActionListener {
		CreateurForme createurForme;
		public ShapeRadioButtonListener (CreateurForme c) {
			createurForme = c;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			zoneDeDessin.setCreateurDessin(createurForme);
		}

	}

	/**
	 * Constructeur des choix de forme
	 * 1 - La liste des formes est initialisée
	 * 2 - Une boucle est chargé de créer les boutons (Leur ajoutant le listener par la même occasion)
	 * @param z : Zone de dessin
	 */
	public GestionDeChoixForme (ZoneDeDessin z) {
		zoneDeDessin = z;
		nomDuGestionaire = "Forme";
		Collections.addAll(lesNoms, "Rectangle vide", "Rectangle plein", "Ellipse creuse", "Ellipse pleine");
		Collections.addAll(lesFormes, new CreateurRectangle(), new CreateurRectanglePlein(), new CreateurEllipse(), new CreateurEllipsePleine());
		for(int i = 0;i<lesNoms.size();i++) {
			ajoutBouton(lesNoms.get(i), new ShapeRadioButtonListener(lesFormes.get(i)));
		}
		//Action par defaut
		lesBoutons.getFirst().doClick();
	}
}
