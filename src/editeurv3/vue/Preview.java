package editeurv3.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import editeurv3.createur.CreateurForme;
import editeurv3.forme.Forme;
import editeurv3.forme.FormeRectangle;

public class Preview extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4613878638510334104L;
	Color previewColor = Color.BLACK;
	Forme previewForme = new FormeRectangle();
	final int PREVIEW_WIDTH = 90;
	final int PREVIEW_HEIGHT = 90;
	/**
	 * Dessine une miniature de la forme selectioner
	 */
	public Preview () {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(PREVIEW_WIDTH, PREVIEW_HEIGHT));
		setLayout(null);
		//Initialisation avec un rectangle noir
		//previewForme = zoneDeDessin.getCreateurDessin().creerForme();
		//previewColor = zoneDeDessin.getForeground();
		//setPreviewElements();
	}
	
	public void setPreviewElements() {
		/*int x = (int) (0.2*getWidth());
		int y = (int) (0.2*getHeight());
		int width = (int) (0.6*getWidth());
		int height = (int) (0.6*getHeight());
		System.out.println("x = "+x+", y = "+y+", width = "+width+", height = "+height);
		previewForme.setBounds(x, y, width, height);*/
		previewForme.setForeground(previewColor);
		previewForme.setBackground(previewColor);
		this.add(previewForme);
		this.repaint();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		this.removeAll();	//Retrait de tout les dessins
		if(arg0.getPropertyName().equals("foreground")) {
			//On met à jour la couleur du preview
			previewColor = (Color) arg0.getNewValue();
		}
		if(arg0.getPropertyName().equals("creator")) {
			//On met à jour la forme
			//Reprise d'un nouveau dessin avec la forme et le couleur correspondante
			CreateurForme createurForme = (CreateurForme) arg0.getNewValue();
			previewForme = createurForme.creerForme();
			//Retrait des MouseListener
			for (MouseListener leMouseListener : previewForme.getMouseListeners()) {
				previewForme.removeMouseListener(leMouseListener);
			}
			//Retrait des MouseMotionListener
			for (MouseMotionListener leMouseMotionListener : previewForme.getMouseMotionListeners()) {
				previewForme.removeMouseMotionListener(leMouseMotionListener);
			}
		}
		setPreviewElements();
	}

	public void paint(Graphics g) {
		super.paint(g);
		int x = (int) (0.2*getWidth());
		int y = (int) (0.2*getHeight());
		int width = (int) (0.6*getWidth());
		int height = (int) (0.6*getHeight());
		previewForme.setBounds(x, y, width, height);
	}
}
