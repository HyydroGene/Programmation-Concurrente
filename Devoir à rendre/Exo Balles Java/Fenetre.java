package TD1.Exercice3_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener
{
	
	// Constantes pour la taille de la fenêtre
	
	public final static int WIDTH = 800;
	public final static int HEIGHT = 700;
	
	// Variables concernant les informations affiché à l'écran : 
	public static int nombreCercle = 1;
	public static int tempsEcoule = 0;
	public static int score = 0;

	// Attributs lié à ce qui va s'afficher à l'écran (Les cercles, les boutons, etc)
	
	private Cercle[] cercles = new Cercle[21];
	
	//Threads : (Il y en a 3)
	
	private ThreadConsommateur tc = new ThreadConsommateur(cercles);
	private ThreadProducteur tp = new ThreadProducteur(cercles);
	private Temps t = new Temps();
	
	// Boutons : 
	
	private JButton boutonStart = new JButton("Start");
	private JButton boutonStop = new JButton("Stop");
	public static JButton boutonPlus = new JButton("+");
	public static JButton boutonMoins = new JButton("-");
	
	// Container principal (Celui qui va regrouper tous les autres éléments) : 
	public static JPanel container = new JPanel();
	
	// Texts : 
	private JLabel label = new JLabel("Nombre de balles : "+nombreCercle);
	public static JLabel scoreText = new JLabel("Score : "+score);
	public static JLabel timeText = new JLabel("Temps : "+tempsEcoule);
	
	
	
	// Variable booleenne permettant d'initialiser les threads (méthode start) qu'une seule fois sinon ça provoque une erreur
	
	private boolean firstTime = true;
	
	@SuppressWarnings("deprecation") //Pour éviter le warning dû à l'utilisation des méthodes resume et suspend
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource() == boutonStart)
		{
			//label.setText("Start");
			
			if(firstTime) 
			{
				tc.start();
				t.start();
				firstTime = false;
			}
			else 
			{
				tc.resume();
				t.resume();
			}
			
			boutonStart.setEnabled(false);
			boutonStop.setEnabled(true);
	
		}
		
		if(arg0.getSource() == boutonStop)
		{
			//label.setText("Stop");
			boutonStart.setEnabled(true);
			boutonStop.setEnabled(false);
			
			tc.suspend();
			t.suspend();
		}
		
		
		if(arg0.getSource() == boutonPlus)
		{
			nombreCercle += 1;
			cercles[nombreCercle] = new Cercle();
			label.setText("Nombre de balles : "+nombreCercle);
			boutonMoins.setEnabled(true);
			
			if(nombreCercle > 19)
			{
				boutonPlus.setEnabled(false);
			}
			
		}
		
		if(arg0.getSource() == boutonMoins)
		{
			nombreCercle -= 1;
			boutonPlus.setEnabled(true);
			cercles[nombreCercle] = new Cercle();
			label.setText("Nombre de balles : "+nombreCercle);
			if(nombreCercle < 1)
			{
				boutonMoins.setEnabled(false);
				
			}
		}
	}

	public Fenetre()
	{
		this.setTitle("Exercice Balles Java");
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		for(int i=0; i < nombreCercle; i++)
		{
			cercles[i] = new Cercle();
		}
		
		// On ajoute les cercles à l'écran et on démarre le timer
		tp.start();
		
		// On ajoute les deux boutons (Start / Stop / plus / moins)
		boutonStart.addActionListener(this);
		boutonStop.addActionListener(this);
		boutonPlus.addActionListener(this);
		boutonMoins.addActionListener(this);
		
		JPanel east = new JPanel();
		east.add(boutonStart);
		east.add(boutonStop);
		container.add(east, BorderLayout.EAST);
		
		JPanel south = new JPanel();
		south.add(boutonPlus);
		south.add(boutonMoins);
		container.add(south, BorderLayout.SOUTH);
		
		
		JPanel north = new JPanel();
		
		Font police = new Font("Arial",Font.BOLD,18);
		label.setFont(police);
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(JLabel.CENTER);
		//container.add(label, BorderLayout.NORTH);
		
		timeText.setFont(police);
		timeText.setForeground(Color.BLACK);
		timeText.setHorizontalAlignment(JLabel.CENTER);
		
		scoreText.setFont(police);
		scoreText.setForeground(Color.BLACK);
		scoreText.setHorizontalTextPosition(JLabel.CENTER);
		
		north.add(label);
		north.add(timeText);
		north.add(scoreText);
		container.add(north, BorderLayout.NORTH);
		//container.add(timeText, BorderLayout.NORTH);
		
		
		
		this.setContentPane(container);
		
	}
}