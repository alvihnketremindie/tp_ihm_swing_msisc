package editeurv3.forme;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class FormeRectanglePlein extends Forme {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1932552366994316640L;
	Shape shape;
	
	public void paint(Graphics g) {
		super.paint(g);
		int largeur = getWidth() -1;
		int hauteur = getHeight() -1;
		g.fillRect(0, 0, largeur, hauteur);
	}
	
	public boolean contains (int x, int y) {
		if (shape == null || ! shape.getBounds ().getSize().equals (getSize ())) {
			shape = new Rectangle2D.Float (0, 0, getWidth (), getHeight ()) ;
		}
		return (shape.contains (x, y)) ;
	}
}
