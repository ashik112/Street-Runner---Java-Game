import java.awt.*;
import java.io.IOException;

public class PanelMain {

	public static void main(String[] args) throws IOException
	{
		MyFrame f = null;
		try 
		{
			f = new MyFrame();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//final MyPanel p = new MyPanel();
		//f.add(p);
		f.setVisible(true);		
	}

}
