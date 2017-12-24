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
	boolean isFalling;
	
	boolean isLeft;
	boolean isRight;
	
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
		isFlying = false;
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
		/*
		screen.renderPlayer(xx, yy, Sprite.tempPlayer);
		screen.renderPlayer(xx+16, yy, Sprite.tempPlayer2);
		screen.renderPlayer(xx, yy+16, Sprite.tempPlayer3);
		screen.renderPlayer(xx+16, yy+16, Sprite.tempPlayer4);
		*/
		
		if(!isFlying && isFalling)
		{
			if(isRight && !isLeft)
			{
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,false,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerFallingBody,false,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerFallingLeg,false,32);
			}
			else if(isLeft && !isRight)
			{
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,true,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerFallingBody,true,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerFallingLeg,true,32);
			}
			else
			{
				isRight = true;
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,false,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerFallingBody,false,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerFallingLeg,false,32);
			}
		}
		if(!isFlying && !isFalling)
		{
			if(isRight && !isLeft)
			{
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,false,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerBody,false,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerLeg,false,32);
			}
			else if(isLeft && !isRight)
			{
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,true,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerBody,true,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerLeg,true,32);
			}
			else
			{
				isRight = true;
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,false,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerBody,false,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerLeg,false,32);
			}
		}
		else if(isFlying)
		{
			
		
			
			if(isRight && !isLeft)
			{
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,false,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerFlyingBody,false,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerFlyingLeg,false,32);
			}
			else if(isLeft && !isRight)
			{
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,true,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerFlyingBody,true,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerFlyingLeg,true,32);
			}
			else
			{
				isRight = true;
				screen.renderPlayer(x-16, y-16, Sprite.tempPlayerHead,false,32);
				screen.renderPlayer(x-16, y+16, Sprite.tempPlayerFlyingBody,false,32);
				screen.renderPlayer(x-16, y+48, Sprite.tempPlayerFlyingLeg,false,32);
			}
			
		}

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
		}
		
	}
	
	public void move(int nextX,int nextY)//use this later
	{
		
		if(!collison())
		{
			if(nextX>x)
			{
				isRight = true;
				isLeft = false;
			}
			else if(nextX<x)
			{
				isLeft = true;
				isRight = false;
			}
			
			if(nextY<y)
			{
				isFlying = true;
				isFalling= false;
			}
			else
			{
				
				isFalling =true;
				isFlying = false;
				
			}
			
			x = nextX;
			y = nextY;
			
		}
	}
	
	
	public boolean collison()
	{
		return false;
	}
	
	
}
