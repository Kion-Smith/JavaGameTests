package projectSuper.gameStates;

import java.awt.Graphics2D;


public class gameStateManager 
{
	
		private boolean paused;
		
		private gameState[] gS;
		private int curState;
		private int prevState;
		
		public static final int numStates = 4;
		public static final int MENU = 0;
		public static final int PLAY = 1;
		public static final int HELP = 2;
		public static final int GAMEOVER = 3;
		
		public gameStateManager()
		{
			paused = false;
			
			gS = new gameState[numStates];
			
			setState(MENU);
		}
		
		public void setState(int i)
		{
			prevState = curState;
			unloadState(prevState);
			curState = i;
			
			//add states
		}
		
		public void unloadState(int i)
		{
			gS[i] = null;
		}
		
		public void setPaused(boolean b)
		{
			paused = b;
		}
		
		public void update()
		{
		
			if(!paused)
			{
				gS[curState].update();
			}

		}
		
		public void draw(Graphics2D g)
		{

			if(!paused)
			{
				gS[curState].draw(g);
			}

		}
		
	

}
