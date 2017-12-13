package Graphics;

import java.util.Random;

//pixel manipulation class
public class Screen 
{
	private int width,height; //size of screen
	public int[] pixels; //array for pixels on screen, single array because its faster than using a 2d array
	
	public int[] tiles = new int[64*64];
	private Random random = new Random();
	
	
	public Screen(int w,int h)
	{
		width = w;
		height =h;
		
		pixels = new int[width * height]; // all pixels on the screen 921,600
		
		for(int i =0;i<64*64;i++)
		{
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render()
	{
		
		for(int i =0;i<height;i++) // going to loop through the cols
		{
			int y =i;
			
			for(int j = 0;j<width;j++) //looping through the row at the col
			{
				int x =j;
				int tileIndex = ((x>>4)&63)+((y>>4)&63) * 64; // same as (j||i) /16 by use of bitwise operators
				//System.out.println(tiles[tileIndex]);
				pixels[j + i* width] =  tiles[tileIndex];// because this is single dimension array so looks for position needs to offset by the width
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
