package projectSuper.graphics;


public class Sprite 
{
	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private spriteSheet sheet;
	
	
	public static Sprite ground1 = new Sprite(16,0,0,spriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0x4286f4);//use the hex
	
	public static Sprite temp = new Sprite(16,4,0,spriteSheet.tiles);
	
	public static Sprite tempPlayerHead = new Sprite(32,4,0,spriteSheet.tiles);
	public static Sprite tempPlayerBody = new Sprite(32,4,1,spriteSheet.tiles);
	public static Sprite tempPlayerLeg = new Sprite(32,4,2,spriteSheet.tiles);
	
	public static Sprite tempPlayerFlyingBody = new Sprite(32,5,1,spriteSheet.tiles);
	public static Sprite tempPlayerFlyingLeg = new Sprite(32,5,2,spriteSheet.tiles);
	
	public static Sprite tempPlayerFallingBody = new Sprite(32,6,1,spriteSheet.tiles);
	public static Sprite tempPlayerFallingLeg = new Sprite(32,6,2,spriteSheet.tiles);
	
	public static Sprite tempPlayerWalkingLeg = new Sprite(32,4,3,spriteSheet.tiles);


	
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
