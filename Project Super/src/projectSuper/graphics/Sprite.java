package projectSuper.graphics;


public class Sprite 
{
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private spriteSheet sheet;
	
	
	public static Sprite ground1 = new Sprite(16,0,0,spriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0x4286f4);//use the hex
	
	public static Sprite tempPlayer = new Sprite(16,1,0,spriteSheet.tiles);	
	public static Sprite tempPlayer2 = new Sprite(16,2,0,spriteSheet.tiles);
	public static Sprite tempPlayer3 = new Sprite(16,3,0,spriteSheet.tiles);
	public static Sprite tempPlayer4= new Sprite(16,4,0,spriteSheet.tiles);

	
	public Sprite(int size,int col,int row,spriteSheet s)
	{
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		x = col*size;
		y=row*size;
		sheet = s;
		load();
	}
	//for void tiles
	public Sprite(int size,int color)
	{
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void load()
	{
		for(int i =0;i<SIZE;i++)
		{
			for(int j =0;j<SIZE;j++)
			{
				pixels[j+i*SIZE] = sheet.pixels[(j+x)+ (i+y)*sheet.SIZE];
			}
		}
	}
	
	public void setColor(int color)
	{
		for(int i =0;i<SIZE*SIZE;i++)
		{
			pixels[i]= color;
		}
	}
}
