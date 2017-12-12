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
		
		pixels = new int[width * height]; // all pixels on the screen
		
		for(int i =0;i<64*64;i++)
		{
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render()
	{
		
		for(int i =0;i<height;i++) // going to loop through the cols
		{
			for(int j = 0;j<width;j++) //looping through the row at the col
			{
				int tileIndex = (j/32)+(i/32) *64;
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
