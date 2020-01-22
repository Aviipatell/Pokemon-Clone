/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */
//references: bulbapedia - the world's strongest community-driven pokemon database!! 
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
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Pokemon {
	//class body
	
	//declare some variables ima need
	public String pokemonName;
	public String pokemonType;
	public String pokemonAttack;
	public ImageIcon frontImage;
	public ImageIcon backImage;
	public int maxHealth;
	public int curHealth;
	public HashMap<Integer, String[]> moveSet = new HashMap<Integer, String[]>();
	
	/**
	 * Constructor for Pokemon
	 * @param pokemonName - String
	 */
	public Pokemon(String pokemonName)
	{
		this.pokemonName = pokemonName;
		
		if (pokemonName.equals("Charizard"))
		{
			pokemonType = "Fire";
			maxHealth = 360;
			curHealth = maxHealth;
			
			String[] move1 = {"Fire Punch", "50", "20", "20"};
			String[] move2 = {"Fire Fang", "50", "15", "15"};
			String[] move3 = {"Flamethrower", "75", "10", "10"};
			String[] move4 = {"Inferno", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/charizardFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/charizardBack.png"));
		}
		else if (pokemonName.equals("Pikachu"))
		{
			pokemonType = "Electric";
			maxHealth = 274;
			curHealth = maxHealth;
			
			String[] move1 = {"Thunder Punch", "50", "15", "15"};
			String[] move2 = {"Thunder Fang", "50", "15", "15"};
			String[] move3 = {"ThunderBolt", "75", "10", "10"};
			String[] move4 = {"Thunder", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/pikachuFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/pikachuBack.png"));
		}
		else if (pokemonName.equals("Dragonite"))
		{
			pokemonType = "Dragon";
			maxHealth = 386;
			curHealth = maxHealth;
			
			String[] move1 = {"Dragon Tail", "50", "15", "15"};
			String[] move2 = {"Dragon Breath", "50", "15", "15"};
			String[] move3 = {"Dragon Claw", "75", "10", "10"};
			String[] move4 = {"Outrage", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/dragoniteFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/dragoniteBack.png"));
		}
		else if (pokemonName.equals("Venusaur"))
		{
			pokemonType = "Grass";
			maxHealth = 364;
			curHealth = maxHealth;
			
			String[] move1 = {"Razor Leaf", "50", "15", "15"};
			String[] move2 = {"Leaf Blade", "50", "15", "15"};
			String[] move3 = {"Petal Blizzard", "75", "10", "10"};
			String[] move4 = {"Solar Beam", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/venusaurFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/venusaurBack.png"));
		}
		else if (pokemonName.equals("Blastoise"))
		{
			pokemonType = "Water";
			maxHealth = 362;
			curHealth = maxHealth;
			
			String[] move1 = {"Splash", "50", "15", "15"};
			String[] move2 = {"Water Pulse", "50", "15", "15"};
			String[] move3 = {"Surf", "75", "10", "10"};
			String[] move4 = {"Hydro Pump", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/blastoiseFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/blastoiseBack.png"));
		}
		else if (pokemonName.equals("Ho-oh"))
		{
			pokemonType = "Fire";
			maxHealth = 416;
			curHealth = maxHealth;
			
			String[] move1 = {"Fire Fang", "50", "15", "15"};
			String[] move2 = {"Incinerate", "50", "15", "15"};
			String[] move3 = {"Fire Blast", "75", "10", "10"};
			String[] move4 = {"Sacred Fire", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/ho-ohFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/ho-ohBack.png"));
		}
		else if (pokemonName.equals("Garchomp"))
		{
			pokemonType = "Dragon";
			maxHealth = 346;
			curHealth = maxHealth;
			
			String[] move1 = {"Dragon Rage", "50", "15", "15"};
			String[] move2 = {"Dragon Claw", "50", "15", "15"};
			String[] move3 = {"Dragon Rush", "75", "10", "10"};
			String[] move4 = {"Outrage", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/garchompFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/garchompBack.png"));
		}
		else if (pokemonName.equals("Rhyperior"))
		{
			pokemonType = "Ground";
			maxHealth = 348;
			curHealth = maxHealth;
			
			String[] move1 = {"Bulldoze", "50", "15", "15"};
			String[] move2 = {"Drill Run", "50", "15", "15"};
			String[] move3 = {"Earth Power", "75", "10", "10"};
			String[] move4 = {"Earthquake", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/rhyperiorFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/rhyperiorBack.png"));
		}
		else if (pokemonName.equals("Articuno"))
		{
			pokemonType = "Ice";
			maxHealth = 300;
			curHealth = maxHealth;
			
			String[] move1 = {"Ice Fang", "50", "15", "15"};
			String[] move2 = {"Ice Shard", "50", "15", "15"};
			String[] move3 = {"Ice Beam", "75", "10", "10"};
			String[] move4 = {"Blizzard", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/articunoFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/articunoBack.png"));
		}
		else if (pokemonName.equals("Aggron"))
		{
			pokemonType = "Steel";
			maxHealth = 280;
			curHealth = maxHealth;
			
			String[] move1 = {"Iron Head", "50", "15", "15"};
			String[] move2 = {"Iron Tail", "50", "15", "15"};
			String[] move3 = {"Heavy Slam", "75", "10", "10"};
			String[] move4 = {"Metal Burst", "90", "5", "5"};
			
			moveSet.put(1, move1);
			moveSet.put(2, move2);
			moveSet.put(3, move3);
			moveSet.put(4, move4);
			
			frontImage = new ImageIcon(getClass().getResource("/images/aggronFront.png"));
			backImage = new ImageIcon(getClass().getResource("/images/aggronBack.png"));
		}
	}
	
	/**
	 * accessor method to get pokemon's curHealth
	 * @return - int
	 */
	public int getCurHealth()
	{
		if (curHealth < 0)
		{
			return 0;
		}
		else
		{
			return curHealth;
		}
	}
	
	/**
	 * accessor method to get the pokemon's maxHealth
	 * @return
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	/**
	 * method to damage pokemon
	 * @param d - int
	 */
	public void damage(int d)
	{
		
	}
	
	/**
	 * method for pokemon to attack another pokemon
	 * @param p - int
	 * @param k - int
	 */
	public void attack(Pokemon p, int k)
	{
		p.curHealth-= Integer.parseInt(moveSet.get(k)[1]) * effectivenessFactor(p, k);
		//System.out.println(p.getCurHealth());
	}
	
	/**
	 * method to return the effectiveness factor based on typeAdvantages receives from bulbapedia
	 * @param p - int
	 * @param k - int
	 * @return factor - int
	 */
	public double effectivenessFactor(Pokemon p, int k)
	{
		String type = p.pokemonType;
		String curMoveType = pokemonType;
		double factor = 1;
		
		if (type.equals("Fire"))
		{
			if (curMoveType.equals("Fire"))
				factor = 0.5;
			else if (curMoveType.equals("Water"))
				factor = 1.5;
			else if (curMoveType.equals("Rock"))
				factor = 1.5;
			else if (curMoveType.equals("Ground"))
				factor = 1.5;
			else if (curMoveType.equals("Grass"))
				factor = 0.5;
			else if (curMoveType.equals("Bug"))
				factor = 0.5;
			else if (curMoveType.equals("Ice"))
				factor = 0.5;
			else if (curMoveType.equals("Steel"))
				factor = 0.5;
			else
				factor = 1;
		}
		else if (type.equals("Water"))
		{
			if (curMoveType.equals("Fire"))
				factor = 0.5;
			else if (curMoveType.equals("Water"))
				factor = 0.5;
			else if (curMoveType.equals("Ice"))
				factor = 0.5;
			else if (curMoveType.equals("Electric"))
				factor = 1.5;
			else if (curMoveType.equals("Grass"))
				factor = 1.5;
			else if (curMoveType.equals("Steel"))
				factor = 0.5;
			else
				factor = 1;
			
		}
		else if (type.equals("Flying"))
		{
			if (curMoveType.equals("Bug"))
				factor = 0.5;
			else if (curMoveType.equals("Fighting"))
				factor = 0.5;
			else if (curMoveType.equals("Grass"))
				factor = 0.5;
			else if (curMoveType.equals("Electric"))
				factor = 1.5;
			else if (curMoveType.equals("Ice"))
				factor = 1.5;
			else if (curMoveType.equals("Rock"))
				factor = 1.5;
			else if (curMoveType.equals("Ground"))
				factor = 0;
			else
				factor = 1;
		}
		else if (type.equals("Electric"))
		{
			if (curMoveType.equals("Electric"))
				factor = 0.5;
			else if (curMoveType.equals("Flying"))
				factor = 0.5;
			else if (curMoveType.equals("Ground"))
				factor = 1.5;
			else if (curMoveType.equals("Steel"))
				factor = 0.5;
			else
				factor = 1;
		}
		else if (type.equals("Ice"))
		{
			if (curMoveType.equals("Ice"))
				factor = 0.5;
			else if (curMoveType.equals("Fighting"))
				factor = 1.5;
			else if (curMoveType.equals("Fire"))
				factor = 1.5;
			else if (curMoveType.equals("Rock"))
				factor = 1.5;
			else if (curMoveType.equals("Steel"))
				factor = 1.5;
			else
				factor = 1;
		}
		else if (type.equals("Dragon"))
		{
			if (curMoveType.equals("Electric"))
				factor = 0.5;
			else if (curMoveType.equals("Fire"))
				factor = 0.5;
			else if (curMoveType.equals("Grass"))
				factor = 0.5;
			else if (curMoveType.equals("Water"))
					factor = 0.5;
			else if (curMoveType.equals("Dragon"))
				factor = 1.5;
			else if (curMoveType.equals("Ice"))
				factor = 1.5;
			else
				factor = 1;
		}
		else if (type.equals("Ground"))
		{
			if (curMoveType.equals("Poison"))
				factor = 0.5;
			else if (curMoveType.equals("Rock"))
				factor = 0.5;
			else if (curMoveType.equals("Grass"))
				factor = 1.5;
			else if (curMoveType.equals("Water"))
					factor = 1.5;
			else if (curMoveType.equals("Ice"))
				factor = 1.5;
			else if (curMoveType.equals("Electric"))
				factor = 0.5;
			else
				factor = 1;
		}
		else if (type.equals("Grass"))
		{ 
			if (curMoveType.equals("Electric"))
				factor = 0.5;
			else if (curMoveType.equals("Ground"))
				factor = 0.5;
			else if (curMoveType.equals("Grass"))
				factor = 0.5;
			else if (curMoveType.equals("Water"))
					factor = 0.5;
			else if (curMoveType.equals("Fire"))
				factor = 1.5;
			else if (curMoveType.equals("Flying"))
				factor = 1.5;
			else if (curMoveType.equals("Ice"))
				factor = 1.5;
			else
				factor = 1;
		}
		else if (type.equals("Steel"))
		{
			if (curMoveType.equals("Flying"))
				factor = 0.5;
			else if (curMoveType.equals("Grass"))
				factor = 0.5;
			else if (curMoveType.equals("Ice"))
				factor = 0.5;
			else if (curMoveType.equals("Steel"))
				factor = 0.5;
			else if (curMoveType.equals("Rock"))
				factor = 0.5;
			else if (curMoveType.equals("Ground"))
				factor = 1.5;
			else if (curMoveType.equals("Fire"))
				factor = 1.5;
			else
				factor = 1;
		}
		
		return factor;
	}
	
	/**
	 * method to get pokemons health in the form of curHealth/maxHealth ex. 123/456
	 * @return - String
	 */
	public String getHealthStat()
	{
		return "Health: " + getCurHealth() + "/" + getMaxHealth();
	}
	
	/** 
	 * method to get pokemons health in the form of curHealth/maxHealth in the form of a label
	 * @return - JLabel
	 */
	public JLabel getHealthStatLabel()
	{
		return new JLabel(getHealthStat());
	}
	
	public void showHealthBar()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		
	}
	
	public void paint(Graphics g)
	{

	}
}
