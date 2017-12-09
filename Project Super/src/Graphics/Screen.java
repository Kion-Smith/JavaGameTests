package Graphics;

public class Screen 
{
	private int width,height;
	public int[] pixels;
	
	public Screen(int w,int h)
	{
		width = w;
		height =h;
		
		pixels = new int[height *width];
	}
}
