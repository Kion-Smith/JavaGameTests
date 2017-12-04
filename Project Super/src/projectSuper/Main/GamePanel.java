package projectSuper.Main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel 
{
	/**Look into this
	 * 
	 */
	private static final long serialVersionUID = -5137492406301131554L;

	public GamePanel()
	{
		setPreferredSize(new Dimension(1920,1080));// need to make this a variable that can be changed
		requestFocus(true);
		setFocusable(true);
	}
}
