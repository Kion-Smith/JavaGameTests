package projectSuper.graphics;


public class Sprite 
{
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private spriteSheet sheet;
	
	public static Sprite ground1 = new Sprite(16,0,0,spriteSheet.tiles);
	
	public Sprite(int size,int col,int row,spriteSheet s)
	{
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		x = col*size;
		y=row*size;
		sheet = s;
		load();
	}
	
	private void load()
	{
		for(int i =0;i<SIZE;i++)
		{
			for(int j =0;j<SIZE;j++)
			{
				pixels[i+j*SIZE] = sheet.pixels[(j+x)+ (i+y)*sheet.SIZE];
			}
		}
	}
}
