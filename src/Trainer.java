/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Trainer extends TrainerTemplate{
	//class body
	
	//declare variables ima need
	public String trainerName;
	public static int trainerNum = 0; 
	public ArrayList<Pokemon> pokeSelections = new ArrayList<Pokemon>();
	public static Pokemon trainerParty[];
	public String trainerImage = "/images/TrainerFront.png";
	public static ArrayList<Integer> trainerX = new ArrayList<Integer>();
	public static ArrayList<Integer> trainerY = new ArrayList<Integer>();
	public int tX;
	public int tY;
	public boolean beaten = false;
	
	/**
	 * Constructor for Trainer
	 * @param trainerName - String
	 */
	public Trainer(String trainerName)
	{
		this.trainerName = trainerName;
		//this.trainerNum = trainerNum;
		
		pokeSelections.add(new Pokemon("Charizard"));
		pokeSelections.add(new Pokemon("Pikachu"));
		pokeSelections.add(new Pokemon("Dragonite"));
		pokeSelections.add(new Pokemon("Venusaur"));
		pokeSelections.add(new Pokemon("Blastoise"));
		pokeSelections.add(new Pokemon("Ho-oh"));
		pokeSelections.add(new Pokemon("Garchomp"));
		pokeSelections.add(new Pokemon("Rhyperior"));
		pokeSelections.add(new Pokemon("Articuno"));
		pokeSelections.add(new Pokemon("Aggron"));

		if (trainerX.isEmpty() && trainerY.isEmpty())
		{
			setTrainerXandY();
		}
		
		int ranNum = (int)(Math.random()*trainerX.size());
		tX = trainerX.get(ranNum);
		tY = trainerY.get(ranNum);
		
		trainerX.remove(ranNum);
		trainerY.remove(ranNum);
		
		setPlayerImage(tX);
		
	}
	
	/**
	 * method to print out party
	 */
	public void printParty()
	{
		for (int i = 0; i < trainerParty.length; i++)
		{
			System.out.println(trainerParty[i].pokemonName);
		}
	}
	
	/**
	 * mutator method to setTrainers image based on which side it's facing
	 * @param tX - int
	 */
	public void setPlayerImage(int tX)
	{
		if (tX == 110 || tX == 108)
		{
			trainerImage = "/images/TrainerRight.png";
		}
		else if (tX == 472 || tX == 870)
		{
			trainerImage = "/images/TrainerLeft.png";
		}
		else
		{
			trainerImage = "/images/TrainerFront.png";
		}
	}
	
	/**
	 * mutator method to add xandY coordinates of the trainer markers to the arrayList
	 */
	public void setTrainerXandY()
	{
		trainerX.add(110);
		trainerY.add(572);
		trainerX.add(472);
		trainerY.add(312);
		trainerX.add(818);
		trainerY.add(138);
		trainerX.add(108);
		trainerY.add(174);
		trainerX.add(870);
		trainerY.add(432);
		trainerX.add(214);
		trainerY.add(296);
		trainerX.add(498);
		trainerY.add(6);
		trainerX.add(620);
		trainerY.add(274);
	}
	
	/**
	 * accessory method to get trainers numerical number
	 * @return trainerNum - int
	 */
	public int getTrainerNum()
	{
		return trainerNum;
	}
	
	/**
	 * accessor method to get trainers party
	 * @return trainerParty - Pokemon[]
	 */
	public Pokemon[] getTrainerParty()
	{
		return trainerParty;
	}
	
	/**
	 * mutator method to set trainers party
	 */
	public void setTrainerParty()
	{
		trainerNum++;
		
		if (trainerNum == 1)
		{
			setParty(2, 0);
		}
		else if (trainerNum == 2)
		{
			setParty(2, 1);
		}
		else if (trainerNum == 3)
		{
			setParty(3, 0);
		}
		else if (trainerNum == 4)
		{
			setParty(3, 1);
		}
		else if (trainerNum == 5)
		{
			setParty(4, 0);
		}
	}
	
	/**
	 * @param numOfPokemon - int
	 * @param boost - int
	 */
	public void setParty(int numOfPokemon, int boost)
	{
		int ranNum = 0;
		int selectionSize;
		trainerParty = new Pokemon[numOfPokemon];
		
		for (int i = 0; i < numOfPokemon; i++)
		{
			selectionSize = pokeSelections.size();
			ranNum = (int)(Math.random()*selectionSize);
			trainerParty[i] = pokeSelections.get(ranNum);
			pokeSelections.remove(ranNum);
		}
		
		if (boost == 0)
		{
			
		}
		else
		{
			for (int i = 0; i < numOfPokemon; i++)
			{
				trainerParty[i].moveSet.get(1)[1] = Integer.toString((Integer.parseInt(trainerParty[i].moveSet.get(1)[1]) + 20));
				trainerParty[i].moveSet.get(2)[1] = Integer.toString((Integer.parseInt(trainerParty[i].moveSet.get(2)[1]) + 20));
				trainerParty[i].moveSet.get(3)[1] = Integer.toString((Integer.parseInt(trainerParty[i].moveSet.get(3)[1]) + 20));
				trainerParty[i].moveSet.get(4)[1] = Integer.toString((Integer.parseInt(trainerParty[i].moveSet.get(4)[1]) + 20));
			}
		}
	}
	
	/**
	 * method to draw trainer onto the game JFrame
	 * @param g2d - Graphics2D
	 */
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getTrainerImage(), tX, tY, null);
	}
	
	/**
	 * accessor method to get Trainers image
	 * @return - Image
	 */
	public Image getTrainerImage()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(trainerImage));
		ImageIcon ii = new ImageIcon(i.getImage().getScaledInstance(35, 40, Image.SCALE_SMOOTH));
		//ImageIcon icon = new ImageIcon(p.frontImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
		return ii.getImage();
	}

	/**
	 * mutator method to setplayers image
	 */
	@Override
	public void setPlayerImage() {
		// TODO Auto-generated method stub
		
	}
	

}
