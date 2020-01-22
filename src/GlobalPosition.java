/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GlobalPosition {
	//class body
	
	//declare a couple variables for the class that i need
	public static int x, y;
	public int playerContact = 0;
	public static Trainer curTrainer;
	private boolean gameOver = false;
	
	/**
	 * Constructor for GlobalPosition
	 * @param x - int
	 * @param y - int
	 */
	public GlobalPosition(int x, int y)
	{
		//set x and y
		this.x = x;
		this.y = y;
	}
	
	/**
	 * check/detect for collisions along the x-axis of the JFrame
	 */
	public void boundaryDetectionX()
	{	
		
		playerContact = -1;
		//set of conditions to keep checking for, replicating the boundaries on the actual frame
		if (x < 0)
		{
			x = 0;
		}
		
		if (x > 980)
		{
			x = 980;
		}
		
		if (y > 432 && x > 818)
		{
			x = 818;
		}
		
		if ((y < 256 && y >= 134) && x >= 818)
		{
			x = 818;
		}
		
		if ((y >= 256 && y <= 432) && x >= 872)
		{
			x = 872;
		}
		
		if (y > 628 && x < 702)
		{
			x = 702;
		}
		
		if ((y > 586 && y <= 628) && x <= 592)
		{
			x = 592;
		}
		
		if ((y >= 328) && x < 108)
		{
			x = 108;
		}
		
		if ((y >= 294 && y < 328) && x <= 214)
		{
			x = 214;
		}
		
		if ((y > 196 && y < 294) &&  x < 272)
		{
			x = 272;
		}
		
		if ((y >= 132 && y <= 196) && x < 108)
		{
			x = 108;
		}
		
		if (y < 134 && x > 498)
		{
			x = 498;
		}
		
		if (y < 132 && x < 324)
		{
			x = 324;
		}
			
		if ((y > 450 && y < 546) && (x < 616 && x > 358))
		{
			if (x < 487)
			{
				x = 358;
			}
			else
			{
				x = 616;
			}
		}
		
		if ((y > 370 && y < 546) && (x < 272 && x > 174))
		{
			if (x < 223)
			{
				x = 174;
			}
			else
			{
				x = 272;
			}
		}
		
		if ((y > 174 && y < 312) && (x > 360 && x < 620))
		{			
			if (x < 490)
			{
				x = 360;
			}
			else
			{
				x = 620;
			}
		}
		
		if ((y >= 312 && y < 426) && (x > 474 && x < 620))
		{
			if (x < 547)
			{
				x = 474;
			}
			else
			{
				x = 620;
			}
		}		
		
		if (x < 410 && y < 0)
		{
			x = 410;
		}
		//check whether or not a trainer is located on a certain x position to prevent running through him/her
		checkTrainerX();
		
	}
	
	/**
	 * check/detect for collisions along y-axis of Jframe
	 * @throws IOException
	 */
	public void boundaryDetectionY() throws IOException
	{
		//playerContact = -1;
		
		//set of conditions to check for to prevent unwanted y-axis movement
		if ((x >= 616 && x <= 818) && (y <= 526 && (y + 47 < 580 && y + 47 > 570)))
		{
			y = 526;
		}
		
		if ((x >= 272 && x <= 358) && (y <= 526 && (y + 47 < 580 && y + 47 > 570)))
		{
			y = 526;
		}
		
		if ((x >= 620 && x <= 752) && (y <= 264 && (y + 47 < 320 && y + 47 > 305)))
		{
			y = 264;
		}
		
		if ((x >= 272 && x <= 360) && (y <= 264 && (y + 47 < 320 && y + 47 > 305)))
		{
			y = 264;
		}
		
		if (x >= 702 && x <= 818 && y >= 670)
		{
			y = 670;
		}
		if ((x >= 108 && x < 324) && y < 132)
		{
			y = 132;
		}
		
		if ((x >= 108 && x < 272) && (y > 196 && y < 245))
		{
			y = 196;
		}
		
		if ((x >= 214 && x < 272) && (y < 294 && y > 245))
		{
			y = 294;
		}
		
		if ((x >= 108 && x < 214) && (y <= 328 && y > 311))
		{
			y = 328;
		}
		
		if ((x >= 108 && x <= 592) && y >= 586)
		{
			y = 586;
		}
		
		if ((x >= 592 && x < 702) && y >= 628)
		{
			y = 628;
		}
		
		if ((x > 818 && x <= 872) && y >= 432)
		{
			y = 432;
		}
		
		if ((x > 818 && x <= 872) && y <= 256)
		{
			y = 256;
		}
		
		if ((x > 498 && x <= 818) && y <= 134)
		{
			y = 134;
		}
		
		if ((x > 174 && x < 272) && (y > 370 && y < 546))
		{
			if (y < 458)
			{
				y = 370;
			}
			else
			{
				y = 546;
			}
		}
		
		if ((x > 358 && x < 616) && (y > 450 && y < 546))
		{
			if (y < 498)
			{
				y = 450;
			}
			else
			{
				y = 546;
			}
		}
		
		if ((x > 360 && x < 620) && (y > 174 && y < 312))
		{
			if (y < 200)
			{
				y = 174;
			}
			else
			{
				y = 312;
			}
		}
		
		if ((x > 474 && x < 620) && (y > 312 && y < 426))
		{
			y = 426;
		}
		
		if (x < 410 && y < 0)
		{
			y = 0;
		}
		
		if (x > 464 && y < 0)
		{
			y = 0;
		}
		
		//check to see if the player has reached the exit
		if (x > 410 && x < 464 && y < 0 && gameOver == false)
		{
			//set game over to true so that infinite loop doesnt start
			gameOver = true;
			//System.out.println("You have made it to the exit!");
			
			//set file name
			String fileName = "userScores.txt";
			
			//grab additional score from players pokemon party, increasing score if they have any pokemon left with good hp
			modifyScore();
			
			//declare scanner and write the players score to file
			Scanner in = new Scanner(System.in);
			PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
			writer.println(ScoreBoard.score);
			//System.out.println("Writing..");
			writer.close();
			//System.out.println("Done Writing..");
			
			//call gameOver frame
			new GameOver(1);
			
						
		}
		
		//check to look for collisions with any trainers on the y-axis
		checkTrainerY();
	}
	
	/**
	 * Method to add on to current score of the player if he/she reaches the exit and has pokemon left with hp
	 */
	public void modifyScore()
	{
		int num = 0;
		//add the remaining hp of all of players pokemon
		for (int i = 0; i < 3; i++)
		{
			if (PokemonParty.pokeParty[i].getCurHealth() > 0)
			{
				num+=PokemonParty.pokeParty[i].getCurHealth();
			}
		}
		//divide it by 2 and add it to the score
		ScoreBoard.score+= num/2;
	}
	
	/**
	 * Method to check if the player is colliding with any pokemon on the x-axis
	 */
	public void checkTrainerX()
	{
		if (Game.t1.tX == 110 && Game.t1.tY == 572 || Game.t2.tX == 110  && Game.t2.tY == 572 || Game.t3.tX == 110  && Game.t3.tY == 572 || Game.t4.tX == 110  && Game.t4.tY == 572 || Game.t5.tX == 110  && Game.t5.tY == 572 )
		{
			if (y >= 532 && y <= 586 && x <= 146)
			{
				x = 146; 
				//collision has been detected
				playerContact = setContact1(1);
			}
		}
		if (Game.t1.tX <= 472 && Game.t1.tY == 312 || Game.t2.tX == 472  && Game.t2.tY == 312 || Game.t3.tX == 472  && Game.t3.tY == 312 || Game.t4.tX == 472  && Game.t4.tY == 312 || Game.t5.tX == 472 && Game.t5.tY == 312)
		{
			if (y >= 312 && y < 328 && x >= 436 && x < 536)
			{
				x = 436;
				playerContact = setContact2(2);
			}
		}
		if (Game.t1.tX <= 818 && Game.t1.tY == 138 || Game.t2.tX <= 818  && Game.t2.tY == 138 || Game.t3.tX <= 818  && Game.t3.tY == 138 || Game.t4.tX <= 818  && Game.t4.tY == 138 || Game.t5.tX <= 818  && Game.t5.tY == 138 )
		{
			if (y >= 0 && y < 160 && x >= 780)
			{
				x = 780;
				//no x check here
			}
		}	
		if (Game.t1.tX == 108 && Game.t1.tY == 174 || Game.t2.tX == 108  && Game.t2.tY == 174 || Game.t3.tX == 108  && Game.t3.tY == 174 || Game.t4.tX == 108  && Game.t4.tY == 174 || Game.t5.tX == 108  && Game.t5.tY == 174 )
		{
			if (y <= 196 && y >= 132 && x <= 136)
			{
				x = 136;
				playerContact = setContact4(4);
			}
		}
		if (Game.t1.tX == 214 && Game.t1.tY == 296 || Game.t2.tX == 214  && Game.t2.tY == 296 || Game.t3.tX == 214  && Game.t3.tY == 296 || Game.t4.tX == 214  && Game.t4.tY == 296 || Game.t5.tX == 214  && Game.t5.tY == 296 )
		{
			if (y >= 294 && y < 314 && x <= 252)
			{
				x = 252;
				//no check x here
			}
		}
		if (Game.t1.tX <= 620 && Game.t1.tY == 274 || Game.t2.tX <= 620  && Game.t2.tY == 274 || Game.t3.tX <= 620  && Game.t3.tY == 274 || Game.t4.tX <= 620  && Game.t4.tY == 274 || Game.t5.tX <= 620  && Game.t5.tY == 274 )
		{
			if (y >= 236 && y < 316 && x <= 652 && x > 620)
			{
				x = 652;
				//no check x here
			}
		}
		if (Game.t1.tX <= 870 && Game.t1.tY == 432 || Game.t2.tX <= 870  && Game.t2.tY == 432 || Game.t3.tX <= 870  && Game.t3.tY == 432 || Game.t4.tX <= 870  && Game.t4.tY == 432 || Game.t5.tX <= 870  && Game.t5.tY == 432 )
		{
			if (y <= 432 && y > 384 && x >= 830)
			{
				x = 830;
				playerContact = setContact7(7);
			}
		}
		
		if (Game.t1.tX <= 498 && Game.t1.tY == 6 || Game.t2.tX <= 498  && Game.t2.tY == 6 || Game.t3.tX <= 498  && Game.t3.tY == 6 || Game.t4.tX <= 498  && Game.t4.tY == 6 || Game.t5.tX <= 498  && Game.t5.tY == 6 )
		{
			if (y < 30 && x > 460)
			{
				x = 460;
				// no check x here
			}
		}
		
	}
	
	/**
	 * Method to check if the player is colliding with any trainers in the y-axis
	 */
	public void checkTrainerY()
	{
		if (Game.t1.tX <= 110 && Game.t1.tY == 572 || Game.t2.tX <= 110  && Game.t2.tY == 572 || Game.t3.tX <= 110  && Game.t3.tY == 572 || Game.t4.tX <= 110  && Game.t4.tY == 572 || Game.t5.tX <= 110  && Game.t5.tY == 572 )
		{
			if (x < 146 && y >= 524)
			{
				y = 524;
				//no check y
			}
		}
		if (Game.t1.tX <= 472 && Game.t1.tY == 312 || Game.t2.tX <= 472  && Game.t2.tY == 312 || Game.t3.tX <= 472  && Game.t3.tY == 312 || Game.t4.tX <= 472  && Game.t4.tY == 312 || Game.t5.tX <= 472 && Game.t5.tY == 312)
		{
			if (x > 436 && x < 536 && y > 310 && y < 328)
			{
				y = 328;
				//no check y
			}
		}
		if (Game.t1.tX <= 818 && Game.t1.tY == 138 || Game.t2.tX <= 818  && Game.t2.tY == 138 || Game.t3.tX <= 818  && Game.t3.tY == 138 || Game.t4.tX <= 818  && Game.t4.tY == 138 || Game.t5.tX <= 818  && Game.t5.tY == 138 )
		{
			if (x > 780 && y <= 160)
			{
				y = 160;
				playerContact = setContact3(3);
			}
		}
		if (Game.t1.tX <= 108 && Game.t1.tY == 174 || Game.t2.tX <= 108  && Game.t2.tY == 174 || Game.t3.tX <= 108  && Game.t3.tY == 174 || Game.t4.tX <= 108  && Game.t4.tY == 174 || Game.t5.tX <= 108  && Game.t5.tY == 174 )
		{
			//no y detection needed
		}
		if (Game.t1.tX <= 214 && Game.t1.tY == 296 || Game.t2.tX <= 214  && Game.t2.tY == 296 || Game.t3.tX <= 214  && Game.t3.tY == 296 || Game.t4.tX <= 214  && Game.t4.tY == 296 || Game.t5.tX <= 214  && Game.t5.tY == 296 )
		{
			if (x >= 214 && x < 252 && y < 314 && y > 294)
			{
				y = 314;
				playerContact = setContact5(5);
			}
		}
		if (Game.t1.tX <= 620 && Game.t1.tY == 274 || Game.t2.tX <= 620  && Game.t2.tY == 274 || Game.t3.tX <= 620  && Game.t3.tY == 274 || Game.t4.tX <= 620  && Game.t4.tY == 274 || Game.t5.tX <= 620  && Game.t5.tY == 274 )
		{
			if (x >= 620 && x < 652 && y < 316 && y > 300)
			{
				y = 316;
				playerContact = setContact6(6);
			}
			else if (x >= 620 && x < 652 && y > 226 && y < 250)
			{
				y = 226;
			}
		}
		if (Game.t1.tX <= 870 && Game.t1.tY == 432 || Game.t2.tX <= 870  && Game.t2.tY == 432 || Game.t3.tX <= 870  && Game.t3.tY == 432 || Game.t4.tX <= 870  && Game.t4.tY == 432 || Game.t5.tX <= 870  && Game.t5.tY == 432 )
		{
			if (x > 830 && x <= 872 && y >= 384)
			{
				y = 384;
				//no y needed
			}
		}
		if (Game.t1.tX <= 498 && Game.t1.tY == 6 || Game.t2.tX <= 498  && Game.t2.tY == 6 || Game.t3.tX <= 498  && Game.t3.tY == 6 || Game.t4.tX <= 498  && Game.t4.tY == 6 || Game.t5.tX <= 498  && Game.t5.tY == 6 )
		{
			if (x > 460 && y <= 30)
			{
				y = 30;
				playerContact = setContact8(8);
			}
		}
	}
	
	/**
	 * Method to get a numerical value that will determine whether or not the player is able to challenge a trainer
	 * @return playerContact - int
	 */
	public int getPlayerContact()
	{
		return playerContact;
	}
	
	/**
	 * Method to set curTrainer to the trainer that the player is trying to battle / mutator
	 * @param curTrainer - trainer
	 */
	public void setCurTrainer(Trainer curTrainer)
	{
		//System.out.println("SETTING TRAINER");
		this.curTrainer = curTrainer;
	}
	
	/**
	 * Accessor for curTrainer
	 * @return curTrainer - trainer
	 */
	public Trainer getCurTrainer()
	{
		return curTrainer;
	}
	
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact1(int n)
	{
		if (Game.t1.tX == 110 && Game.t1.tY == 572)
		{
			setCurTrainer(Game.t1);
			//System.out.println(getCurTrainer().trainerName);
		}
		else if (Game.t2.tX == 110 && Game.t2.tY == 572)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 110 && Game.t3.tY == 572)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 110 && Game.t4.tY == 572)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 110 && Game.t5.tY == 572)
		{
			setCurTrainer(Game.t5);
		}
		
		if (x == 146 && y >= 532 && y <= 586 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n;
		}
		else
		{
			return -n;
		}
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact2(int n)
	{
		if (Game.t1.tX == 472 && Game.t1.tY == 312)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX == 472 && Game.t2.tY == 312)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 472 && Game.t3.tY == 312)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 472 && Game.t4.tY == 312)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 472 && Game.t5.tY == 312)
		{
			setCurTrainer(Game.t5);
		}
		if (y >= 312 && y < 328 && x >= 436 && x < 536 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n;
		}
		else
		{
			return -n;
		}
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact4(int n)
	{
		if (Game.t1.tX == 108 && Game.t1.tY == 174)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX == 108 && Game.t2.tY == 174)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 108 && Game.t3.tY == 174)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 108 && Game.t4.tY == 174)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 108 && Game.t5.tY == 174)
		{
			setCurTrainer(Game.t5);
		}
		if (y <= 196 && y >= 132 && x <= 136 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n;
		}
		else
		{
			return -n;
		}
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact7(int n)
	{
		if (Game.t1.tX == 870 && Game.t1.tY == 432)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX == 870 && Game.t2.tY == 432)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 870 && Game.t3.tY == 432)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 870 && Game.t4.tY == 432)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 870 && Game.t5.tY == 432)
		{
			setCurTrainer(Game.t5);
		}
		if (y <= 432 && y > 384 && x >= 830 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n;
		}
		else
		{
			return -n;
		}
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact3(int n)
	{
		if (Game.t1.tX <= 818 && Game.t1.tY == 138)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX <= 818 && Game.t2.tY == 138)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 818 && Game.t3.tY == 138)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 818 && Game.t4.tY == 138)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 818 && Game.t5.tY == 138)
		{
			setCurTrainer(Game.t5);
		}
		if (x > 780 && y <= 160 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n;
		}
		else
		{
			return -n;
		}
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact5(int n)
	{
		if (Game.t1.tX <= 214 && Game.t1.tY == 296)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX <= 214 && Game.t2.tY == 296)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 214 && Game.t3.tY == 296)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 214 && Game.t4.tY == 296)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 214 && Game.t5.tY == 296)
		{
			setCurTrainer(Game.t5);
		}
		if (x >= 214 && x < 252 && y <= 314 && y > 294 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n; //x >= 214 && x < 252 && y < 314 && y > 294
		}
		else
		{
			return -n;
		}
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact6(int n)
	{
		if (Game.t1.tX <= 620 && Game.t1.tY == 274)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX <= 620 && Game.t2.tY == 274)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 620 && Game.t3.tY == 274)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 620 && Game.t4.tY == 274)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 620 && Game.t5.tY == 274)
		{
			setCurTrainer(Game.t5);
		}
		
		
		return n;
	}
	/**
	 * Method to check if the curTrainer they are facing it located at Marker1
	 * @param n - int
	 * @return n - int
	 */
	public int setContact8(int n)
	{
		if (Game.t1.tX <= 498 && Game.t1.tY == 6)
		{
			setCurTrainer(Game.t1);
		}
		else if (Game.t2.tX <= 498 && Game.t2.tY == 6)
		{
			setCurTrainer(Game.t2);
		}
		else if (Game.t3.tX <= 498 && Game.t3.tY == 6)
		{
			setCurTrainer(Game.t3);
		}
		else if (Game.t4.tX <= 498 && Game.t4.tY == 6)
		{
			setCurTrainer(Game.t4);
		}
		else if (Game.t5.tX <= 498 && Game.t5.tY == 6)
		{
			setCurTrainer(Game.t5);
		}
		if (x > 460 && y <= 30 && curTrainer.beaten == false)
		{
			//System.out.println("WORKING");
			return n;
		}
		else
		{
			return -n;
		}
	}
	
}
