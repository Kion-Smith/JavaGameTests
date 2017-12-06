package projectSuper.Main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener, Runnable 
{
	/**Look into this
	 * 
	 */
	private static final long serialVersionUID = -5137492406301131554L;
	
	public int height;
	public int width;
	public int scale;
	
	private Thread thread;
	private boolean isRunning;
	
	private int FPS = 60;
	
	

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
		
	}
	
	public void draw()
	{
		
	}
	public void render()
	{
		
	}
	public void update()
	{
		
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

	
}
