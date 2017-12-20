package projectSuper.player;

import java.awt.image.BufferedImage;

import projectSuper.graphics.Screen;
import projectSuper.graphics.Sprite;
import projectSuper.input.keyHandler;

public class player
{

	//maybe make a abstract parent for mobs/entities?
	boolean isAlive;
	boolean isHero;
	boolean isWalking;
	boolean isFlying;
	
	Sprite sprite;

	
	int power;
	int health;
	int workpoints;
	
	public int x,y;
	int moveSpeed = 2;

	int dir;
	
	int playerHeadX  = 25;
	int playerHeadY  = 25;
	
	int playerBodyX  = 25;
	int playerBodyY  = 50;
	
	int playerArmX  = 12;
	int playerArmY  = 35;
	
	int playerLegX  = 12;
	int playerLegY  = 35;
	
	BufferedImage image;


	public player(int curX, int curY)
	{
		x=curX;
		y=curY;
		isAlive =  true;
	}
	
	public void update()
	{
		if(isAlive)
		{
			input(x,y);
		}
	}
	
	public void render(Screen screen)
	{
		
		screen.renderPlayer(x, y, Sprite.tempPlayer);
	}
	
	public void input(int curX,int curY)
	{
		if(keyHandler.isPressed(keyHandler.RIGHT))
		{
			move(x+moveSpeed,curY-moveSpeed);
		}
		if(keyHandler.isPressed(keyHandler.UP))
		{
			move(curX,curY-moveSpeed);
			
		}
		if(keyHandler.isPressed(keyHandler.DOWN))
		{
			move(curX,curY+moveSpeed);
		}
		if(keyHandler.isPressed(keyHandler.LEFT))
		{
			move(curX-moveSpeed,curY);
		}
		if(keyHandler.isPressed(keyHandler.RIGHT))
		{
			move(x+moveSpeed,curY);
		}
	}
	
	public void move(int nextX,int nextY)//use this later
	{
		if(nextX>0)
		{
			dir=1;
		}
		if(nextX<0)
		{
			dir=3;
		}
		if(nextY>0)
		{
			dir=2;
		}
		if(nextY>0)
		{
			dir=0;
		}
		
		if(!collison())
		{
			x = nextX;
			y = nextY;
		}
	}
	
	
	public boolean collison()
	{
		return false;
	}
	
	
}
