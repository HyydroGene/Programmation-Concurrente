package TD1.Exercice3_1;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends JPanel
{
	private int posX = -50;
	private int posY = -50;
	private int circleWidth = 50;
	private int circleHeight = 50;
	private boolean isMoving = true;
	private int dirX = 1;
	private int dirY = 1;
	boolean bool = true;
	
	private int colorR,colorG,colorB;
	
	public Cercle()
	{
		super();
		
		
		//il arrive parfois que ça bloque, il faut donc relancer une nouvelle fois.
		this.posX = Util.rand(0, Fenetre.WIDTH/2-this.circleWidth);
		this.posY = Util.rand(0, Fenetre.HEIGHT/2-this.circleHeight);
		this.circleWidth = 50;
		this.circleHeight = 50;
		
		// Juste une question d'estetique, pour avoir une couleur de cercle différente à chaque fois.
		colorR = Util.rand(0, 255);
		colorG = Util.rand(0, 255);
		colorB = Util.rand(0, 255);
		
	}
	
	public Cercle(int posX,int posY,int width,int height)
	{
		super();
		this.posX = posX;
		this.posY = posY;
		this.circleWidth = width;
		this.circleHeight = height;
	}
	
	public void paint(Graphics g)
	{
		
		if(Fenetre.nombreCercle == 1)
		{
			g.setColor(Color.darkGray);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
			
			g.setColor(new Color(colorR,colorG,colorB));
			g.fillOval(posX, posY, circleWidth, circleHeight);	
		}
		
		else
		{
			if(bool)
			{
				g.setColor(Color.darkGray);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
				bool = false;
			}
			
			g.setColor(Color.darkGray);
			
			if(dirX == -1 && dirY==-1)
			{
				g.fillOval(posX-1, posY-1, circleWidth+12, circleHeight+12);
			}
			if(dirX == 1 && dirY == 1)
			{
				g.fillOval(posX-11, posY-11, circleWidth+12, circleHeight+12);
			}
			
			if(dirX == 1 && dirY ==-1)
			{
				g.fillOval(posX-11, posY-1, circleWidth+12, circleHeight+12);
			}
			
			if(dirX == -1 && dirY == 1)
			{
				g.fillOval(posX-1, posY-11, circleWidth+12, circleHeight+12);
			}
			
			
			g.setColor(new Color(colorR,colorG,colorB));
			g.fillOval(posX, posY, circleWidth, circleHeight);
			
		}
			
	}

	public synchronized void moveCercle()
	{
		int x = this.getPosX(), y = this.getPosY();
		
			/*boolean backX = false;
			boolean backY = false;
			
			if(x < 1) backX = false;
			
			if(x > this.getWidth() - this.getCircleWidth()) backX = true;
			
			if(y < 1) backY = false;
			
			if(y > this.getHeight() - this.getCircleHeight()) backY = true;
			
			
			if(backX) this.setPosX(--x);
			if(!backX) this.setPosX(++x);
			
			if(backY) this.setPosY(--y);
			if(!backY) this.setPosY(++y); */
			
			x += dirX;
			this.setPosX(x);
			y += dirY;
			this.setPosY(y);
			
			if(x==0 || x==640-this.circleWidth)
			{
				dirX = -dirX;
			}
			
			if(y==0 || y==580-this.circleHeight)
			{
				dirY = -dirY;
			}
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			this.repaint();
	}
	
	
	// Assesseurs : 
	
	public int getPosX()
	{
		return posX;
	}
	
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	public int getCircleWidth()
	{
		return circleWidth;
	}
	
	public void setCircleWdith(int circleWidth)
	{
		this.circleWidth = circleWidth;
	}
	
	public int getCircleHeight()
	{
		return circleHeight;
	}
	
	public void setCircleHeight(int circleHeight)
	{
		this.circleHeight = circleHeight;
	}
	
	
	public boolean getIsMoving()
	{
		return isMoving;
	}
	
	public void setIsMoving(boolean isMoving)
	{
		this.isMoving = isMoving;
	}
	
}