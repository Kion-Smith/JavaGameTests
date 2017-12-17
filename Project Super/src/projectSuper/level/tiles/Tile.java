package projectSuper.level.tiles;

import projectSuper.graphics.Screen;
import projectSuper.graphics.Sprite;

public class Tile 
{
	public int x, y;
	public Sprite sprite;
	
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
