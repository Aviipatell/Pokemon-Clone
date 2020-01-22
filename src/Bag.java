/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Bag
{
	//class body
	//declare a bunch of variables ima need aka private instance, public instance, public static etc
	public static int hyperPotions = 0;
	private int revives = 0;
	public static int superPotions = 0;
	int key = 0;
	JFrame f;
	private String user = MainMenu.playerUserName;
	public ImageIcon i;
	public int superOrHyper;
	JButton hyperPotionBtn;
	JButton superPotionBtn;

	/**
	 * Constructor to Bag
	 * @param hyperPotions - int
	 * @param superPotions - int 
	 * @param revives - int
	 */
	public Bag(int hyperPotions, int superPotions, int revives)
	{
		this.hyperPotions = hyperPotions;
		this.superPotions = superPotions;
		this.revives = revives;
	}

	/**
	 * Method to invoke a JFrame to Open Bag
	 */
	public void openBag()
	{
		f = new JFrame("Your Bag");
		
		//f.addKeyListener(this);
        f.setFocusable(true);
		
		BackgroundPanel bp = new BackgroundPanel(4);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		JLabel showUser = new JLabel(user);
		showUser.setFont(new Font("PKMN RBYGSC", Font.BOLD, 25));
		showUser.setBounds(100,50,500,50);
		//addUserName.setBackground(Color.WHITE);
		showUser.setForeground(Color.WHITE);
		
		if (MainMenu.playerChar == 1)
		{
			i = new ImageIcon(getClass().getResource("/images/hughresized.gif"));
		}
		else if (MainMenu.playerChar == 2)
		{
			i = new ImageIcon(getClass().getResource("/images/guy2resized.gif"));
		}
		else if (MainMenu.playerChar == 3)
		{
			i = new ImageIcon(getClass().getResource("/images/hildaresized.gif"));
		}
		
		JLabel charIcon = new JLabel(i);
		charIcon.setBounds(50, 100, 300, 500);
		
		/**JButton quitBtn = new JButton("Quit Game");
		quitBtn.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		quitBtn.setBounds(75,580,250,50);
		
		quitBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				f.setVisible(false);
				f.dispose();
				//Game.endGame();
			}
		}
		);*/
		
		JPanel showPoke = new JPanel();
		showPoke.setLayout(null);
		showPoke.setBounds(500,50,500,300);
		showPoke.setOpaque(false);
		
		JLabel yourPoke = new JLabel("Your Pokemon:");
		yourPoke.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		yourPoke.setBounds(200,0,250,50);
		yourPoke.setForeground(Color.WHITE);
		
		JButton poke1 = new JButton(PokemonParty.pokeParty[0].pokemonName);
		poke1.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		poke1.setBounds(175,75,250,50);
		
		poke1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showCurPokeStats(PokemonParty.pokeParty[0]);
			}
		}
		);
		
		
		JButton poke2 = new JButton(PokemonParty.pokeParty[1].pokemonName);
		poke2.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		poke2.setBounds(175,145,250,50);
		
		poke2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showCurPokeStats(PokemonParty.pokeParty[1]);
			}
		}
		);
		
		JButton poke3 = new JButton(PokemonParty.pokeParty[2].pokemonName);
		poke3.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		poke3.setBounds(175,215,250,50);
		
		poke3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showCurPokeStats(PokemonParty.pokeParty[2]);
			}
		}
		);

		
		showPoke.add(yourPoke);
		showPoke.add(poke1);
		showPoke.add(poke2);
		showPoke.add(poke3);
		
		JPanel showItems = new JPanel();
		showItems.setLayout(null);
		showItems.setBounds(500,360,500,300);
		showItems.setOpaque(false);
		
		JLabel yourItems = new JLabel("Your Items:");
		yourItems.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		yourItems.setBounds(200,0,250,50);
		yourItems.setForeground(Color.WHITE);
		
		hyperPotionBtn = new JButton("Hyperpotions: " + hyperPotions);
		hyperPotionBtn.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		hyperPotionBtn.setBounds(150,75,300,50);
		
		if (hyperPotions <= 0)
		{
			hyperPotionBtn.setEnabled(false);
		}
		
		hyperPotionBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				usePotion(1);
			}
		}
		);

		
		superPotionBtn = new JButton("Superpotions: " + superPotions);
		superPotionBtn.setFont(new Font("PKMN RBYGSC", Font.BOLD, 18));
		superPotionBtn.setBounds(150,145,300,50);
		
		if (superPotions <= 0)
		{
			superPotionBtn.setEnabled(false);
		}
		
		superPotionBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				usePotion(2);
			}
		}
		);
		
		JButton exitBtn = new JButton("Exit");
		formatButton(exitBtn);
		exitBtn.setBounds(250, 215, 100, 50);
		
		exitBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				closeBag();
				
			}
		}
		);
		
		showItems.add(yourItems);
		showItems.add(hyperPotionBtn);
		showItems.add(superPotionBtn);
		showItems.add(exitBtn);
		
		bp.add(showUser);
		bp.add(charIcon);
		//bp.add(quitBtn);
		bp.add(showPoke);
		bp.add(showItems);
		//bp.add(exitBtn);
		
		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	
	/**
	 * Method to invoke a JFrame to show player the pokemon stats of the pokemon they selected
	 * @param p - Pokemon
	 */
	public void showCurPokeStats(Pokemon p)
	{
		JFrame f = new JFrame(p.pokemonName);
		
		BackgroundPanel bp = new BackgroundPanel(4);
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
		
		JLabel pokemonHealth = new JLabel("Health: " + Integer.toString(p.getCurHealth()) + "/" + Integer.toString(p.getMaxHealth()));
		pokemonHealth.setFont(new Font("PKMN RBYGSC", Font.BOLD, 17));
		pokemonHealth.setBounds(400,370,500,50);
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
		
		back.setBounds(430, 600, 200, 40);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				f.dispose();
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
				
		f.add(bp);
		f.setSize(1020, 750);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	/**
	 * Method to invoke a JFrame where the user selects the pokemon that they want to use their potion on
	 * @param sOrh - int
	 */
	public void usePotion(int sOrh)
	{
		JFrame fr = new JFrame("Select a Pokemon");
		
		superOrHyper = sOrh;
		
		BackgroundPanel bp = new BackgroundPanel(4);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		JLabel select = new JLabel("Select a Pokemon");
		select.setFont(new Font("PKMN RBYGSC", Font.BOLD, 22));
		select.setBounds(350,175,500,50);
		select.setForeground(Color.WHITE);
		
		ImageIcon poke1I = new ImageIcon(PokemonParty.pokeParty[0].frontImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		ImageIcon poke2I = new ImageIcon(PokemonParty.pokeParty[1].frontImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		ImageIcon poke3I = new ImageIcon(PokemonParty.pokeParty[2].frontImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

		JButton poke1 = new JButton(poke1I);
		poke1.setBorder(BorderFactory.createEmptyBorder());
		poke1.setContentAreaFilled(false);
		poke1.setBounds(170, 275, 200, 200);
		
		JLabel poke1Label = PokemonParty.pokeParty[0].getHealthStatLabel();
		poke1Label.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		poke1Label.setBounds(170,475,200,50);
		poke1Label.setForeground(Color.WHITE);
		
		poke1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean check = PokemonParty.pokeParty[0].getCurHealth() == PokemonParty.pokeParty[0].getMaxHealth();
				
				if (check == true)
				{
					JOptionPane.showMessageDialog(fr, "The Potion Will Have No Effect!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (superOrHyper == 1)
					{
						if (hyperPotions <= 0)
						{
							JOptionPane.showMessageDialog(fr, "You have used up all your Hyperpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[0].curHealth+= 200;
							if (PokemonParty.pokeParty[0].curHealth > PokemonParty.pokeParty[0].maxHealth)
							{
								PokemonParty.pokeParty[0].curHealth = PokemonParty.pokeParty[0].maxHealth;
							}
							hyperPotions--;
						}
					}
					else
					{
						if (superPotions <= 0)
						{
							JOptionPane.showMessageDialog(fr, "You have used up all your Superpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[0].curHealth+= 50;
							if (PokemonParty.pokeParty[0].curHealth > PokemonParty.pokeParty[0].maxHealth)
							{
								PokemonParty.pokeParty[0].curHealth = PokemonParty.pokeParty[0].maxHealth;
							}
							superPotions--;
						}
					}
					poke1Label.setText(PokemonParty.pokeParty[0].getHealthStat());
					fr.repaint();
				}
			}
		}
		);
		
		JButton poke2 = new JButton(poke2I);
		poke2.setBorder(BorderFactory.createEmptyBorder());
		poke2.setContentAreaFilled(false);
		poke2.setBounds(420, 275, 200, 200);
		
		JLabel poke2Label = PokemonParty.pokeParty[1].getHealthStatLabel();
		poke2Label.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		poke2Label.setBounds(420,475,200,50);
		poke2Label.setForeground(Color.WHITE);

		poke2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean check = PokemonParty.pokeParty[1].getCurHealth() == PokemonParty.pokeParty[1].getMaxHealth();
				
				if (check == true)
				{
					JOptionPane.showMessageDialog(fr, "The Potion Will Have No Effect!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (superOrHyper == 1)
					{
						if (hyperPotions <= 0)
						{
							JOptionPane.showMessageDialog(fr, "You have used up all your Hyperpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[1].curHealth+= 200;
							if (PokemonParty.pokeParty[1].curHealth > PokemonParty.pokeParty[1].maxHealth)
							{
								PokemonParty.pokeParty[1].curHealth = PokemonParty.pokeParty[1].maxHealth;
							}
							hyperPotions--;
						}
					}
					else
					{
						if (superPotions <= 0)
						{
							JOptionPane.showMessageDialog(fr, "You have used up all your Superpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[1].curHealth+= 50;
							if (PokemonParty.pokeParty[1].curHealth > PokemonParty.pokeParty[1].maxHealth)
							{
								PokemonParty.pokeParty[1].curHealth = PokemonParty.pokeParty[1].maxHealth;
							}
							superPotions--;
						}
					}
					poke2Label.setText(PokemonParty.pokeParty[1].getHealthStat());
					fr.repaint();
				}
			}
		}
		);
		
		JButton poke3 = new JButton(poke3I);
		poke3.setBorder(BorderFactory.createEmptyBorder());
		poke3.setContentAreaFilled(false);
		poke3.setBounds(670, 275, 200, 200);
		
		JLabel poke3Label = PokemonParty.pokeParty[2].getHealthStatLabel();
		poke3Label.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		poke3Label.setBounds(670,475,200,50);
		poke3Label.setForeground(Color.WHITE);

		poke3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean check = PokemonParty.pokeParty[2].getCurHealth() == PokemonParty.pokeParty[2].getMaxHealth();
				
				if (check == true)
				{
					JOptionPane.showMessageDialog(fr, "The Potion Will Have No Effect!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (superOrHyper == 1)
					{
						if (hyperPotions <= 0)
						{
							JOptionPane.showMessageDialog(fr, "You have used up all your Hyperpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[2].curHealth+= 200;
							if (PokemonParty.pokeParty[2].curHealth > PokemonParty.pokeParty[2].maxHealth)
							{
								PokemonParty.pokeParty[2].curHealth = PokemonParty.pokeParty[2].maxHealth;
							}
							hyperPotions--;
						}
					}
					else
					{
						if (superPotions <= 0)
						{
							JOptionPane.showMessageDialog(fr, "You have used up all your Superpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[2].curHealth+= 50;
							if (PokemonParty.pokeParty[2].curHealth > PokemonParty.pokeParty[2].maxHealth)
							{
								PokemonParty.pokeParty[2].curHealth = PokemonParty.pokeParty[2].maxHealth;
							}
							superPotions--;
						}
					}
					poke3Label.setText(PokemonParty.pokeParty[2].getHealthStat());
					fr.repaint();
				}
			}
		}
		);
		
		JButton back = new JButton("Back");
		formatButton(back);
		back.setBounds(415,550,200,50);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				fr.dispose();
				hyperPotionBtn.setText("Hyperpotions: " + hyperPotions);
				if (hyperPotions <= 0)
				{
					hyperPotionBtn.setEnabled(false);
				}
				superPotionBtn.setText("Superpotions: " + superPotions);
				if (superPotions == 0)
				{
					superPotionBtn.setEnabled(false);
				}
				f.repaint();
			}
		}
		);
		
		
		if (PokemonParty.pokeParty[0].getCurHealth() <= 0)
		{
			poke1.setEnabled(false);
		}
		if (PokemonParty.pokeParty[1].getCurHealth() <= 0)
		{
			poke2.setEnabled(false);
		}
		if (PokemonParty.pokeParty[2].getCurHealth() <= 0)
		{
			poke3.setEnabled(false);
		}
		
		bp.add(select);
		bp.add(poke1);
		bp.add(poke2);
		bp.add(poke3);
		bp.add(poke1Label);
		bp.add(poke2Label);
		bp.add(poke3Label);
		bp.add(back);
		
		fr.add(bp);
		fr.setSize(1020, 750);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		fr.setResizable(false);
		
	}
	
	/**
	 * method to format JButton
	 * @param btn - JButton
	 */
	public void formatButton(JButton btn)
	{
		btn.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		//btn.setBounds(325,200,500,50);
		btn.setForeground(Color.BLACK);
	}
	
	/**
	 * method to dispose of Bag JFrame
	 */
	public void closeBag()
	{
		Player.xIsDown = false;
		//setXIsDown(false);
		f.dispose();
	}

	/*
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hitting Space");
		
		key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE)
		{
			Player.xIsDown = false;
			f.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}*/

	
	
}
