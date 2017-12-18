package projectSuper.level.tiles;

import projectSuper.graphics.Screen;
import projectSuper.graphics.Sprite;

public class voidTile extends Tile 
{

	public voidTile(Sprite s) 
	{
		super(s);
		
	}
	
	public void render(int locX,int locY,Screen s)
	{
		s.renderTiles(locX,locY,this);
	}

}
