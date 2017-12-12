package projectSuper.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.Screen;
import projectSuper.gameStates.gameStateManager;



public class GamePanel extends JPanel implements KeyListener,MouseListener, Runnable 
{
	/**Look into this
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int height = 1280;
	public int width= height/16*9;
	public int scale =1;
	
	private Thread thread;
	
	private JFrame frame;
	private gameStateManager gsm;
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	
	private boolean isRunning;
	
	private int FPS = 60;
	private int targetTime = 10000/FPS;
	
	public static void main(String[] args)
	{
		GamePanel g = new GamePanel();
		g.frame = new JFrame("Project Super");
		
		g.frame.add(new GamePanel());
		g.frame.setResizable(true);
		
		g.frame.setVisible(true);
		
		g.frame.pack();
		g.frame.setLocationRelativeTo(null);
		g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g.start();
	}
	

	public GamePanel()
	{
		
		setPreferredSize(new Dimension(height*scale,width*scale));// need to make this a variable that can be changed
		screen = new Screen(width,height);
		
		
		/*
			requestFocus(true);
			setFocusable(true);
			new GamePanel();
		 */
		frame = new JFrame();
		
	}
	
	/*
	// Maybe use the synchronized start and stop?
	// This notation was used in the killer game programming book and in a few youtube tutorials, unsure of the difference between this and synchronized is
	// read some where that maybe bad to use because it can create multiple addNotify()'s
	
	
	public void addNotify()
	{
		super.addNotify();
		if(thread == null)
		{
			addKeyListener(this);
			thread = new Thread(this,"Project Super");
			thread.start();
		}
	}*/
	
	public synchronized void start()
	{
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			isRunning = false;
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	

	public void run() 
	{
		
		init();
		
		//Cherno's way of making a game loop
		double ns = 1000000000.0 / FPS;
		double delta = 0;
		
		int frames = 0;
		int updates = 0;
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		
	    while (isRunning) 
	    {
	    	long now = System.nanoTime();
	    	
	    	delta += (now - lastTime) / ns;//time taken from start of run and start of loop
	    	lastTime = now;
	    	
	    	while(delta >= 1) //do stuff while delta is greater than or equal to 1
	    	{
	    		update();
	    		updates++;
	    		delta--;
	    	}
	    	//do frames after getting out of loop
	        render();
	        frames++;
	        
	        if(System.currentTimeMillis() - timer >= 1000) //ever 1 second print this
	        {
	        	frame.setTitle("Project Super" + "  |  " + updates + " ups, " + frames + " fps");
	        	timer += 1000;
	        	frames = 0;
	        	updates = 0;
	        }
	        
	        /* unsure of this sleep method, could be usefull later
	        if (targetTime > delta) 
	        {
	            try 
	            {
	            	Thread.sleep(targetTime - ((long)delta) );
	            } 
	            catch (InterruptedException e) 
	            {
	            	e.printStackTrace();
	            }
	        }	        */
	    }
	        
	    
	    stop();//in case of unexpected break out from the loop
		
		/*
		long start;
		long elapsed;
		long wait;
		
		while(isRunning)
		{
			
			System.out.println("ran lo0op");
			
			start = System.nanoTime();
			
			update();
			render();
			
			// drawToScreen();  causing a null pointer within the thread for some reason? 
			
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
		*/
	}
	
	public void init()
	{
		//isRunning = true;
		//image = new BufferedImage(WIDTH,HEIGHT,1);
		gsm = new gameStateManager();
	}
	
	private void update()
	{
		gsm.update();
	}
	
	private void render()
	{
		BufferStrategy bs = frame.getBufferStrategy();
		if(bs == null)
		{
			frame.createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render();
		
		for(int i = 0;i<pixels.length;i++)
		{
			pixels[i]= screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		//do graphics
		
		//g.setColor(Color.RED);
		//g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		

		g.drawImage(image, 0, 0,frame.getWidth(), frame.getHeight(), null);

		
		
		
		
		
		//gsm.draw(g);// enable later
		
		g.dispose();
		bs.show();
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