package projectSuper.level;

import projectSuper.graphics.Screen;
import projectSuper.level.tiles.Tile;
//change to public abstract
public class Level 
{
	protected int width,height;
	protected int[] tiles;
	
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
	
	protected void generateLevel()
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
		screen.setOffset(xScroll, yScroll);//offset based on player
		int x0 = xScroll >> 4; // divided by 16(size of tile)
		int x1 =( xScroll+screen.width) >> 4;	
		int y0 = yScroll >> 4; // divided by 16(size of tile)
		int y1 =( yScroll+screen.height) >> 4;
		
		for(int row = y0;row<y1;row++)
		{
			for(int cols = x0;cols<x1;cols++)
			{
				getTile(cols,row).render(cols,row,screen);
			}
		}
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
