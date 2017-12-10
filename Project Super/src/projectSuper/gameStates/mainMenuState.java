package projectSuper.gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import projectSuper.Main.GamePanel;

public class mainMenuState extends gameState 
{
	
	public mainMenuState(gameStateManager gsm) 
	{
		super(gsm);
	}


	public void init() 
	{
		
	}

	public void update() 
	{
		
	}

	public void draw(Graphics g) 
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1920,1080);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Ariel",Font.BOLD,30));
		g.drawString("MAIN MENU", 550, 300);
	}

	public void handleInput() 
	{
		
	}

}
