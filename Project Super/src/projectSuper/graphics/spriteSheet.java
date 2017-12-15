package projectSuper.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class spriteSheet 
{
	private String path;
	private final int SIZE;
	public int[] pixels;
	
	public spriteSheet(String p,int size)
	{
		path = p;
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		load();
	}
	
	private void load()
	{
		try 
		{
			BufferedImage image = ImageIO.read(spriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			
			image.getRGB(0, 0,w,h,pixels,0,w);//turns loadedImage into pixels
			
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}
	
}
