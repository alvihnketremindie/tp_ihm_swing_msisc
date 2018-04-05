package editeurv3.forme;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * Classe de gestion des formes
 */
public abstract class Forme extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5843804888149816996L;
	int x_depart;
	int y_depart;
	
	class FormeMouseListener implements MouseListener, Serializable  {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7229030935804618948L;

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			x_depart = arg0.getX();
			y_depart = arg0.getY();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class FormeMouseMotionListener implements MouseMotionListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1176853991173538000L;

		/** 
		 * (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
		 * Cet @Override sert à gérer le deplacement de la forme selectionnée.
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			int dx, dy;
			dx = e.getX() - x_depart;
			dy = e.getY() - y_depart;
			setLocation(getX() + dx, getY() + dy);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * Constructeur de la classe Forme.
	 * S'assure que le contour rectangulaire soit invisible.
	 * Ajoute un MouseListener et un MouseMotionListener à la forme crée
	 */
	public Forme() {
		setOpaque(false);
		addMouseListener(new FormeMouseListener());
		addMouseMotionListener(new FormeMouseMotionListener());
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}
}
