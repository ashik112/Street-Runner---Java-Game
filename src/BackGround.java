import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class BackGround implements  Runnable{

	Thread t;
	MyPanel p;
	Timer time;
	
	
	
    
	int i=0;
	 
	BufferedImage frontBuilding, backBuilding, road, cloud, hand;
	
	public BackGround(MyPanel p) throws IOException
	{	
		
	   // ob5=new Obstacle(p.oX,p.oY,"image/stone.png");
		loadImage();
		this.p=p;
		
		t=new Thread(this,"background");
		t.start();
		
    	
			
		
		
	}
	
	public void loadImage()
	{
		try {
			frontBuilding = ImageIO.read(ReasourceLoader.class.getResourceAsStream("building.png"));
			backBuilding= ImageIO.read(ReasourceLoader.class.getResourceAsStream("backBuilding.png"));
			 road = ImageIO.read(ReasourceLoader.class.getResourceAsStream("r111.jpg"));
			
			 cloud = ImageIO.read(ReasourceLoader.class.getResourceAsStream("cloud1.png"));
			//sun=ImageIO.read(ReasourceLoader.class.getResourceAsStream("sun.png"));
			
			//hand=ImageIO.read(ReasourceLoader.class.getResourceAsStream("hand.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*public Image getObstacleImage()
	{
		return ob.getImage();
	}*/
	
	
	public  void backBuildingMove()
	{
		p.backBuildingX--;
		p.backBuildingX2--;
		p.cloudX--;
		p.cloudX2--;
		
		if(p.backBuildingX<=-1988)
		{
			p.backBuildingX=p.backBuildingX2+1988;
			
		}
		if(p.backBuildingX2<=-1988)
		{
			p.backBuildingX2=p.backBuildingX+1988;
		} 
		if(p.cloudX<=-1300)
		{
			p.cloudX=p.cloudX2+1300;
			
		}
		if(p.cloudX2<=-1300)
		{
			p.cloudX2=p.cloudX+1300;
		} 
		//System.out.println(backBuildingX+" "+backBuildingX2);
	}
	public  void obstacleMove()
	{
		//p.oX--;
		//System.out.println(backBuildingX+" "+backBuildingX2);
	}
	
	
	
	public void frontBuildingMove()
	{
		p.frontBuildingX-=2;
		p.frontBuildingX2-=2;
				
		if(p.frontBuildingX<=-1980)
		{
			p.frontBuildingX=p.frontBuildingX2+1980;
		}
		if(p.frontBuildingX2<=-1980)
		{
			p.frontBuildingX2=p.frontBuildingX+1980;
		}
		
	}
	
	
	public void roadMove()
	{
		int dec=0;
		double s=0;
		if(p.score<100)
		{
			dec=5;
			s=0.3;
		}
		else if(p.score<200)
		{
			dec=7;
			s=0.7;
		}
		else 
		{
			dec=8;
			s=1;
		}
		p.roadX-=dec;
		p.roadX2-=dec;	
		p.oX-=dec;
		p.oX2-=dec;
		p.score+=s;
		
		if(p.ob[5]!=null)
		{
		p.ob[0].setX(p.oX);
		p.ob[1].setX(p.oX+400);
		p.ob[2].setX(p.oX+800);
		p.ob[3].setX(p.oX2);
		p.ob[4].setX(p.oX2+400);
		p.ob[5].setX(p.oX2+800);
		}
		
		if(p.roadX<=-1000)
		{
			p.roadX=p.roadX2+1000;
		}
		if(p.roadX2<=-1000)
		{
			p.roadX2=p.roadX+1000;
		}
		if(p.oX<=-1200)
		{
			p.oX=p.oX2+1200;
			p.ob[0].setImage();
			p.ob[1].setImage();
			p.ob[2].setImage();
			
		}
		if(p.oX2<=-1200)
		{
			p.oX2=p.oX+1200;
			p.ob[3].setImage();
			p.ob[4].setImage();
			p.ob[5].setImage();
			
		}
	}
	
	public void handMove()
	{
		if(p.handY>=330)
		{
			p.handY-=20;
		}
		else if(p.handY>=250)
		{
			p.handY+=20;
		}
	}	

	
	public void run() 
	{
		
		while(!(p.lost)){
			backBuildingMove();
			frontBuildingMove();
			roadMove();
			handMove();
			
			
			p.repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
				
			//Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
		}	
		p.gameOver();
	}
	
	
	
}