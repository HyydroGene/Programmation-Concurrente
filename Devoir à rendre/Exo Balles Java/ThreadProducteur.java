package TD1.Exercice3_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class ThreadProducteur extends Thread
{
	
	private Cercle[] cercles = new Cercle[Fenetre.nombreCercle];
	
	public ThreadProducteur(Cercle[] cercles)
	{
		
		for(int i=0; i<Fenetre.nombreCercle;i++)
		{
			this.cercles[i] = new Cercle();
		}
		this.cercles = cercles;
		this.setDaemon(true);
	}
	
	public synchronized void run()
	{
		Fenetre.container.setLayout(new BorderLayout());
		
		while(true)
		{
			cercles[Fenetre.nombreCercle] = new Cercle();
			
			for(int i=0; i<Fenetre.nombreCercle;i++)
			{
				Fenetre.container.add(this.cercles[i], BorderLayout.CENTER);
			}			
		}
		
	}
}