package TD1.Exercice3_1;

public class ThreadConsommateur extends Thread
{
	private float distance;
	private float dx, dy;
	
	private Cercle[] cercles = new Cercle[Fenetre.nombreCercle];
	
	public ThreadConsommateur(Cercle[] cercles)
	{
		for(int i=0; i<Fenetre.nombreCercle;i++)
		{
			this.cercles[i] = new Cercle();
		}
		
		this.cercles = cercles;
		
		
		this.setDaemon(true);
	}
	
	public void run()
	{
		while(true)
		{
			for(int i=0; i<Fenetre.nombreCercle;i++)
			{
				this.cercles[i].moveCercle();
			}
			
			//On test la collision : 
			
			for(int i=0; i<Fenetre.nombreCercle; i++)
			{
				for(int j=0; j<Fenetre.nombreCercle; j++)
				{
					dx = cercles[i].getX() - cercles[j].getX();
					dy = cercles[i].getY() - cercles[j].getY();
					
					distance = (float)Math.sqrt((dx * dx) + (dy * dy));
					
					// Si il y a une collision : 
					if(Fenetre.nombreCercle >= 2 && distance <= cercles[i].getWidth() + cercles[i].getWidth())
					{
						
						// On enl�ve les cercles de l'�cran
						cercles[i].setEnabled(false);
						cercles[j].setEnabled(false);
						
						
						// On augmante le score de 2 (Car c'est 2 cercles qui sont retir�s (1 par cercle))
						Fenetre.score += 2;
						Fenetre.scoreText.setText("Score : "+Fenetre.score);
						
						// On diminue le nombre de cercles de l'�cran de 2 
						//Fenetre.nombreCercle -= 2; (A d�commenter apr�s que la collision fonctionne)
					}
					
				}
				
			}
		}
	}
	
}