/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions extends JFrame{
	//class body
	
	/**
	 * Constructor for instructions
	 */
	public Instructions()
	{
		super("How To Play");
		
		BackgroundPanel bp = new BackgroundPanel(4);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		String instructions1 = "How to Win: Defeat all 5 Pokemon Trainers and Make it Past the StairCase.";
		String instructions2 = "Score: Based on the number of trainers you successfully defeat.";
		String instructions3 = "If you make it past the stairs, the remaining health of your pokemons/2 will be added to your score.";
		String instructions4 = "Battle: Go up to a trainer, face them and then click enter.";
		String instructions5 = "Bag: Open bag by pressing space bar. May the best trainer win!";

		
		JLabel title = new JLabel("How To Play:");
		title.setBounds(100,100,300,50);
		title.setFont(new Font("PKMN RBYGSC", Font.BOLD, 22));
		title.setForeground(Color.WHITE);
		
		JLabel howToPlay1 = new JLabel(instructions1);
		howToPlay1.setBounds(100,200,800,50);
		howToPlay1.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		howToPlay1.setForeground(Color.WHITE);
		
		JLabel howToPlay2 = new JLabel(instructions2);
		howToPlay2.setBounds(100,275,800,50);
		howToPlay2.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		howToPlay2.setForeground(Color.WHITE);
		
		JLabel howToPlay3 = new JLabel(instructions3);
		howToPlay3.setBounds(100,350,800,50);
		howToPlay3.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		howToPlay3.setForeground(Color.WHITE);
		
		JLabel howToPlay4 = new JLabel(instructions4);
		howToPlay4.setBounds(100,425,800,50);
		howToPlay4.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		howToPlay4.setForeground(Color.WHITE);
		
		JLabel howToPlay5 = new JLabel(instructions5);
		howToPlay5.setBounds(100,500,800,50);
		howToPlay5.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		howToPlay5.setForeground(Color.WHITE);
		
		JButton back = new JButton("Back");
		formatButton(back);
		back.setBounds(400,600,200,50);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				new MainMenu();
				dispose();
				//f.dispose();
			}
		}
		);
		
		bp.add(title);
		bp.add(howToPlay1);
		bp.add(howToPlay2);
		bp.add(howToPlay3);
		bp.add(howToPlay4);
		bp.add(howToPlay5);
		bp.add(back);
		
		add(bp);
		setSize(1020, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * method to format the JButton
	 * @param btn - JButton
	 */
	public void formatButton(JButton btn)
	{
		btn.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		//btn.setBounds(325,200,500,50); 
		btn.setForeground(Color.BLACK);
	}
	
	/**
	 * Main method
	 * @param args - String[]
	 */
	public static void main(String[] args)
	{
		new Instructions();
	}

}
