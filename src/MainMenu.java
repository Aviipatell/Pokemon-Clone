/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import javax.imageio.ImageIO;
import sun.audio.*;
import java.io.FileInputStream;
import sun.audio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMenu extends JFrame{
	//class body
	
	//declare variables
	public String background = "/images/homeScreen.png";
	public static int playerChar = 0;
	public static String playerUserName = "";
	
	/**
	 * Constructor or MainMenu
	 */
	public MainMenu()
	{
		//set title of frame
		super("Welcome Player");
		
		//create background panel and rest of the components to be added onto the frame (ex. buttons and stuff i should not lose marks for in-method commenting bc its not written on the java docs thing and haha lmk if you read this given how you'll have only like 2-3 days to mark all these?)
		BackgroundPanel bp = new BackgroundPanel(1);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);

		JButton conf = new JButton("Click Here to Start Your Adventure!");
		conf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				options();
				dispose();
			}
		}
		);
		conf.setPreferredSize(new Dimension(500,50));
		conf.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));

		conf.setBounds(275, 575, 500, 50);
		
		bp.add(conf);
		
		//JFrame properties
		add(bp);
		setSize(1020, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * Method to invoke the JFrame in which the player will be told to select an option
	 */
	public void options()
	{
		//Set title of Jframe
		JFrame f = new JFrame("Select an Option");
		
		BackgroundPanel bp = new BackgroundPanel(2);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		

		ImageIcon icon = new ImageIcon(getClass().getResource("/images/Trio.gif")); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		thumb.setBounds(275, 50, 500, 300);
		
		JButton scoreBoardButton = new JButton("SCOREBOARD");
		scoreBoardButton.setPreferredSize(new Dimension(500,50));
		scoreBoardButton.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		scoreBoardButton.setBounds(275, 600, 500, 50);
		
		scoreBoardButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try {
					new ScoreBoard(1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
				f.dispose();
			}
		}
		);
		
		JButton startGameButton = new JButton("START GAME");
		startGameButton.setPreferredSize(new Dimension(500,50));
		startGameButton.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		startGameButton.setBounds(275, 400, 500, 50);
		startGameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				userNameSelection();
				//new MainClass();
				f.dispose();
			}
		}
		);
		
		JButton instructionsButton = new JButton("HOW TO PLAY");
		instructionsButton.setPreferredSize(new Dimension(500,50));
		instructionsButton.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		instructionsButton.setBounds(275, 500, 500, 50);
		
		instructionsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				new Instructions();				
				f.dispose();
			}
		}
		);
		
		bp.add(thumb);
		bp.add(scoreBoardButton);
		bp.add(startGameButton);
		bp.add(instructionsButton);
		
		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	
	/**
	 * Method to invole a JFrame in which the player will be told to input a userName and will be checked to see if it's already taken and if not, set it to that and then continue..
	 */
	public void userNameSelection()
	{
		
		String userName = "";
		boolean check = false;
		
		JFrame f = new JFrame("Enter a Username");
		
		BackgroundPanel bp = new BackgroundPanel(2);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/Trio.gif")); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		thumb.setBounds(275, 50, 500, 300);
		
		JLabel addUserName = new JLabel("Please enter a Username:");
		addUserName.setFont(new Font("PKMN RBYGSC", Font.BOLD, 20));
		addUserName.setBounds(325,350,500,50);
		//addUserName.setBackground(Color.WHITE);
		addUserName.setForeground(Color.WHITE);
		
		JTextField inputUserName = new JTextField(20);
		inputUserName.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		inputUserName.setBounds(375, 450, 300, 50);
		
		JButton cont = new JButton("Continue");
		cont.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 17));
		cont.setBounds(275,550,500,50);
		cont.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String uName = inputUserName.getText().trim().replaceAll("\\s", "").toLowerCase();
				Boolean c = true;
				try {
					c = checkUserName(uName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (c == false)
				{
					System.out.println("UserName has already been selected.");
					JOptionPane.showMessageDialog(f, "Your username has already been taken. Choose another one.", "Invalid Username", JOptionPane.WARNING_MESSAGE);
					inputUserName.setText("");
					f.repaint();
				}
				else
				{
					try {
						writeUserNameToFile(uName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					playerUserName = uName;
					
					characterSelect();
					f.dispose();
				}
			}
		}
		);
		
		bp.add(thumb);
		bp.add(addUserName);
		bp.add(inputUserName);
		bp.add(cont);
		
		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	/**
	 * Method to check if the userName the player inputed is already taken
	 * @param userName - String
	 * @return boolean
	 * @throws IOException
	 */
	public boolean checkUserName(String userName) throws IOException
	{
		String fileName = "users.txt";
		Scanner file = new Scanner(new File(fileName));
		
		if (userName.equals("clear"))
		{
			Scanner in = new Scanner(System.in);
			PrintWriter writer = new PrintWriter(new FileWriter(fileName));
			writer.print("");
			writer.close();
		}
		
		String curName = "";
		
		while(file.hasNextLine())
		{
			curName = file.nextLine();
			System.out.println(curName);
			
			if (curName.equals(userName))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method to write the players' Username into userName file to prevent others from taking it and for future score keeping
	 * @param userName- String
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void writeUserNameToFile(String userName) throws IOException, FileNotFoundException
	{
		String fileName = "users.txt";
		
		Scanner in = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
		writer.println(userName);
		System.out.println("Writing..");
		writer.close();
		System.out.println("Done Writing..");
	}
	
	/**
	 * Method to invoke a JFrame in which the player will select a character icon that they want to represne / one they want to be represented by (not sexism :))
	 */
	public void characterSelect()
	{
		JFrame f = new JFrame("Select your Character");
		
		BackgroundPanel bp = new BackgroundPanel(2);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		ImageIcon girl = new ImageIcon(getClass().getResource("/images/GIRLCROPPED.gif")); 
		ImageIcon boy1 = new ImageIcon(getClass().getResource("/images/GUY1CROPPED.gif")); 
		ImageIcon boy2 = new ImageIcon(getClass().getResource("/images/GUY2CROPPED.gif")); 

		JLabel chooseYourChar = new JLabel("Select Your Character:");
		chooseYourChar.setFont(new Font("PKMN RBYGSC", Font.BOLD, 20));
		chooseYourChar.setBounds(325,250,500,50);
		//addUserName.setBackground(Color.WHITE);
		chooseYourChar.setForeground(Color.WHITE);
		
		JButton girlButton = new JButton(girl);
		girlButton.setBorder(BorderFactory.createEmptyBorder());
		girlButton.setContentAreaFilled(false);
		girlButton.setBounds(220, 320, 200, 275);
		
		girlButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				playerChar = 3;
				//new MainClass();
				new PokemonParty();
				f.dispose();
			}
		}
		);
		
		JButton boy1Button = new JButton(boy1);
		boy1Button.setBorder(BorderFactory.createEmptyBorder());
		boy1Button.setContentAreaFilled(false);
		boy1Button.setBounds(420, 320, 200, 275);
		
		boy1Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				playerChar = 1;
				new PokemonParty();
				f.dispose();
			}
		}
		);
		
		JButton boy2Button = new JButton(boy2);
		boy2Button.setBorder(BorderFactory.createEmptyBorder());
		boy2Button.setContentAreaFilled(false);
		boy2Button.setBounds(620, 320, 200, 275);
		
		boy2Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				playerChar = 2;
				new PokemonParty();
				f.dispose();
			}
		}
		);
		
		bp.add(chooseYourChar);
		bp.add(girlButton);
		bp.add(boy1Button);
		bp.add(boy2Button);
		
		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	/**
	 * Method to invoke a JFrame in which the player will be shown a set of instructions on how to play the game
	 */
	public void howToPlay()
	{
	
		JFrame f = new JFrame("Select an Option");
		
		BackgroundPanel bp = new BackgroundPanel(3);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		

		ImageIcon icon = new ImageIcon(getClass().getResource("/images/pokl")); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		thumb.setBounds(275, 50, 500, 300);

		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
		
	}
	
	/**
	 * Main string[] args method
	 * @param args - String[]
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException
	{		
		String musicLoc = "Pokémon Theme Song.wav";
		InputStream in = new FileInputStream(musicLoc);
		AudioStream aStream = new AudioStream(in);
		AudioPlayer.player.start(aStream);
		//music();
		new MainMenu();
	}
	/**
	 * Method for music
	 */
	public static void music()
	{
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;
		ContinuousAudioDataStream loop = null;
		
		try {
			BGM = new AudioStream(new FileInputStream("Pokémon Theme Song.wav"));
			MD = BGM.getData();
			loop = new ContinuousAudioDataStream(MD);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MGP.start(loop);
		
	}
	
}
