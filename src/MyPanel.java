import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;


import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;
import javax.imageio.ImageIO;




public class MyPanel extends JPanel implements Runnable, MouseListener
{
	BackGround bk;
	
	Image 
	man,
	build,build2,build3,build4,back,btnT,btnH;
	
	int x=300,y=335;
	
	Thread t;
	Timer time;
	JButton btnTryAgain;
	JButton btnHomePage;
	
	BufferedImage img;
	double score;
	static Font font = new Font("TimesRoman", Font.ROMAN_BASELINE, 40);
	
	int backBuildingX=0, backBuildingX2=1988,
			frontBuildingX=0,frontBuildingX2=1980,
			roadX=0,roadX2=1000,roadY=490,
			handY=300, cloudX=0, cloudX2=1310,
			oX=1200,oY=y+145,oX2=oX+1200;
	Obstacle[] ob=new Obstacle[6];
	
	boolean q=true;
	boolean h=false;
	boolean done=false;
	int dy=0;
	
	MyPanel() throws IOException
	{
		btnTryAgain =new JButton();
		
		 btnHomePage =new JButton();
		 
		addMouseListener(this);
		
		
		bk = new BackGround(this);
		
	    ImageIcon m = new ImageIcon("image/character6.gif");
		man = m.getImage();		
		 m = new ImageIcon("image/bkt.gif");
		back = m.getImage();	
		
		ob[0]=new Obstacle(oX,oY);
	 	ob[1]=new Obstacle(oX+400,oY);
	 	ob[2]=new Obstacle(oX+800,oY);
	 	ob[3]=new Obstacle(oX2,oY);
	 	ob[4]=new Obstacle(oX2+400,oY);
	 	ob[5]=new Obstacle(oX2+800,oY);
    	t= new Thread(this);
	 	 btnTryAgain =new JButton();
			
		 btnHomePage =new JButton();
	 	
		
	}
	boolean lost=false;
	public void checkCollission()
	{
		Rectangle r = getCharBound();
		for(int i=0;i<6;i++)
		{
			Rectangle w = ob[i].getObstacleBound();
			if(r.intersects(w))
			{
				lost=true;
			}
		}
	}
	public Rectangle getCharBound()
	{
		return new Rectangle(x+60,y,30,200);
	}
	
	public void paintComponent(Graphics g)
	{
		if(dy==1 && q==false)
		{
			q=true;
			t = new Thread(this);
			t.start();
		}
		
		final Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d); 
		
		g2d.drawImage(back,-5,0,null);
		
		g2d.drawImage(bk.backBuilding,backBuildingX,20,null);
		g2d.drawImage(bk.backBuilding,backBuildingX2,20,null);
		
		
		
		g2d.drawImage(bk.cloud,cloudX,1,1300,300,null);
		g2d.drawImage(bk.cloud,cloudX2,1,1300,300,null);
		
		g2d.drawImage(bk.frontBuilding,frontBuildingX,0,null);
		g2d.drawImage(bk.frontBuilding,frontBuildingX2,0,null);		
		
		g2d.drawImage(bk.road,roadX,roadY,null);
		g2d.drawImage(bk.road,roadX2,roadY,null);
		
		g2d.drawImage(man,x,y,110,200,null);
		//g2d.drawRect(x+60,y,30,200);
		
		
		g2d.drawImage(ob[0].getImage(),oX,oY,60,60,null);
		//g2d.drawRect(oX+15, oY+15, 30, 30);
		g2d.drawImage(ob[1].getImage(),oX+400,oY,60,60,null);
		g2d.drawImage(ob[2].getImage(),oX+800,oY,60,60,null);
		g2d.drawImage(ob[3].getImage(),oX2,oY,60,60,null);
		g2d.drawImage(ob[4].getImage(),oX2+400,oY,60,60,null);
		g2d.drawImage(ob[5].getImage(),oX2+800,oY,60,60,null);
		checkCollission();
		//g2d.drawImage(bk.ob3.getImage(),oX+600,oY,60,60,null);
		
		
		
		
		g.setFont(font);
		g.setColor(Color.black);
		
		 g.drawString("Total score: "+((int)score), 700, 55); 
		 //g.drawString("High score: "+((int)1000), 705, 89); 
		 
		
		
		//g2d.drawImage(bk.hand,0,handY,200,250,null);
		}
	
	
	

	@Override
	public void run() 
	{		
		while(done==false)
		{
			jumpCycle();
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		h=false;
		done=false;
		q=false;
		dy=0;
		}
	
	
	
	public void jumpCycle()
	{
		if(h==false)
		{
			y--;
		}
		if(y==240)
		{
			h=true;
		}
		if(y<=335 && h==true)
		{
			y++;
			
			if(y==335)
			{
				done=true;
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		dy=1;
		
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void gameOver() {
		
		this.setLayout(null);
		btnTryAgain.setBounds(400, 200, 211, 66);
		try {
			btnT=ImageIO.read(ReasourceLoader.class.getResourceAsStream("try.jpg"));
			btnH=ImageIO.read(ReasourceLoader.class.getResourceAsStream("home.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnTryAgain.setIcon(new ImageIcon(btnT));
		//btnTryAgain.setText("Try Again?");
		btnHomePage.setBounds(400, 300, 210, 66);
		//btnHomePage.setText("Home");
		btnHomePage.setIcon(new ImageIcon(btnH));
		this.add(btnTryAgain);
		this.add(btnHomePage);
		this.updateUI();
		
	}
	public void btnRemove(){
		this.remove(btnTryAgain);
		this.remove(btnHomePage);
	}
	public void reSart(){
		
		
		 x=300;y=335;
		 backBuildingX=0; backBuildingX2=1988;
		frontBuildingX=0;frontBuildingX2=1980;
		roadX=0;roadX2=1000;roadY=490;cloudX=0;cloudX2=1310;
					handY=300;
					oX=1200;oY=y+145;oX2=oX+1200;
					
					ob[0].setX(oX);
					ob[1].setX(oX+400);
					ob[2].setX(oX+800);
					ob[3].setX(oX2);
					ob[4].setX(oX2+400);
					ob[5].setX(oX2+800);
		
		
		
		 this.score=0;
		 this.lost=false;
		 this.dy=1;
		 q=false;
done = false;
	}
}
