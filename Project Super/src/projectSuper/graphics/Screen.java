package projectSuper.graphics;

import java.util.Random;

//pixel manipulation class
public class Screen 
{
	private int width,height; //size of screen
	public int[] pixels; //array for pixels on screen, single array because its faster than using a 2d array
	public final int MAPSIZE = 64;
	public final int MAPSIZEMASK = MAPSIZE-1;
	public int[] tiles = new int[MAPSIZE*MAPSIZE];
	private Random random = new Random();
	
	
	public Screen(int w,int h)
	{
		width = w;
		height =h;
		
		pixels = new int[width * height]; // all pixels on the screen 921,600
		
		for(int i =0;i<MAPSIZE*MAPSIZE;i++)
		{
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render(int xOffset,int yOffset)
	{
		
		for(int i =0;i<height;i++) // going to loop through the cols
		{
			int y =i+yOffset;
			
			for(int j = 0;j<width;j++) //looping through the row at the col
			{
				int x =j+xOffset;
				int tileIndex = ((x>>4)&MAPSIZEMASK)+((y>>4)&MAPSIZEMASK) * MAPSIZE; // same as (j||i) /16 by use of bitwise operators
				//pixels[j + i* width] =  tiles[tileIndex];// because this is single dimension array so looks for position needs to offset by the width
				pixels[j + i* width] =  Sprite.ground1.pixels[(j&15)+(i&15)*Sprite.ground1.SIZE];
			}
		}

	}
	
	public void clear()
	{
		for(int i =0;i<pixels.length;i++)
		{
			pixels[i] = 0;
		}
	}
}
