package projectSuper.level.tiles;

import projectSuper.graphics.Screen;
import projectSuper.graphics.Sprite;

public class Tile 
{
	public int x, y;
	public Sprite sprite;
	
	public static Tile ground1 = new ground1Tile(Sprite.ground1);//only one object
	public static Tile voidTile = new voidTile(Sprite.voidSprite);
	//public static Tile voidTile = new voidTile(Sprite.voidSprite);
	
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
