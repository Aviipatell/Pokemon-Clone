/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ScoreBoard extends JFrame{
	//class body
	
	//declare variables i might need
	public static int score = 0;
	public String scoreFileName = "userScores.txt";
	public String usersFileName = "users.txt";
	static ArrayList<Integer> orgScoresList = new ArrayList<Integer>();
	static ArrayList<String> orgUserList = new ArrayList<String>();
	static ArrayList<Integer> newScoresList = new ArrayList<Integer>();
	static ArrayList<String> newUserList = new ArrayList<String>();
	public int terminate;
	
	/**
	 * Constructor for scoreBoard
	 * @param terminate - int
	 * @throws IOException
	 */
	public ScoreBoard(int terminate) throws IOException
	{	
		super("ScoreBoard");
		this.terminate = terminate;
		BackgroundPanel bp = new BackgroundPanel(4);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		JLabel sb = new JLabel("ScoreBoard");
		sb.setFont(new Font("PKMN RBYGSC", Font.BOLD, 35));
		sb.setBounds(350,50,380,50);
		sb.setForeground(Color.WHITE);
		//sb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		JPanel scoreList = new JPanel();
		scoreList.setLayout(null);
		scoreList.setBounds(230, 125, 560, 450);
		scoreList.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		scoreList.setOpaque(false);
		scoreList.setAutoscrolls(true);
		
		System.out.println("TEST");
		
		transferTop10();
		
		ArrayList<JLabel> scoresArrList = new ArrayList<JLabel>();
		
		Scanner score10File = new Scanner(new File("userScoresTop10.txt"));
		Scanner user10File = new Scanner(new File("usersTop10.txt"));
		
		String curUser = "";
		int curScore = 0;
				
		for (int i = 0; i < 5 && score10File.hasNextLine(); i++)
		{
			curUser = user10File.nextLine();
			curScore = score10File.nextInt(); 
			
			scoresArrList.add(new JLabel((i+1) + ": " + curUser + " -- " + curScore, SwingConstants.CENTER));
			scoresArrList.get(i).setBounds(20,i * 75 + 50,540,50);
			scoresArrList.get(i).setFont(new Font("PKMN RBYGSC", Font.PLAIN, 20));
			scoresArrList.get(i).setForeground(Color.WHITE);
			
			scoreList.add(scoresArrList.get(i));
		}
		
		JButton okBtn = new JButton("Ok");
		formatButton(okBtn);
		okBtn.setBounds(420,600, 200,50);
		
		okBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if (terminate == 1)
				{
					new MainMenu();
					dispose();
				}
				else
				{
					//terminate system
					System.exit(0);
				}
			}
		}
		);
		
		bp.add(sb);
		bp.add(scoreList);
		//bp.add(viewScores);
		bp.add(okBtn);
		
		add(bp);
		setSize(1020, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * method to sort the arrays and transfer top 5 to a new file which will then be accessed using the rest of the code in ScoreBoard()
	 * @throws IOException
	 */
	public void transferTop10() throws IOException
	{
		String userfile = "usersTop10.txt";
		String scoreFile = "userScoresTop10.txt";
		
		orgUserList = new ArrayList<String>();
		orgScoresList = new ArrayList<Integer>();
		
		newUserList = new ArrayList<String>();
		newScoresList = new ArrayList<Integer>();
		
		Scanner orgUser = new Scanner(new File("users.txt"));
		Scanner orgScores = new Scanner(new File("userScores.txt"));
		
		String curLine = "";
		
		while(orgUser.hasNextLine())
		{
			curLine = orgUser.nextLine();
			orgUserList.add(curLine);
		}
		
		while(orgScores.hasNextLine())
		{
			curLine = orgScores.nextLine();
			orgScoresList.add(Integer.parseInt(curLine));
		}
		
		MergeSort ms = new MergeSort(orgScoresList, orgUserList);

		ms.sortGivenArray();
		
		int siz = orgScoresList.size();
		
		if (siz > 0)
		{
			for (int i = siz - 1; (i >= (siz - 5) && siz >= 0 && (siz-5) >= 0); i--)
			{
				System.out.println(orgScoresList.size());
				//System.out.println(orgScoresList.size());
				
				newScoresList.add(orgScoresList.get(i));
				//System.out.println("test");
				newUserList.add(orgUserList.get(i));
			}
			
			/*for(int i = 0; i < newScoresList.size(); i++)
			{
				System.out.println(newScoresList.get(i));
			}
			
			for(int i = 0; i < newUserList.size(); i++)
			{
				System.out.println(newUserList.get(i));
			}*/
			
			PrintWriter writerToScores = new PrintWriter(new FileWriter(scoreFile));
			writerToScores.print("");
			//System.out.println("Writing..");		
			
			for (int i = 0; i < newScoresList.size(); i++)
			{
				writerToScores.println(newScoresList.get(i));
			}
				
			writerToScores.close();
			
			PrintWriter writerToUsers = new PrintWriter(new FileWriter(userfile));
			writerToUsers.print("");
			//System.out.println("Writing..");		
			
			for (int i = 0; i < newUserList.size(); i++)
			{
				writerToUsers.println(newUserList.get(i));
			}
				
			writerToUsers.close();
		}
	}
	
	/**
	 * Main Method
	 * @param args - String[]
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		new ScoreBoard(0);
		
		/*System.out.println("---------Initial Unsorted Shit---------");
        for(int i = 0; i < orgScoresList.size(); i++){
            System.out.println(orgScoresList.get(i) + ":      " + orgUserList.get(i));
        }*/
		
		MergeSort ms = new MergeSort(orgScoresList, orgUserList);
		
		ms.sortGivenArray();
		
		/*System.out.println("\n------------Sorted Array------------");
		for(int i = 0; i < ms.getSortedScoresArray().size(); i++){
            System.out.println(ms.getSortedScoresArray().get(i) + ":      " + ms.getSortedNamesArray().get(i));
        }*/
		
		
	}
	
	/**
	 * method to format Jbutton
	 * @param b - JButton
	 */
	public void formatButton(JButton b)
	{
		b.setFont(new Font("PKMN RBYGSC", Font.BOLD, 20));
		b.setForeground(Color.BLACK);
	}
	
}
