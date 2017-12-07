package projectSuper.Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements KeyListener,MouseListener, Runnable 
{
	/**Look into this
	 * 
	 */
	private static final long serialVersionUID = -5137492406301131554L;
	
	public int height;
	public int width;
	public int scale;
	
	private Thread thread;
	private BufferedImage image;
	private Graphics2D g;
	
	private boolean isRunning;
	
	private int FPS = 60;
	private int targetTime = 10000/FPS;
	
	

	public GamePanel()
	{
		//change this later
		//scale 1
		scale =1;
		height = 1920;
		width = 1080;
		
		setPreferredSize(new Dimension(height*scale,width*scale));// need to make this a variable that can be changed
		requestFocus(true);
		setFocusable(true);
		
		
	}
	
	public void addNotify()
	{
		super.addNotify();
		if(thread == null)
		{
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	

	public void run() 
	{
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(isRunning)
		{
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - (elapsed / 100000);
			
			if(wait<0)
				wait = targetTime;
			try
			{
				Thread.sleep(wait);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void init()
	{
		isRunning = true;
		image = new BufferedImage(WIDTH,HEIGHT,1);
		g = (Graphics2D) image.getGraphics();
	}
	
	private void update()
	{
		
	}
	
	private void draw()
	{
		
	}
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image,0,0,WIDTH,HEIGHT,null);
		g2.dispose();
		
	}
	
	public void keyPressed(KeyEvent k) 
	{

	}

	
	public void keyReleased(KeyEvent k) 
	{

	}
	
	public void keyTyped(KeyEvent k) 
	{
		
	}

	public void mouseClicked(MouseEvent m) 
	{

	}


	public void mouseEntered(MouseEvent m) 
	{

	}

	public void mouseExited(MouseEvent m) 
	{
		
	}

	public void mousePressed(MouseEvent m)
	{
		
	}

	public void mouseReleased(MouseEvent m) 
	{
		
	}
}