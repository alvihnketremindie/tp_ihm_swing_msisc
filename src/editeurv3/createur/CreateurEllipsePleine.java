package editeurv3.createur;

import editeurv3.forme.Forme;
import editeurv3.forme.FormeEllipsePleine;

public class CreateurEllipsePleine implements CreateurForme {

	@Override
	public Forme creerForme() {
		// TODO Auto-generated method stub
		return new FormeEllipsePleine();
	}

}
