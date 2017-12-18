package projectSuper.level.tiles;

import projectSuper.graphics.Screen;
import projectSuper.graphics.Sprite;

public class ground1Tile extends Tile
{

	public ground1Tile(Sprite s) 
	{
		super(s);
	}
	
	public void render(int locX,int locY,Screen s)
	{
		s.renderTiles(locX << 4,locY << 4,this);
	}

}
