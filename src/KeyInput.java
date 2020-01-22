/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	//class body
	
	//declare variables
	Player p;
	
	/**
	 * Method to assign KeyInput constraints to Player to keep reading keyInput when player is on
	 * @param p - Player
	 */ 
	public KeyInput(Player p)
	{
		this.p = p;
	}
	
	/**
	 * Method to be called when a keyIsPressed and assign it to player
	 * @param e = KeyEvent
	 */
	public void keyPressed(KeyEvent e)
	{
		p.keyPressed(e);
	}
	
	/**
	 * Method to be called when a keyIsReleased and assign it to player
	 * @param e - KeyEvent
	 */
	public void keyReleased(KeyEvent e)
	{
		p.keyReleased(e);
	}
}
