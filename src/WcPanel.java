import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class WcPanel extends JPanel{
	
	
	JButton btnStart;
	JButton btnAbout;
	
	JButton btnExit;
	Image img,btnS,btnSe,btnA,btnE;
	BufferedImage buf;
	WcPanel() throws IOException{
		btnStart=new JButton();
		btnAbout=new JButton();
		
		btnExit=new JButton();
		
		//btnStart.setText("Start");
		//btnAbout.setText("About");
		//btnExit.setText("Exit");
		
		img=ImageIO.read(ReasourceLoader.class.getResourceAsStream("front.png"));
		
	 	btnS=ImageIO.read(ReasourceLoader.class.getResourceAsStream("start.png"));

		btnA= ImageIO.read(ReasourceLoader.class.getResourceAsStream("about.jpg"));
		btnE=ImageIO.read(ReasourceLoader.class.getResourceAsStream("exit.jpg"));
		
		btnStart.setIcon(new ImageIcon(btnS));
		btnAbout.setIcon(new ImageIcon(btnA));
	
		btnExit.setIcon(new ImageIcon(btnE));
		
		
		
		
		this.setLayout(null);
	}
	public void addComponents(){
		btnStart.setBounds(418,286,211,77);
		btnAbout.setBounds(417,380,210,76);
		
		btnExit.setBounds(418,474,209,76);
		
		this.add(btnStart);
		
		this.add(btnAbout);
		this.add(btnExit);
		
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		g.drawImage(img, 0,0,null);
	}
	

}
