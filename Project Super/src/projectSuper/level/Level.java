package projectSuper.level;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

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
		URL loc = this.getClass().getResource(path);
		File file = new File(loc+"");
		int count=0;
		String tempString ="";
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			try 
			{
			
				while(br.readLine() != null)
				{
					if(count == 0)
					{
						width = Integer.parseInt(br.readLine());
					}
					else if(count == 1)
					{
						height = Integer.parseInt(br.readLine());
						tiles = new int[width*height];
					}
					else if(count != 2)
					{
						for(int i = 0;i<br.readLine().length();i++)
						{
							 tempString = br.readLine().charAt(i)+"";
							 tiles[i+(count-3)*width] = Integer.parseInt(tempString);
						}
					}
					
					count++;
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println();
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
		int x1 =( xScroll+screen.width+16) >> 4;	//the extra 16 is for the next pixel
		//y's
		int y0 = yScroll >> 4; // divided by 16(size of tile)
		int y1 =( yScroll+screen.height+16) >> 4;
		
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
		//out of bounds
		if(locX <0 || locY <0 || locX>= width || locY>=height)
		{
			return Tile.voidTile;
		}
		if(tiles[locX+locY*width]==0)// at loc 0,0
		{
			return Tile.ground1;
		}
		return Tile.voidTile;//empty tile
	}
}
