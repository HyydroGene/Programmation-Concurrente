package TD1.Exercice3_1;

public class Temps extends Thread
{
	public Temps()
	{
		//Constructeur vide
	}
	
	//Cette classe � uniquement pour but de lancer le timer (qui va compter en seconde)
	
	public void run()
	{
		while(true)
		{
			try{
				Thread.sleep(1000); // Repr�sente 1 seconde.
				Fenetre.tempsEcoule++;
				Fenetre.timeText.setText("Temps : "+Fenetre.tempsEcoule); // On actualise le texte � chaque nouveau passage.
			} catch (InterruptedException e) {}
		}
	}
}