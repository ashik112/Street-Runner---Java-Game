import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

public class MyFrame extends JFrame
{
	public MyPanel p;
	public WcPanel wc;
	MyFrame f;
	int count=0;
	
	MyFrame() throws  InterruptedException, IOException
	{
		 f= this;
		this.setTitle("Run!");
		this.setSize(1000, 600);
	//	this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 WcPanel wc=new WcPanel();
		 wc.addComponents();
		 this.add(wc);
		//this.setVisible(true);
		
		
		
		
		
		
		try {
			p = new MyPanel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.add(p);
		//this.getContentPane().add(p);		
		//p.setDoubleBuffered(true);
		//RepaintManager.currentManager(this).setDoubleBufferingEnabled(true);
		

		wc.btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				     f.remove(wc);
				     f.add(p);
					 p.btnRemove();
					 if(count==0)
					 {
						 p.reSart(); count++;
					 }
					 else
					 {
						 p.reSart();
						 try {
							BackGround b = new BackGround(p);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					 
					 f.setVisible(true);
			}
		
		});
		
		p.btnHomePage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{				
				f.remove(p);
				f.add(wc);
				p.btnRemove();
				wc.repaint();
				f.setVisible(true);
			}			
		});
		
		
		
		p.btnTryAgain.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{				
				 p.btnRemove();
				 p.reSart();
				 try {
						BackGround b = new BackGround(p);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 f.setVisible(true);
			}
			
		});
		
		wc.btnAbout.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(f,"Game Developed & Designed By\n Md. Ashekur Rahman.\nUsama Ibna Ishque.");
				
			}
			
		});
		
		
		wc.btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		this.setVisible(true);		
	}
	

}
