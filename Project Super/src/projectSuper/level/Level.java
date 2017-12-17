package projectSuper.level;

import projectSuper.graphics.Screen;
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
		
	}
}
