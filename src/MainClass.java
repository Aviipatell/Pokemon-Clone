/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import javax.swing.*;

//extend JFrame
public class MainClass extends JFrame{
	//class body
	
	/**
	 * constructor for main class which will be called to start a new game
	 */
	public MainClass()
	{
		//name JFrame
		super("PokemonWorld");
		
		//JFrame properties
		pack();
		setSize(1020, 750);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Game());
		setVisible(true); 
	}
	
	/**
	 * Main method to call the constructor
	 * @param args - String[]
	 */
	public static void main(String[] args)
	{
		MainClass mC = new MainClass();
	}
	
	
	
}
