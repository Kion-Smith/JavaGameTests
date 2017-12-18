package projectSuper.level;

import projectSuper.graphics.Screen;
import projectSuper.level.tiles.Tile;
//change to public abstract
public class Level 
{
	private int width,height;
	private int[] tiles;
	
	public Level(int w,int h)
	{
		width = w;
		height = h;
		tiles = new int[width*height];
		generateLevel();
	}
	
	public Level(String path)
	{
		loadLevel(path);
	}
	
	public void generateLevel()
	{
		
	}
	
	private void loadLevel(String path)
	{
		
	}
	
	public void update()
	{
		
	}
	private void time()
	{
		
	}
	public void render(int xScroll,int yScroll,Screen screen)
	{
		//pinned corners to define the regions being render to screen
		int x0 = xScroll >> 4; // divided by 16(size of tile)
		int x1 =( xScroll+screen.width) >> 4;	
		int y0 = xScroll >> 4; // divided by 16(size of tile)
		int y1 =( xScroll+screen.height) >> 4;
	}
	
	public Tile getTile(int locX,int locY)
	{
		if(tiles[locX+locY*width]==0)// at loc 0,0
		{
			return Tile.ground1;
		}
		return Tile.voidTile;//empty tile
	}
}
