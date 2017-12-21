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
	int moveSpeed = 3;

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
		int xx = x-16;
		int yy = y-16;
		screen.renderPlayer(xx, yy, Sprite.tempPlayer);
		screen.renderPlayer(xx+16, yy, Sprite.tempPlayer2);
		screen.renderPlayer(xx, yy+16, Sprite.tempPlayer3);
		screen.renderPlayer(xx+16, yy+16, Sprite.tempPlayer4);
	}
	
	public void input(int curX,int curY)
	{
		if((keyHandler.isPressed(keyHandler.UP,keyHandler.RIGHT)))//up right
		{
			move(curX+moveSpeed,curY-moveSpeed);
		}
		else if((keyHandler.isPressed(keyHandler.UP,keyHandler.LEFT)))//up left
		{
			move(curX-moveSpeed,curY-moveSpeed);
		}
		else if((keyHandler.isPressed(keyHandler.DOWN,keyHandler.RIGHT)))// down right
		{
			move(curX+moveSpeed,curY+moveSpeed);
		}
		else if((keyHandler.isPressed(keyHandler.DOWN,keyHandler.LEFT))) //down left
		{
			move(curX-moveSpeed,curY+moveSpeed);
		}
		else if(keyHandler.isPressed(keyHandler.UP))
		{
			move(curX,curY-moveSpeed);
		}
		else if(keyHandler.isPressed(keyHandler.DOWN))
		{
			move(curX,curY+moveSpeed);
		}
		else if(keyHandler.isPressed(keyHandler.LEFT))
		{
			move(curX-moveSpeed,curY);
		}
		else if(keyHandler.isPressed(keyHandler.RIGHT))
		{
			move(curX+moveSpeed,curY);
		}/**/
		
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
			
			System.out.println("X is "+x+" Y is "+ y);
		}
	}
	
	
	public boolean collison()
	{
		return false;
	}
	
	
}
