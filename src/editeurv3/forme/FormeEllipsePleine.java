package editeurv3.forme;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class FormeEllipsePleine extends Forme {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3554311549626735038L;
	Shape shape;

	public void paint(Graphics g) {
		super.paint(g);
		int largeur = getWidth() -1;
		int hauteur = getHeight() -1;
		g.fillOval(0, 0, largeur, hauteur);
	}

	public boolean contains (int x, int y) {
		if (shape == null || ! shape.getBounds ().getSize().equals (getSize ())) {
			shape = new Ellipse2D.Float (0, 0, getWidth (), getHeight ()) ;
		}
		return (shape.contains (x, y)) ;
	}

}
