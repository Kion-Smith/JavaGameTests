package projectSuper.input;

import java.awt.event.KeyEvent;


public class keyHandler 
{

		public static int UP = 0;
		public static int DOWN = 1;
		public static int LEFT = 2;	
		public static int RIGHT = 3;
		public static int ENTER = 4;
		public static int ESC = 5;
		
		
		public static final int keys = 6;
		
		public static boolean keyState[] = new boolean[keys];
		public static boolean prevKeyState[] = new boolean[keys];
		
		public static void keySet(int i,boolean b)
		{
			if(i == KeyEvent.VK_UP)
			{
				keyState[UP] = b;
			}
			else if(i == KeyEvent.VK_DOWN)
			{
				keyState[DOWN] = b;
			}
			else if(i == KeyEvent.VK_LEFT )
			{
				keyState[LEFT] = b;
			}
			else if(i == KeyEvent.VK_RIGHT )
			{
				keyState[RIGHT] = b;
			}
			else if(i == KeyEvent.VK_ENTER)
			{
				keyState[ENTER] = b;
			}
			else if(i == KeyEvent.VK_ESCAPE)
			{
				keyState[ESC] = b;
			}
		
		}
		
		public static void update()
		{
			for(int i = 0;i<keys;i++)
			{
				prevKeyState[i] = keyState[i];
			}
		}
		public static boolean isPressed(int i) 
		{
		//	return keyState[i] && !prevKeyState[i];
			if(keyState[i] )
			{
				return true;
			}
			return false;
		}
		public static boolean isPressed(int i, int j) 
		{
		//	return keyState[i] && !prevKeyState[i];
			if(keyState[i] && keyState[j])
			{
				return true;
			}
			return false;
		}
		public static boolean anyKeyDown() 
		{
			for(int i = 0; i < keys; i++)
			{
				if(keyState[i]) 
				{
					return true;
				}
			}
			return false;
		}

}
