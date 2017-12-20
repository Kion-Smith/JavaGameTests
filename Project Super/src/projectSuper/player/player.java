package projectSuper.player;

import java.awt.image.BufferedImage;

import projectSuper.input.keyHandler;

public class player
{

	//maybe make a abstract parent for mobs/entities?
	boolean isAlive;
	boolean isHero;
	boolean isWalking;
	boolean isFlying;

	
	int power;
	int health;
	int workpoints;
	
	public int x,y;

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
			input();
		}
	}
	
	public void render()
	{
		
	}
	
	public void input()
	{
		if(keyHandler.isPressed(keyHandler.UP))
		{
			y--;
		}
		if(keyHandler.isPressed(keyHandler.DOWN))
		{
			y++;
		}
		if(keyHandler.isPressed(keyHandler.LEFT))
		{
			x--;
		}
		if(keyHandler.isPressed(keyHandler.RIGHT))
		{
			x++;
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
			x+= nextX;
			y+=nextY;
		}
	}
	
	
	public boolean collison()
	{
		return false;
	}
	
	
}
