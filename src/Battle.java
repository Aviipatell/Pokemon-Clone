/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Battle extends JFrame {
	//class body
	
	//declare a bunch of variables i need
	public ImageIcon battleGround;
	public static JPanel pokeBattle;
	JPanel battleOpts;
	BackgroundPanel bp;
	public Trainer tr;
	HealthBar playerHealth;
	HealthBar oppHealth;
	public Pokemon curPlayerPokemon;
	public Pokemon curOppPokemon;
	
	/**
	 * Method to invoke a frame in which the player begins their fight with a player
	 * @param tr - trainer
	 */
	public Battle(Trainer tr)
	{
		this.tr = tr;
		tr.setTrainerParty();
		tr.printParty();
		//Graphics g =  (g);
		bp = new BackgroundPanel(4);
		bp.setLayout(null);
		bp.setBounds(0, 0, 1020, 750);
		
		//playerHealth = new HealthBar(getCurPlayerPokemon().getCurHealth(), getCurPlayerPokemon().getMaxHealth());
		//oppHealth = new HealthBar(getCurOppPokemon().getCurHealth(), getCurOppPokemon().getMaxHealth());
		
		battleGround = new ImageIcon(getClass().getResource("/images/gBattle.png"));
			
		pokeBattle = new BackgroundPanel(5);
		pokeBattle.setBounds(100,50,820,350);
		pokeBattle.setLayout(null);
		pokeBattle.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		
		getCurPlayerPokemon();
		showStuff();
				
		battleOpts = new JPanel();
		battleOpts.setBounds(260, 450, 500, 250);
		battleOpts.setOpaque(false);
		battleOpts.setLayout(null);
		battleOpts.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			
		showPrimaryOpts();
		
		bp.add(pokeBattle);
		bp.add(battleOpts);
		
		add(bp);
		setSize(1020, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	//ImageIcon icon = new ImageIcon(p.frontImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
	}
	
	/**
	 * method needed to keep repainting the pokeBattle panel within the Battle frame
	 */
	public void showStuff()
	{
		pokeBattle.removeAll();
		
		showPokemons();
		showLabels();
		showHealthBars(curPlayerPokemon, 2);
		showHealthBars(getCurOppPokemon(), 1);
		
		pokeBattle.repaint();
	}
	
	/**
	 * method to keep updating to the primary opts within the battleOpts panel in the Battle frame
	 * also to ask player their primary opts: attack pokemon bag
	 */
	public void showPrimaryOpts()
	{
		battleOpts.removeAll();
		
		JButton attackBtn = new JButton("Attack");
		formatButton(attackBtn);
		attackBtn.setBounds(175, 80, 150, 50);
		
		attackBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showAttackOpts();
			}
		}
		);
		
		
		JButton pokemonBtn = new JButton("Pokemon");
		formatButton(pokemonBtn);
		pokemonBtn.setBounds(50, 150, 150, 50);
		
		pokemonBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showPokemonOpts();
			}
		}
		);
		
		JButton bagBtn = new JButton("Bag");
		formatButton(bagBtn);
		bagBtn.setBounds(300, 150, 150, 50);
		
		bagBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showBagOpts();
			}
		}
		);
		
		battleOpts.add(attackBtn);
		battleOpts.add(pokemonBtn);
		battleOpts.add(bagBtn);
		
		battleOpts.repaint();
	}
	
	/**
	 * Method to show player available attacks. 
	 * Also, to keep updating attackOPts in the battleOpts panel
	 */
	public void showAttackOpts()
	{
		battleOpts.removeAll();
		
		JButton a1 = new JButton(curPlayerPokemon.moveSet.get(1)[0]);
		formatButton(a1);
		a1.setBounds(50, 50, 200, 50);
		
		if(Integer.parseInt(curPlayerPokemon.moveSet.get(1)[2]) <= 0)
		{
			a1.setEnabled(false);
		}
		
		a1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int curpp = Integer.parseInt(curPlayerPokemon.moveSet.get(1)[2]) - 1;
				curPlayerPokemon.moveSet.get(1)[2] = Integer.toString(curpp);
				
				curPlayerPokemon.attack(getCurOppPokemon(), 1);
				//pokeBattle.revalidate();
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
			}
		}
		);
		
		JButton a2 = new JButton(curPlayerPokemon.moveSet.get(2)[0]);
		formatButton(a2);
		a2.setBounds(250, 50, 200, 50);
		
		if(Integer.parseInt(curPlayerPokemon.moveSet.get(2)[2]) <= 0)
		{
			a2.setEnabled(false);
		}
		
		a2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int curpp = Integer.parseInt(curPlayerPokemon.moveSet.get(2)[2]) - 1;
				curPlayerPokemon.moveSet.get(2)[2] = Integer.toString(curpp);
				
				curPlayerPokemon.attack(getCurOppPokemon(), 2);
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
			}
		}
		);
		
		JButton a3 = new JButton(curPlayerPokemon.moveSet.get(3)[0]);
		formatButton(a3);
		a3.setBounds(50, 100, 200, 50);
		
		if(Integer.parseInt(curPlayerPokemon.moveSet.get(3)[2]) <= 0)
		{
			a3.setEnabled(false);
		}
		
		a3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int curpp = Integer.parseInt(curPlayerPokemon.moveSet.get(3)[2]) - 1;
				curPlayerPokemon.moveSet.get(3)[2] = Integer.toString(curpp);
				
				curPlayerPokemon.attack(getCurOppPokemon(), 3);
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
			}
		}
		);
		
		JButton a4 = new JButton(curPlayerPokemon.moveSet.get(4)[0]);
		formatButton(a4);
		a4.setBounds(250, 100, 200, 50);
		
		if(Integer.parseInt(curPlayerPokemon.moveSet.get(4)[2]) <= 0)
		{
			a4.setEnabled(false);
		}
		
		a4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int curpp = Integer.parseInt(curPlayerPokemon.moveSet.get(4)[2]) - 1;
				curPlayerPokemon.moveSet.get(4)[2] = Integer.toString(curpp);
				
				curPlayerPokemon.attack(getCurOppPokemon(), 4);
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
			}
		}
		);
		
		JButton back = new JButton("Back");
		formatButton(back);
		back.setBounds(175,180,150,50);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showPrimaryOpts();
			}
		}
		);
		
		battleOpts.add(a1);
		battleOpts.add(a2);
		battleOpts.add(a3);
		battleOpts.add(a4);
		battleOpts.add(back);
		
		battleOpts.repaint();
	}
	
	/**
	 * Method to show player pokemonopts when/if they want to switch pokemons. 
	 * Also to keep updating showPokemonOpts() method within the BattleOpts panel
	 */
	public void showPokemonOpts()
	{
		battleOpts.removeAll();
		
		JLabel select = new JLabel("Select a Pokemon");
		formatLabel(select);
		select.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		select.setBounds(150,20, 200, 50);
		
		ImageIcon poke1I = new ImageIcon(PokemonParty.pokeParty[0].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke1 = new JButton(poke1I);
		poke1.setBorder(BorderFactory.createEmptyBorder());
		poke1.setContentAreaFilled(false);
		poke1.setBounds(50,75,100,100);
		JLabel poke1Lab = PokemonParty.pokeParty[0].getHealthStatLabel();
		poke1Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke1Lab.setBounds(50,150,150,50);
		poke1Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[0].getCurHealth() <= 0)
		{
			poke1.setEnabled(false);
		}
		
		poke1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				curPlayerPokemon = PokemonParty.pokeParty[0];
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
				showPrimaryOpts();
			}
		}
		);
		
		ImageIcon poke2I = new ImageIcon(PokemonParty.pokeParty[1].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke2 = new JButton(poke2I);
		poke2.setBorder(BorderFactory.createEmptyBorder());
		poke2.setContentAreaFilled(false);
		poke2.setBounds(200,75,100,100);
		JLabel poke2Lab = PokemonParty.pokeParty[1].getHealthStatLabel();
		poke2Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke2Lab.setBounds(200,150,150,50);
		poke2Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[1].getCurHealth() <= 0)
		{
			poke2.setEnabled(false);
		}
		
		poke2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				curPlayerPokemon = PokemonParty.pokeParty[1];
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
				showPrimaryOpts();
			}
		}
		);
		
		ImageIcon poke3I = new ImageIcon(PokemonParty.pokeParty[2].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke3 = new JButton(poke3I);
		poke3.setBorder(BorderFactory.createEmptyBorder());
		poke3.setContentAreaFilled(false);
		poke3.setBounds(350,75,125,100);
		JLabel poke3Lab = PokemonParty.pokeParty[2].getHealthStatLabel();
		poke3Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke3Lab.setBounds(350,150,150,50);
		poke3Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[2].getCurHealth() <= 0)
		{
			poke3.setEnabled(false);
		}
		
		poke3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				curPlayerPokemon = PokemonParty.pokeParty[2];
				try {
					oppTurn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showStuff();
				showPrimaryOpts();
			}
		}
		);
		
		JButton back = new JButton("Back");
		formatButton(back);
		back.setBounds(175,200,150,30);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showPrimaryOpts();
			}
		}
		);
		
		battleOpts.add(select);
		battleOpts.add(poke1);
		battleOpts.add(poke1Lab);
		battleOpts.add(poke2);
		battleOpts.add(poke2Lab);
		battleOpts.add(poke3);
		battleOpts.add(poke3Lab);
		battleOpts.add(back);
		
		battleOpts.repaint();
	}
	
	/**
	 * method to showBagOpts aka the items in the bag that the player might want to use during their battle
	 * also to keep updating bagOpts in the battleOpts panel
	 */
	public void showBagOpts()
	{
		battleOpts.removeAll();
		//System.out.println("Hello!");
		JButton hyperPot = new JButton("HyperPotions: " + Bag.hyperPotions);
		formatButton(hyperPot);
		hyperPot.setBounds(0,80,250,50);
		
		if (Bag.hyperPotions <= 0)
		{
			hyperPot.setEnabled(false);
		}
		
		hyperPot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				healPokeOpts(1);
			}
		}
		);
		
		JButton superPot = new JButton("SuperPotions: " + Bag.superPotions);
		formatButton(superPot);
		superPot.setBounds(250,80,250,50);
		
		if (Bag.superPotions <= 0)
		{
			superPot.setEnabled(false);
		}
		
		superPot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				healPokeOpts(2);
			}
		}
		);
		
		JButton back = new JButton("Back");
		formatButton(back);
		back.setBounds(175,150,150,50);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showPrimaryOpts();
			}
		}
		);
		
		battleOpts.add(hyperPot);
		battleOpts.add(superPot);
		battleOpts.add(back);
		battleOpts.repaint();
	}
	
	/**
	 * method to call to heal pokemon if a potion is selected within the bag
	 * @param i - int
	 */
	public void healPokeOpts(int i)
	{
		battleOpts.removeAll();
		
		//System.out.println("Hello!");
		JLabel select = new JLabel("Select a Pokemon");
		formatLabel(select);
		select.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		select.setBounds(150,20, 200, 50);
		
		ImageIcon poke1I = new ImageIcon(PokemonParty.pokeParty[0].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke1 = new JButton(poke1I);
		poke1.setBorder(BorderFactory.createEmptyBorder());
		poke1.setContentAreaFilled(false);
		poke1.setBounds(50,75,100,100);
		JLabel poke1Lab = PokemonParty.pokeParty[0].getHealthStatLabel();
		poke1Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke1Lab.setBounds(50,150,150,50);
		poke1Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[0].getCurHealth() <= 0)
		{
			poke1.setEnabled(false);
		}
		
		poke1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean check = PokemonParty.pokeParty[0].getCurHealth() == PokemonParty.pokeParty[0].getMaxHealth();
				
				if (check == true)
				{
					JOptionPane.showMessageDialog(battleOpts, "The Potion Will Have No Effect!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (i == 1)
					{
						if (Bag.hyperPotions <= 0)
						{
							JOptionPane.showMessageDialog(battleOpts, "You have used up all your Hyperpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[0].curHealth+= 200;
							if (PokemonParty.pokeParty[0].curHealth > PokemonParty.pokeParty[0].maxHealth)
							{
								PokemonParty.pokeParty[0].curHealth = PokemonParty.pokeParty[0].maxHealth;
							}
							Bag.hyperPotions--;
							try {
								oppTurn();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							showStuff();
						}
					}
					else
					{
						if (Bag.superPotions <= 0)
						{
							JOptionPane.showMessageDialog(battleOpts, "You have used up all your Superpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[0].curHealth+= 50;
							if (PokemonParty.pokeParty[0].curHealth > PokemonParty.pokeParty[0].maxHealth)
							{
								PokemonParty.pokeParty[0].curHealth = PokemonParty.pokeParty[0].maxHealth;
							}
							Bag.superPotions--;
							try {
								oppTurn();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							showStuff();
						}
					}
					poke1Lab.setText(PokemonParty.pokeParty[0].getHealthStat());
					battleOpts.repaint();
				}
			}
		}
		);
		
		ImageIcon poke2I = new ImageIcon(PokemonParty.pokeParty[1].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke2 = new JButton(poke2I);
		poke2.setBorder(BorderFactory.createEmptyBorder());
		poke2.setContentAreaFilled(false);
		poke2.setBounds(200,75,100,100);
		JLabel poke2Lab = PokemonParty.pokeParty[1].getHealthStatLabel();
		poke2Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke2Lab.setBounds(200,150,150,50);
		poke2Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[1].getCurHealth() <= 0)
		{
			poke2.setEnabled(false);
		}
		
		poke2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean check = PokemonParty.pokeParty[1].getCurHealth() == PokemonParty.pokeParty[1].getMaxHealth();
				
				if (check == true)
				{
					JOptionPane.showMessageDialog(battleOpts, "The Potion Will Have No Effect!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (i == 1)
					{
						if (Bag.hyperPotions <= 0)
						{
							JOptionPane.showMessageDialog(battleOpts, "You have used up all your Hyperpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[1].curHealth+= 200;
							if (PokemonParty.pokeParty[1].curHealth > PokemonParty.pokeParty[1].maxHealth)
							{
								PokemonParty.pokeParty[1].curHealth = PokemonParty.pokeParty[1].maxHealth;
							}
							Bag.hyperPotions--;
							try {
								oppTurn();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							showStuff();
						}
					}
					else
					{
						if (Bag.superPotions <= 0)
						{
							JOptionPane.showMessageDialog(battleOpts, "You have used up all your Superpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[1].curHealth+= 50;
							if (PokemonParty.pokeParty[1].curHealth > PokemonParty.pokeParty[1].maxHealth)
							{
								PokemonParty.pokeParty[1].curHealth = PokemonParty.pokeParty[1].maxHealth;
							}
							Bag.superPotions--;
							try {
								oppTurn();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							showStuff();
						}
					}
					poke2Lab.setText(PokemonParty.pokeParty[1].getHealthStat());
					battleOpts.repaint();
				}
			}
		}
		);
		
		ImageIcon poke3I = new ImageIcon(PokemonParty.pokeParty[2].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke3 = new JButton(poke3I);
		poke3.setBorder(BorderFactory.createEmptyBorder());
		poke3.setContentAreaFilled(false);
		poke3.setBounds(350,75,125,100);
		JLabel poke3Lab = PokemonParty.pokeParty[2].getHealthStatLabel();
		poke3Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke3Lab.setBounds(350,150,150,50);
		poke3Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[2].getCurHealth() <= 0)
		{
			poke3.setEnabled(false);
		}
		
		poke3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean check = PokemonParty.pokeParty[2].getCurHealth() == PokemonParty.pokeParty[2].getMaxHealth();
				if (check == true)
				{
					JOptionPane.showMessageDialog(battleOpts, "The Potion Will Have No Effect!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (i == 1)
					{
						if (Bag.hyperPotions <= 0)
						{
							JOptionPane.showMessageDialog(battleOpts, "You have used up all your Hyperpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[2].curHealth+= 200;
							if (PokemonParty.pokeParty[2].curHealth > PokemonParty.pokeParty[2].maxHealth)
							{
								PokemonParty.pokeParty[2].curHealth = PokemonParty.pokeParty[2].maxHealth;
							}
							Bag.hyperPotions--;
							try {
								oppTurn();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							showStuff();
						}
					}
					else
					{
						if (Bag.superPotions <= 0)
						{
							JOptionPane.showMessageDialog(battleOpts, "You have used up all your Superpotions!", "Potion Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							PokemonParty.pokeParty[2].curHealth+= 50;
							if (PokemonParty.pokeParty[2].curHealth > PokemonParty.pokeParty[2].maxHealth)
							{
								PokemonParty.pokeParty[2].curHealth = PokemonParty.pokeParty[2].maxHealth;
							}
							Bag.superPotions--;
							try {
								oppTurn();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							showStuff();
						}
					}
					poke3Lab.setText(PokemonParty.pokeParty[2].getHealthStat());
					battleOpts.repaint();
				}
			}
		}
		);
		
		JButton back = new JButton("Back");
		formatButton(back);
		back.setBounds(175,200,150,30);
		
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				showBagOpts();
			}
		}
		);
		
		battleOpts.add(select);
		battleOpts.add(poke1);
		battleOpts.add(poke1Lab);
		battleOpts.add(poke2);
		battleOpts.add(poke2Lab);
		battleOpts.add(poke3);
		battleOpts.add(poke3Lab);
		battleOpts.add(back);
		
		battleOpts.repaint();
		
	}
	/**
	 * method needed to display the battle graphics including the back of your current pokemon and the front of the opponents pokemon
	 */
	public void showPokemons()
	{
		ImageIcon playerPokeImg = new ImageIcon(curPlayerPokemon.backImage.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
		
		JLabel playerPoke = new JLabel(playerPokeImg);
		playerPoke.setBounds(50, 160, 300, 300);
		pokeBattle.add(playerPoke);
		
		ImageIcon oppPokeImage = new ImageIcon(getCurOppPokemon().frontImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		
		JLabel oppPoke = new JLabel(oppPokeImage);
		oppPoke.setBounds(480, 5, 200, 200);
		pokeBattle.add(oppPoke);
		
		pokeBattle.repaint();
	}
	
	/**
	 * method needed to show the names of the pokemon within the pokeBattle panel
	 */
	public void showLabels()
	{
		JLabel playerPokeName = new JLabel(curPlayerPokemon.pokemonName);
		playerPokeName.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		playerPokeName.setBounds(550,250,200,50);
		playerPokeName.setForeground(Color.WHITE);
		pokeBattle.add(playerPokeName);
		
		JLabel oppPokeName = new JLabel(getCurOppPokemon().pokemonName);
		oppPokeName.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		oppPokeName.setBounds(170,10,200,50);
		oppPokeName.setForeground(Color.WHITE);
		pokeBattle.add(oppPokeName);
		
		pokeBattle.repaint();
		
	}
	
	/*public void paint (Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		
		playerHealth.drawHealth(g2D, 2);
		oppHealth.drawHealth(g2D, 1);
	}*/
	
	/**
	 * method needed to show and keep updating the healthbars within the pokeBattle panel
	 * @param p - int
	 * @param i - int
	 */
	public void showHealthBars(Pokemon p, int i)
	{	
		//i == 1 for opp
		//i == 2 for player
		//System.out.println("Updating Health Bars!");
		int max = p.getMaxHealth();
		int cur = p.getCurHealth();
		int wid = 200;
		
		JLabel maxLab = new JLabel();
				
		maxLab.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		JLabel curLab = new JLabel();
		
		JLabel pokeStatus = new JLabel(cur + "/" + max);
		pokeStatus.setFont(new Font("PKMN RBYGSC", Font.PLAIN, 10));
		pokeStatus.setBounds(550,300,500,50);
		pokeStatus.setForeground(Color.WHITE);
		
		curLab.setBackground(Color.green);
		//curLab.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		curLab.setOpaque(true);
		
		int curLabWidth = (int) (cur/ ((double) max) * wid);
		
		if (i == 1)
		{
			maxLab.setBounds(170, 55, wid, 20);
			curLab.setBounds(170, 55, curLabWidth, 20);
		}
		else
		{
			maxLab.setBounds(550, 295, wid, 20);
			curLab.setBounds(550, 295, curLabWidth, 20);
		}
		
		if (i == 1)
		{
			pokeBattle.add(maxLab);
			pokeBattle.add(curLab);
		}
		else
		{
			pokeBattle.add(maxLab);
			pokeBattle.add(curLab);
			pokeBattle.add(pokeStatus);
		}
		
		pokeBattle.repaint();
	}
	
	/**
	 * method to call opponents turn so he/she/it can do its shiizzz/ stuff (haha ur prolly not gonna read this anyways.. why am i even doing this *sigh)
	 * @throws IOException
	 */
	public void oppTurn() throws IOException
	{
		//Do everything with Opponents turn
		//pokeBattle.repaint();
		
		if (curOppPokemon.getCurHealth() <= 0)
		{
			switchOppPokemon();
		}
		else
		{
			System.out.println("Opp Attacking");
			System.out.println(curPlayerPokemon.getCurHealth());
			oppAttack();
		}
		
		if (curPlayerPokemon.curHealth <= 0)
		{
			switchPlayerPokemon();
		}
		else
		{
			battleOpts.removeAll();
			showPrimaryOpts();
		}
	}
	
	/**
	 * method to call once players pokemon has been defeated and check if they have more pokemon left. if none left, end game. 
	 * @throws IOException
	 */
	public void switchPlayerPokemon() throws IOException
	{
		if (pokemonsLeft(PokemonParty.pokeParty) > 0)
		{
			selectPokemon();
		}
		else
		{
			showStuff();
			JOptionPane.showMessageDialog(pokeBattle, "You Have No More Pokemons Able To Battle. (Aka you are a disgrace to pokemon)", "Defeat.", JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("You've been defeated!");
			//System.out.println("GAME OVER!");			
			//System.out.println("You have made it to the exit!");
			
			String fileName = "userScores.txt";
			
			Scanner in = new Scanner(System.in);
			PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
			writer.println(ScoreBoard.score);
			//System.out.println("Writing..");
			writer.close();
			//System.out.println("Done Writing..");
			
			//System.out.println(ScoreBoard.score);
			
			new GameOver(2);
			dispose();
			
		}
	}
	
	/**
	 * Method to let player select apokemon after one of their pokemons have been defeated
	 */
	public void selectPokemon()
	{
		battleOpts.removeAll();
		
		JLabel select = new JLabel("Select a Pokemon");
		formatLabel(select);
		select.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		select.setBounds(150,20, 200, 50);
		
		ImageIcon poke1I = new ImageIcon(PokemonParty.pokeParty[0].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke1 = new JButton(poke1I);
		poke1.setBorder(BorderFactory.createEmptyBorder());
		poke1.setContentAreaFilled(false);
		poke1.setBounds(50,75,100,100);
		JLabel poke1Lab = PokemonParty.pokeParty[0].getHealthStatLabel();
		poke1Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke1Lab.setBounds(50,150,150,50);
		poke1Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[0].getCurHealth() <= 0)
		{
			poke1.setEnabled(false);
		}
		
		poke1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				curPlayerPokemon = PokemonParty.pokeParty[0];
				showStuff();
				showPrimaryOpts();
			}
		}
		);
		
		ImageIcon poke2I = new ImageIcon(PokemonParty.pokeParty[1].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke2 = new JButton(poke2I);
		poke2.setBorder(BorderFactory.createEmptyBorder());
		poke2.setContentAreaFilled(false);
		poke2.setBounds(200,75,100,100);
		JLabel poke2Lab = PokemonParty.pokeParty[1].getHealthStatLabel();
		poke2Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke2Lab.setBounds(200,150,150,50);
		poke2Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[1].getCurHealth() <= 0)
		{
			poke2.setEnabled(false);
		}
		
		poke2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				curPlayerPokemon = PokemonParty.pokeParty[1];
				showStuff();
				showPrimaryOpts();
			}
		}
		);
		
		ImageIcon poke3I = new ImageIcon(PokemonParty.pokeParty[2].frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JButton poke3 = new JButton(poke3I);
		poke3.setBorder(BorderFactory.createEmptyBorder());
		poke3.setContentAreaFilled(false);
		poke3.setBounds(350,75,125,100);
		JLabel poke3Lab = PokemonParty.pokeParty[2].getHealthStatLabel();
		poke3Lab.setFont(new Font("PKMN RBYGSC", Font.BOLD, 10));
		poke3Lab.setBounds(350,150,150,50);
		poke3Lab.setForeground(Color.WHITE);
		
		if(PokemonParty.pokeParty[2].getCurHealth() <= 0)
		{
			poke3.setEnabled(false);
		}
		
		poke3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				curPlayerPokemon = PokemonParty.pokeParty[2];
				showStuff();
				showPrimaryOpts();
			}
		}
		);
		
		battleOpts.add(select);
		battleOpts.add(poke1);
		battleOpts.add(poke1Lab);
		battleOpts.add(poke2);
		battleOpts.add(poke2Lab);
		battleOpts.add(poke3);
		battleOpts.add(poke3Lab);
		//battleOpts.add(back);
		
		battleOpts.repaint();
		
		
	}
	
	/**
	 * Method to bring some AI functionallity to the opponent. Make him select a pokemon tht has an advantage against your current pokemon hahahahahaha
	 * @param playerPokeType - String
	 * @param oppPokeType - String
	 * @return boolean
	 */
	public boolean checkEffectiveType(String playerPokeType, String oppPokeType)
	{
		if (playerPokeType.equals("Fire"))
		{
			if (oppPokeType.equals("Water"))
				return true;
			else if (oppPokeType.equals("Rock"))
				return true;
			else if (oppPokeType.equals("Ground"))
				return true;
			else
				return false;
		}
		else if (playerPokeType.equals("Water"))
		{
			if (oppPokeType.equals("Electric"))
				return true;
			else if (oppPokeType.equals("Grass"))
				return true;
			else
				return false;			
		}
		else if (playerPokeType.equals("Electric"))
		{
			if (oppPokeType.equals("Ground"))
				return true;
			else
				return false;
		}
		else if (playerPokeType.equals("Ice"))
		{
			if (oppPokeType.equals("Fighting"))
				return true;
			else if (oppPokeType.equals("Fire"))
				return true;
			else if (oppPokeType.equals("Rock"))
				return true;
			else if (oppPokeType.equals("Steel"))
				return true;
			else
				return false;
		}
		else if (playerPokeType.equals("Dragon"))
		{
			if (oppPokeType.equals("Dragon"))
				return true;
			else if (oppPokeType.equals("Ice"))
				return true;
			else
				return false;
		}
		else if (playerPokeType.equals("Ground"))
		{
			if (oppPokeType.equals("Grass"))
				return true;
			else if (oppPokeType.equals("Water"))
				return true;
			else if (oppPokeType.equals("Ice"))
				return true;
			else
				return false;
		}
		else if (playerPokeType.equals("Grass"))
		{
			if (oppPokeType.equals("Fire"))
				return true;
			else if (oppPokeType.equals("Flying"))
				return true;
			else if (oppPokeType.equals("Ice"))
				return true;
			else
				return false;
		}
		else if (playerPokeType.equals("Steel"))
		{
			if (oppPokeType.equals("Ground"))
				return true;
			else if (oppPokeType.equals("Fire"))
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * method to switch opponents pokemon if it dies
	 */
	public void switchOppPokemon()
	{
		if (pokemonsLeft(tr.trainerParty) > 0)
		{
			getCurOppPokemon();
			String type = curPlayerPokemon.pokemonType;
			
			for (int i = 0; i < tr.trainerParty.length; i++)
			{
				if (checkEffectiveType(type, tr.trainerParty[i].pokemonType) && tr.trainerParty[i].curHealth > 0)
				{
					//System.out.println("GETTING MORE EFFECTIVE MATCHUP: " + getCurOppPokemon(i).pokemonName);
					getCurOppPokemon(i);
					break;
				}
			}
		}
		else
		{
			showStuff();
			JOptionPane.showMessageDialog(pokeBattle, "You've won!. (Aka wow you're somewhat decent)", "Victory.", JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("You've beaten him!");
			ScoreBoard.score+= 1000*tr.trainerNum;
			GlobalPosition.curTrainer.beaten=true;
			//GlobalPosition.x-=1;
			//System.out.println("Trainer set to beaten");
			dispose();
		}
	}
	
	/**
	 * method to make the opponent attack player
	 */
	public void oppAttack()
	{
		int ran = (int)(Math.random()*4) + 1;
		
		while (Integer.parseInt(curOppPokemon.moveSet.get(ran)[2]) <= 0)
		{
			ran = (int)(Math.random()*4) + 1;
		}
		
		curOppPokemon.moveSet.get(ran)[2] = Integer.toString(Integer.parseInt(curOppPokemon.moveSet.get(ran)[2]) - 1);
		curOppPokemon.attack(curPlayerPokemon, ran);
	}
	
	/**
	 * method to check how many pokemons a player / trainer has left
	 * @param pokemonParty - Pokemon[]
	 * @return int
	 */
	private int pokemonsLeft(Pokemon[] pokemonParty) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		for (int i = 0; i < pokemonParty.length; i++)
		{
			if (pokemonParty[i].getCurHealth() > 0)
			{
				count++;
			}
		}
		
		return count;
	}

	/**
	 * method to get players cur pokemon
	 * @return Pokemon
	 */
	public Pokemon getCurPlayerPokemon()
	{
		for (int i = 0; i < 3; i++)
		{
			if (PokemonParty.pokeParty[i].getCurHealth() > 0)
			{
				curPlayerPokemon = PokemonParty.pokeParty[i];
				return PokemonParty.pokeParty[i];
			}
		}
		
		//blank
		return PokemonParty.pokeParty[0];
	}
	
	/**
	 * method to set opp current pokemon
	 * @param p - Pokemon
	 */
	public void setCurOppPokemon(Pokemon p)
	{
		
	}
	
	/**
	 * accessor method to getcurOpp Pokemon
	 * @return Pokemon
	 */
	public Pokemon getCurOppPokemon()
	{	
		if (pokemonsLeft(tr.trainerParty) > 0)
		{
			for (int i = 0; i < tr.trainerParty.length; i++)
			{
				if (tr.trainerParty[i].getCurHealth() > 0)
				{
					curOppPokemon = tr.trainerParty[i];
					return tr.trainerParty[i];
				}
			}
		}
		else
		{
			dispose();
			return tr.trainerParty[0];
		}
		return tr.trainerParty[0];
		
		//return tr.trainerParty[0];
	}
	
	/**
	 * method to get curOpponents pokemon
	 * @param i - int
	 * @return Pokemon
	 */
	public Pokemon getCurOppPokemon(int i)
	{	
		
		curOppPokemon = tr.trainerParty[i];
		return tr.trainerParty[i];
	
	}
	
	/*public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getBackgroundImage(), 0, 0, pokeBattle);
	}*/
	
	/**
	 * method to accessor thing background image
	 * @return Image
	 */
	public Image getBackgroundImage()
	{
		ImageIcon i = battleGround; 
		return i.getImage();
	}
	
	/**
	 * method to format jbuttons
	 * @param b - JButton
	 */
	public void formatButton(JButton b)
	{
		b.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		b.setForeground(Color.BLACK);
	}
	
	/**
	 * method to format Labels
	 * @param l - JLabel
	 */
	public void formatLabel(JLabel l)
	{
		l.setFont(new Font("PKMN RBYGSC", Font.BOLD, 15));
		l.setForeground(Color.WHITE);
	}

}
