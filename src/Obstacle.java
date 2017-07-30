import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Obstacle 
{
	Image img;
	int x,y;
	boolean isAlive=true;
	
	public Obstacle(int startX,int startY)
	{
		x=startX;
		y=startY;
		setImage();
		
		
		//ImageIcon l=new ImageIcon(location);
		
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setImage()
	{
		Random r = new Random();
		int i=r.nextInt()%2;
		
		if(i<=0)
		{
			ImageIcon b=new ImageIcon("image/stone.png");
			img=b.getImage();
		}
		else
		{
			ImageIcon b=new ImageIcon("image/box.png");
			img=b.getImage();
		}
	}
	
	public int getY()
	{
		return y;
	}
	public Rectangle getObstacleBound()
	{
		return new Rectangle(x+15,y+15,30,30);
	}
	public boolean Alive()
	{
		return isAlive;
	}
	public Image getImage()
	{
		return img;
	}
}

