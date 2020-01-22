/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PokemonParty extends JFrame {
	//class body
	
	//declare Variables ima need
	public static Pokemon[] pokeParty = new Pokemon[3];
	Pokemon o1;
	Pokemon o2;
	Pokemon o3;
	Pokemon o4;
	Pokemon o5;
	Pokemon o6;
	Pokemon o7;
	Pokemon o8;
	Pokemon o9;
	Pokemon o10;
	JButton poke1;
	JButton poke2;
	JButton poke3;
	JButton poke4;
	JButton poke5;
	JButton poke6;
	JButton poke7;
	JButton poke8;
	JButton poke9;
	JButton poke10;
	//JFrame f;
	
	/**
	 * Constructor for PokemonParty
	 */
	public PokemonParty()
	{
		super("Choose your Pokemon");
		
		o1 = new Pokemon("Charizard");
		o2 = new Pokemon("Pikachu");
		o3 = new Pokemon("Dragonite");
		o4 = new Pokemon("Venusaur");
		o5 = new Pokemon("Blastoise");
		o6 = new Pokemon("Ho-oh");
		o7 = new Pokemon("Garchomp");
		o8 = new Pokemon("Rhyperior");
		o9 = new Pokemon("Articuno");
		o10 = new Pokemon("Aggron");
		
		System.out.println("WARNING CHECK!!");
		
		BackgroundPanel bp = new BackgroundPanel(2);
		bp.setLayout(new FlowLayout());
		bp.setLayout(null);
		bp.setBounds(0,0,1020,750);
		
		JLabel chooseYourPok = new JLabel("Choose Three Pokemons");
		chooseYourPok.setFont(new Font("PKMN RBYGSC", Font.BOLD, 22));
		chooseYourPok.setBounds(325,200,500,50);
		chooseYourPok.setForeground(Color.WHITE);
		
		poke1 = new JButton(o1.frontImage);
		poke1.setBorder(BorderFactory.createEmptyBorder());
		poke1.setBounds(160, 300, 100, 100);
		poke1.setContentAreaFilled(false);
		
		poke1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o1, 1);
			} 
		}
		);
				
		poke2 = new JButton(o2.frontImage);
		poke2.setBorder(BorderFactory.createEmptyBorder());
		poke2.setContentAreaFilled(false);
		poke2.setBounds(310, 300, 100, 100);

		poke2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o2, 2);
			}
		}
		);
		
		poke3 = new JButton(o3.frontImage);
		poke3.setBorder(BorderFactory.createEmptyBorder());
		poke3.setContentAreaFilled(false);
		poke3.setBounds(460, 300, 100, 100);

		poke3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o3, 3);
			}
		}
		);
		
		poke4 = new JButton(o4.frontImage);
		poke4.setBorder(BorderFactory.createEmptyBorder());
		poke4.setContentAreaFilled(false);
		poke4.setBounds(610, 300, 100, 100);

		poke4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o4, 4);
			}
		}
		);
		
		poke5 = new JButton(o5.frontImage);
		poke5.setBorder(BorderFactory.createEmptyBorder());
		poke5.setContentAreaFilled(false);
		poke5.setBounds(760, 300, 100, 100);

		poke5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o5, 5);
			}
		}
		);
		
		poke6 = new JButton(o6.frontImage);
		poke6.setBorder(BorderFactory.createEmptyBorder());
		poke6.setContentAreaFilled(false);
		poke6.setBounds(160, 450, 100, 100);

		poke6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o6, 6);
			}
		}
		);
		
		poke7 = new JButton(o7.frontImage);
		poke7.setBorder(BorderFactory.createEmptyBorder());
		poke7.setContentAreaFilled(false);
		poke7.setBounds(310, 450, 100, 100);

		poke7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o7, 7);
			}
		}
		);
		
		poke8 = new JButton(o8.frontImage);
		poke8.setBorder(BorderFactory.createEmptyBorder());
		poke8.setContentAreaFilled(false);
		poke8.setBounds(460, 450, 100, 100);

		poke8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o8, 8);
			}
		}
		);
		
		poke9 = new JButton(o9.frontImage);
		poke9.setBorder(BorderFactory.createEmptyBorder());
		poke9.setContentAreaFilled(false);
		poke9.setBounds(610, 450, 100, 100);

		poke9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o9, 9);
			}
		}
		);
		
		poke10 = new JButton(o10.frontImage);
		poke10.setBorder(BorderFactory.createEmptyBorder());
		poke10.setContentAreaFilled(false);
		poke10.setBounds(760, 450, 100, 100);

		poke10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pokeStats(o10, 10);
			}
		}
		);
		
		bp.add(chooseYourPok);
		bp.add(poke1);
		bp.add(poke2);
		bp.add(poke3);
		bp.add(poke4);
		bp.add(poke4);
		bp.add(poke5);
		bp.add(poke6);
		bp.add(poke7);
		bp.add(poke8);
		bp.add(poke9);
		bp.add(poke10);
		
		add(bp);
		setSize(1020,750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}
	
	/**
	 * method to invoke a frame in which u can see the pokemon stats
	 * @param p - Pokemon
	 * @param i - int
	 */
	public void pokeStats(Pokemon p, int i)
	{
		JFrame f = new JFrame("Select your Character");
		
		BackgroundPanel bp = new BackgroundPanel(2);
		bp.setLayout(new FlowLayout());
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		JLabel pokemonName = new JLabel(p.pokemonName);
		pokemonName.setFont(new Font("PKMN RBYGSC", Font.BOLD, 22));
		pokemonName.setBounds(425,100,500,50);
		pokemonName.setForeground(Color.WHITE);
		
		ImageIcon icon = new ImageIcon(p.frontImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(icon);
		iconLabel.setBounds(400, 125, 500, 300);
		
		JLabel pokemonHealth = new JLabel("Health: " + Integer.toString(p.curHealth));
		pokemonHealth.setFont(new Font("PKMN RBYGSC", Font.BOLD, 17));
		pokemonHealth.setBounds(450,370,500,50);
		pokemonHealth.setForeground(Color.WHITE);
		
		JButton move1 = new JButton(p.moveSet.get(1)[0] + " " + p.moveSet.get(1)[2] + "/" + p.moveSet.get(1)[3]);
		JButton move2 = new JButton(p.moveSet.get(2)[0] + " " + p.moveSet.get(2)[2] + "/" + p.moveSet.get(2)[3]);
		JButton move3 = new JButton(p.moveSet.get(3)[0] + " " + p.moveSet.get(3)[2] + "/" + p.moveSet.get(3)[3]);
		JButton move4 = new JButton(p.moveSet.get(4)[0] + " " + p.moveSet.get(4)[2] + "/" + p.moveSet.get(4)[3]);
		
		formatButton(move1);
		formatButton(move2);
		formatButton(move3);
		formatButton(move4);

		move1.setBounds(170, 450, 350, 40);
		move2.setBounds(540, 450, 350, 40);
		move3.setBounds(170, 510, 350, 40);
		move4.setBounds(540, 510, 350, 40);
		
		move1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog(f, "Damage: " + p.moveSet.get(1)[1], p.moveSet.get(1)[0], JOptionPane.INFORMATION_MESSAGE);
			}
		}
		);

		move2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog(f, "Damage: " + p.moveSet.get(2)[1], p.moveSet.get(2)[0], JOptionPane.INFORMATION_MESSAGE);
			}
		}
		);
		
		move3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog(f, "Damage: " + p.moveSet.get(3)[1], p.moveSet.get(3)[0], JOptionPane.INFORMATION_MESSAGE);
			}
		}
		);
		
		move4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog(f, "Damage: " + p.moveSet.get(4)[1], p.moveSet.get(4)[0], JOptionPane.INFORMATION_MESSAGE);
			}
		}
		);
		
		JButton back = new JButton("Back");
		formatButton(back);
		JButton select = new JButton("Select");
		formatButton(select);
		
		back.setBounds(330, 600, 200, 40);
		select.setBounds(530, 600, 200, 40);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				f.dispose();
			}
		}
		);
		
		select.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int numSelected = 0;
				disableSelected(i);
				numSelected = countSelected();
				addToParty(p, numSelected);
				if (numSelected == 3)
				{
					for (int i = 0; i < 3; i++)
					{
						System.out.println(pokeParty[i].pokemonName);
					}
					
					new MainClass();
					f.dispose();
					dispose();
					
				}
				else
				{
					f.dispose();
				}
			}
		}
		);
		
		
		
		
		bp.add(pokemonName);
		bp.add(iconLabel);
		bp.add(pokemonHealth);
		bp.add(move1);
		bp.add(move2);
		bp.add(move3);
		bp.add(move4);
		bp.add(back);
		bp.add(select);
		
		/*ImageIcon imageIcon =
		 *new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);*/
		
		
		
		
		
		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	
	/**
	 * method to add selected pokemon to party
	 * @param p - Pokemon
	 * @param curPoke - int
	 */
	public void addToParty(Pokemon p, int curPoke)
	{
		curPoke = curPoke - 1;
		pokeParty[curPoke] = p;
	}
	
	/**
	 * method to check how many pokemons have already been selected
	 * @return count - int
	 */
	public int countSelected()
	{
		int count = 0;
		
		if (poke1.isEnabled() == false)
		{
			count++;
		}
		if (poke2.isEnabled() == false)
		{
			count++;
		}
		if (poke3.isEnabled() == false)
		{
			count++;
		}
		if (poke4.isEnabled() == false)
		{
			count++;
		}
		if (poke5.isEnabled() == false)
		{
			count++;
		}
		if (poke6.isEnabled() == false)
		{
			count++;
		}
		if (poke7.isEnabled() == false)
		{
			count++;
		}
		if (poke8.isEnabled() == false)
		{
			count++;
		}
		if (poke9.isEnabled() == false)
		{
			count++;
		}
		if (poke10.isEnabled() == false)
		{
			count++;
		}
		return count;
	}
	
	/**
	 * method to disable the pokemon that have already been selected
	 * @param i - int
	 */
	public void disableSelected(int i)
	{
		if (i == 1)
		{
			poke1.setEnabled(false);
		}
		else if (i == 2)
		{
			poke2.setEnabled(false);
		}
		else if (i == 3)
		{
			poke3.setEnabled(false);
		}
		else if (i == 4)
		{
			poke4.setEnabled(false);
		}
		else if (i == 5)
		{
			poke5.setEnabled(false);
		}
		else if (i == 6)
		{
			poke6.setEnabled(false);
		}
		else if (i == 7)
		{
			poke7.setEnabled(false);
		}
		else if (i == 8)
		{
			poke8.setEnabled(false);
		}
		else if (i == 9)
		{
			poke9.setEnabled(false);
		}
		else if (i == 10)
		{
			poke10.setEnabled(false);
		}
	}
	
	/**
	 * method to format Jbutton
	 * @param b - JButton
	 */
	public void formatButton(JButton b)
	{
		b.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		b.setBounds(325,200,500,50);
		b.setForeground(Color.BLACK);
	}
	
	/**
	 * method to format JLabel
	 * @param l - JLabel
	 */
	public void formatLabel(JLabel l)
	{
		l.setFont(new Font("PKMN RBYGSC", Font.BOLD, 17));
		l.setBounds(325,200,500,50);
		l.setForeground(Color.WHITE);
	}
	
	public void showAttack1(JButton move, Pokemon p)
	{
		//JOptionPane.showMessageDialog(f, "Damage: " + p.moveSet.get(1)[1], p.moveSet.get(1)[0], JOptionPane.OK_OPTION);
	}
	
}
