package projectSuper.gameStates;

import java.awt.Graphics;



public class gameStateManager 
{
	
		private boolean paused;
		
		private gameState[] gS;
		private int curState;
		private int prevState;
		
		public static final int numStates = 4;
		public static final int MAINMENU = 0;
		public static final int PLAY = 1;
		public static final int MENU = 2;
		public static final int GAMEOVER = 3;
		//add more as needed
		
		public gameStateManager()
		{
			paused = false;
			
			gS = new gameState[numStates];
			
			setState(MAINMENU);
		}
		
		public void setState(int i)
		{
			prevState = curState;
			unloadState(prevState);
			curState = i;
			if(i == MAINMENU)
			{
				gS[i] = new mainMenuState(this);
				gS[i].init();
			}
			else if(i == PLAY)
			{
				gS[i] = new playState(this);
				gS[i].init();
			}
			else if( i == MENU)
			{
				gS[i] = new menuState(this);
				gS[i].init();
			}
			else if (i== GAMEOVER)
			{
				gS[i] = new gameOverState(this);
				gS[i].init();
			}
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
			else if(gS[curState] != null)
			{
				gS[curState].update();
			}
		}
		
		public void draw(Graphics g)
		{

			if(!paused)
			{
				gS[curState].draw(g);
			}
			else if(gS[curState] != null)
			{
				gS[curState].draw(g);
			}

		}
		
	

}
