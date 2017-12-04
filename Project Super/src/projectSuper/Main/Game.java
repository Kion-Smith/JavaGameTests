package projectSuper.Main;

import javax.swing.JFrame;

public class Game 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Project Super");
		
		frame.add(new GamePanel());
		frame.setResizable(true);
		
		frame.setVisible(true);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
