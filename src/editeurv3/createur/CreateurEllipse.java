package editeurv3.createur;

import editeurv3.forme.Forme;
import editeurv3.forme.FormeEllipse;

public class CreateurEllipse implements CreateurForme {

	@Override
	public Forme creerForme() {
		// TODO Auto-generated method stub
		return new FormeEllipse();
	}

}
