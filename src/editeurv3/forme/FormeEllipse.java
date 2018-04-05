package editeurv3.forme;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class FormeEllipse extends Forme {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3554311549626735038L;
	Shape shapeInterieur, shapeExterieur ;
	
	public void paint(Graphics g) {
		super.paint(g);
		int largeur = getWidth() -1;
		int hauteur = getHeight() -1;
		g.drawOval(0, 0, largeur, hauteur);
	}
	
	public boolean contains (int x, int y) {
		if (shapeExterieur == null || ! shapeExterieur.getBounds().getSize().equals (getSize())) {
			shapeExterieur = new Ellipse2D.Float (-2, -2, getWidth() +4, getHeight() +4) ;
		}
		if (shapeInterieur == null || ! shapeInterieur.getBounds().getSize().equals (getSize())) {
			shapeInterieur = new Ellipse2D.Float (2, 2, getWidth() -4, getHeight() -4) ;
		}
		return (shapeExterieur.contains (x, y) && !shapeInterieur.contains(x,y)) ;
	}

}
