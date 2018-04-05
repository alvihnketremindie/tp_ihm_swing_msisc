package editeurv3.forme;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class FormeRectangle extends Forme {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1932552366994316640L;
	Shape shapeInterieur, shapeExterieur;
	
	public void paint(Graphics g) {
		super.paint(g);
		int largeur = getWidth() -1;
		int hauteur = getHeight() -1;
		g.drawRect(0, 0, largeur, hauteur);
	}
	
	public boolean contains (int x, int y) {
		if (shapeExterieur == null || ! shapeExterieur.getBounds().getSize().equals (getSize ())) {
			shapeExterieur = new Rectangle2D.Float (-2, -2, getWidth() +4, getHeight() +4) ;
		}
		if (shapeInterieur == null || ! shapeInterieur.getBounds().getSize().equals (getSize ())) {
			shapeInterieur = new Rectangle2D.Float (2, 2, getWidth() -4, getHeight() -4) ;
		}
		return (shapeExterieur.contains (x, y) && !shapeInterieur.contains(x,y)) ;
	}
}
