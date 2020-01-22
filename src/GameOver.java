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
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOver extends JFrame{
	//class body
	
	/**
	 * Contstructor to GameOver
	 * @param winOrLoseNum - int
	 */
	public GameOver(int winOrLoseNum)
	{
		super("Game Over");
		
		BackgroundPanel bp = new BackgroundPanel(4);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		JLabel gO = new JLabel("Game Over");
		gO.setFont(new Font("PKMN RBYGSC", Font.BOLD, 100));
		gO.setBounds(100,200,1020,200);
		gO.setForeground(Color.WHITE);
		
		JButton cont = new JButton("Continue");
		formatButton(cont);
		cont.setBounds(405,400,200,50);
		
		cont.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try {
					new ScoreBoard(0);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		}
		);
		
		JLabel winOrLose = new JLabel();
		
		if (winOrLoseNum == 1)
		{
			winOrLose.setText("CONGRATULATIONS! YOU'VE MADE IT TO THE EXIT!");
		}
		else
		{
			winOrLose.setText("OH NO! YOU'VE LOST!");
		}
		formatLabel(winOrLose);
		winOrLose.setBounds(100, 100, 800, 80);
		
		bp.add(gO);
		bp.add(cont);
		bp.add(winOrLose);
		
		add(bp);
		setSize(1020, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * method to format JButton
	 * @param b - JButton
	 */
	public void formatButton(JButton b)
	{
		b.setFont(new Font("PKMN RBYGSC", Font.BOLD, 20));
		b.setForeground(Color.BLACK);
	}
	
	/**
	 * method to format JLabel
	 * @param l - JLabel
	 */
	public void formatLabel(JLabel l)
	{
		l.setFont(new Font("PKMN RBYGSC", Font.BOLD, 20));
		l.setForeground(Color.WHITE);
	}
	
}
