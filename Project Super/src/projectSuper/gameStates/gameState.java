package projectSuper.gameStates;

import java.awt.Graphics;
import java.awt.Graphics2D;


public abstract class gameState 
{

	protected gameStateManager gsm;
	
	public gameState(gameStateManager g)
	{
		gsm =g;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void handleInput();
}
