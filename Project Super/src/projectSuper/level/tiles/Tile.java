package projectSuper.level.tiles;

import projectSuper.graphics.Screen;
import projectSuper.graphics.Sprite;

public class Tile 
{
	public int x, y;
	public Sprite sprite;
	
	public static Tile ground = new ground1Tile(Sprite.ground1);//only one object
	
	
	public Tile(Sprite s) 
	{
		sprite = s;
	}
	
	public void render(int locX, int locY, Screen s) 
	{	
		
	}
	
	public boolean solid() //is a solid object
	{
		return false;
	}
}
