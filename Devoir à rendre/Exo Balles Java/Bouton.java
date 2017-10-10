package TD1.Exercice3_1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Bouton extends JButton
{
	private int x,y;
	private int width, height;
	
	public Bouton(int x,int y, int width, int height)
	{	
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
		
	
}