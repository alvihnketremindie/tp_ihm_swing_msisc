package editeurv3.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;

import editeurv3.createur.CreateurForme;
import editeurv3.forme.Forme;

/**
 * @author ALVIHN
 *
 */
public class ZoneDeDessin extends JPanel {

	class ZoneDeDessinMouseListener implements MouseListener {

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
			beginDessin(arg0.getX(), arg0.getY());
			//System.out.println("event mousePressed "+ arg0.getX()+" "+ arg0.getY());
			//this.zoneDeDessin.repaint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			endDessin(arg0.getX(), arg0.getY());
			//System.out.println("event mouseReleased "+ arg0.getX()+" "+ arg0.getY());
			//this.zoneDeDessin.repaint();
		}

	}

	class ZoneDeDessinMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			motionDessin(arg0.getX(), arg0.getY());
			//System.out.println("event mouseDragged "+ arg0.getX()+" "+ arg0.getY());
			//this.zoneDeDessin.repaint();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1723497485451614252L;
	private static String nomFichierSauvegarde = "savedraw.txt";
	private int x_pointDeDepart;
	private int y_pointDeDepart;

	private Forme dessin;
	private CreateurForme createurForme;

	/**
	 * Constructeur de la zone de dessin
	 * 1 - Création du MouseListener
	 * 2 - Création du MouseMotionListener
	 * 2 - Ajout du MouseMotionListener
	 */
	public ZoneDeDessin() {
		//Ajout des listeners pour la zone
		addMouseListener(new ZoneDeDessinMouseListener());
		addMouseMotionListener(new ZoneDeDessinMouseMotionListener());
		setBackground(Color.WHITE);
		setLayout(null);
	}

	public void setCreateurDessin(CreateurForme c) {
		createurForme = c;
		//On informe les listeners que le createur a changé
		this.firePropertyChange("creator", null, createurForme);
	}

	public CreateurForme getCreateurDessin() {
		return createurForme;
	}
	public void beginDessin(int x, int y) {
		x_pointDeDepart = x;
		y_pointDeDepart = y;
		/*
		//Ajout du dessin	-------	//
		//this.dessin = new Dessin();
		//this.dessin = new Ellipse();
		//this.dessin = new Rectangle();
		 * 
		 */
		dessin = createurForme.creerForme();
		dessin.setForeground(getForeground());
		add(dessin,0);
		motionDessin(x, y);
	}

	public void endDessin(int x, int y) {
		this.motionDessin(x, y);
	}

	public void motionDessin(int x, int y) {
		int x_dessin, y_dessin, largeur_dessin, hauteur_dessin;

		x_dessin = Math.min(this.x_pointDeDepart, x);
		y_dessin = Math.min(this.y_pointDeDepart, y);
		largeur_dessin = Math.abs(this.x_pointDeDepart - x);
		hauteur_dessin = Math.abs(this.y_pointDeDepart - y);
		dessin.setBounds(x_dessin, y_dessin, largeur_dessin, hauteur_dessin);
	}

	public void sauvegarder() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(nomFichierSauvegarde))));
			for(Component leComposant : getComponents()) {
				oos.writeObject(leComposant);
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void restaurer() {
		//On récupère maintenant les dessin
		ObjectInputStream ois;
		Boolean done = false;
		removeAll();
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(nomFichierSauvegarde))));
			while(!done) {
				try {
					Forme dessinDeForme = (Forme) ois.readObject();
					if(dessinDeForme != null) {
						add(dessinDeForme);
					} else {
						done = true;
					}
				} catch (ClassNotFoundException e) {
					//System.err.println("Erreur classe non trouvée !");
					done = true;
				} catch (EOFException e) {
					//System.err.println("Erreur fin de fichier !");
					done = true;
				}
			}
			ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("Aucune sauvegarde trouvée !");
		} catch (IOException e) {
			System.err.println("Erreur d'entrée / sortie");
		}
		repaint();
	}
	/*
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.MAGENTA);
		g.drawRect(this.x_duDessin, this.y_duDessin, this.largeurRectangle, this.hauteurRectangle);
		//System.out.println("Dessin : x_pointDeDepart = "+this.x_pointDeDepart+" y_pointDeDepart = "+this.y_pointDeDepart);
	}
	 */
}
