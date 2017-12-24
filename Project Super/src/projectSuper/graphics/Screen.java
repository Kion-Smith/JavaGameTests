package projectSuper.graphics;

import java.util.Random;

import projectSuper.level.tiles.Tile;
import projectSuper.player.player;

//pixel manipulation class
public class Screen 
{
	public int width,height; //size of screen
	public int[] pixels; //array for pixels on screen, single array because its faster than using a 2d array
	public final int MAPSIZE = 64;
	public final int MAPSIZEMASK = MAPSIZE-1;
	public int[] tiles = new int[MAPSIZE*MAPSIZE];
	private Random random = new Random();
	
	public int xOffset,yOffset;
	
	
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
	/*
	public void render(int xOffset,int yOffset)
	{
		
		for(int i =0;i<height;i++) // going to loop through the cols
		{
			int yp = i+yOffset;
			if(yp<0|| yp>= height)
			{
				continue;
			}
			
			for(int j = 0;j<width;j++) //looping through the row at the col
			{
				int xp = j+xOffset;
				if(xp<0|| xp>= width)
				{
					continue;
				}
				
				pixels[(xp) + (yp)* width] =  Sprite.ground1.pixels[(i&15)+(j&15)*Sprite.ground1.SIZE];
			}
		}

	}*/
	//only works for squares might want to change later
	public void renderTiles(int xPos,int yPos,Tile tile)
	{
		xPos -= xOffset;
		yPos -= yOffset;
		for(int i=0;i<tile.sprite.SIZE;i++)
		{
			int ya = i+yPos;
			
			for(int j=0;j<tile.sprite.SIZE;j++)
			{
				int xa = j+xPos;
				
				if(xa<-tile.sprite.SIZE || xa>= width || ya<0 || ya>= height)//prevent using up resources and index out of bounds
				{
					break;
					
				}

				if(xa< 0)
				{
					xa =0;
				}
				pixels[xa+ya*width] = tile.sprite.pixels[j+i*tile.sprite.SIZE];
				
			}
			
		}
	}
	public void renderPlayer(int xPos, int yPos,Sprite s,boolean flip,int size)
	{
		
		xPos -= xOffset;
		yPos -= yOffset;
		for(int i=0;i<size;i++)
		{
			int ya = i+yPos;
			int ys = i;
			for(int j=0;j<size;j++)
			{
				int xa = j+xPos;
				int xs;
				if(flip != true)
				{
					xs = j;
				}
				else
				{
					xs =31-j;
				}
				if(xa<-32 || xa>= width || ya<0 || ya>= height)//prevent using up resources and index out of bounds
				{
					break;
					
				}

				if(xa< 0)
				{
					xa =0;
				}
				int col = s.pixels[xs+ys*size];
				if(col != 0xffffff)// only works to get rid or png transperent background even though it should work with every color
				{
					pixels[xa+ya*width] = col;
					
				}
				
			}
			
		}
	}
	
	public void setOffset(int xOff,int yOff)
	{
		xOffset = xOff;
		yOffset = yOff;
	}
	
	public void clear()
	{
		for(int i =0;i<pixels.length;i++)
		{
			pixels[i] = 0;
		}
	}
	
}
