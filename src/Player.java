/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends GlobalPosition {
	//class body
	
	//declare variables ima need - private instance, public instance, public static --same goes for the other classes :)
	private String playerImage = "/images/Front2.png";
	
	int velX = 0;
	int velY = 0;
	int key = 0;
	boolean wIsDown = false;
	boolean aIsDown = false;
	boolean sIsDown = false;
	boolean dIsDown = false;
	public static boolean xIsDown = false;
	boolean xPrev = false;
	Bag playerBag;
	
	/**
	 * Constructor for Player
	 * @param x - int
	 * @param y - int
	 */
	public Player(int x, int y)
	{
		super(x, y);
		playerBag = new Bag(5,10,1);
		
		if (MainMenu.playerChar == 1)
		{
			playerImage = "images/hughFront.png";
		}
		else if (MainMenu.playerChar == 2)
		{
			playerImage = "/images/Front2.png";
		}
		else
		{
			playerImage = "/images/hildaFront.png";
		}
	}
	
	/**
	 * accessor method to return the value of xIsDown
	 * @return xIsDown - boolean
	 */
	public boolean getXIsDown()
	{
		return xIsDown;
	}
	
	/**
	 * mutator method to set the value of xIsDown
	 * @param xIsDown - boolean
	 */
	public void setXIsDown(boolean xIsDown)
	{
		this.xIsDown = xIsDown;
	}

	/**
	 * Update method to be called by Game class exery 10 seconds
	 * @throws IOException
	 */
	public void update() throws IOException
	{
		x += velX;
		y += velY;
		
		//set contacts between the player and the trainers
		if (!(y < 0))
		{
			/*setContact1(1);
			setContact2(2); 
			setContact3(3);
			setContact4(4);
			setContact5(5);
			setContact6(6);
			setContact7(7);
			setContact8(8);*/
		}
		
		//check if player is currently moving along the yaxis
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_S)
		{
			boundaryDetectionY();
		}
		
		//check if player is currently moving along the xAxis
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_D)
		{
			boundaryDetectionX();
		}
		
		//boundaryDetectionX();
		//boundaryDetectionY();

	}
	
	/**
	 * Method to do a bunch of things once a key is pressed aka set movement, open bag, start battle etc 
	 * @param e - KeyEvent
	 */
	public void keyPressed(KeyEvent e)
	{	
		//playerContact = -1;
		if (!(y < 0))
		{
			if (wIsDown == false && aIsDown == false && sIsDown == false && dIsDown == false)
			{
				key = e.getKeyCode();
			
				if (key == KeyEvent.VK_SPACE)
				{
						playerBag.openBag();
						xIsDown = true;
				}
				
				//System.out.println("Checking: " + getPlayerContact());
				
				if (key == KeyEvent.VK_ENTER && getPlayerContact() > 0)
				{
					//System.out.println("ENTER CLICKED!");
					
					new Battle(getCurTrainer());
					//lookforTrainer();
					//look(y, x);
					//searchTrainer
				}
				
				if (xIsDown == false)
				{
					if (key == KeyEvent.VK_W)
					{
						velY = -2;
						if (MainMenu.playerChar == 1)
						{
							playerImage = "/images/hughBack.png";
						}
						else if (MainMenu.playerChar == 2)
						{
							playerImage = "/images/Back2.png";
						}
						else
						{
							playerImage = "/images/hildaBack.png";
						}
						wIsDown = true;
					}
					else if (key == KeyEvent.VK_S)
					{
						velY = 2;
						if (MainMenu.playerChar == 1)
						{
							playerImage = "/images/hughFront.png";
						}
						else if (MainMenu.playerChar == 2)
						{
							playerImage = "/images/Front2.png";
						}
						else
						{
							playerImage = "/images/hildaFront.png";
						}
						sIsDown = true;
					}
					else if (key == KeyEvent.VK_A)
					{
						velX = -2;
						if (MainMenu.playerChar == 1)
						{
							playerImage = "/images/hughLeft.png";
						}
						else if (MainMenu.playerChar == 2)
						{
							playerImage = "/images/Left2.png";
						}
						else
						{
							playerImage = "/images/hildaLeft.png";
						}
						aIsDown = true;
					}
					else if (key == KeyEvent.VK_D)
					{
						velX = 2;
						if (MainMenu.playerChar == 1)
						{
							playerImage = "/images/hughRight.png";
						}
						else if (MainMenu.playerChar == 2)
						{
							playerImage = "/images/Right2.png";
						}
						else
						{
							playerImage = "/images/hildaRight.png";
						}
						//playerImage = "/images/Right2.png";
						dIsDown = true;
					}
				}
		
			}	
		}
		
		
	}
	
	//yTemp = y+2
	
	public ArrayList<Integer> xVal = Trainer.trainerX;
	public ArrayList<Integer> yVal = Trainer.trainerY;
	
	/**
	 * A method to do a bunch of thnigs when a key is releazed aka close bag and stop movement 
	 * @param e - KeyEvent
	 */
	public void keyReleased(KeyEvent e)
	{
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W)
		{
			velY= 0;
			wIsDown = false;
		}
		else if (key == KeyEvent.VK_S)
		{
			velY= 0;
			sIsDown = false;
		}
		else if (key == KeyEvent.VK_A)
		{
			velX= 0;
			aIsDown = false;
		}
		else if (key == KeyEvent.VK_D)
		{
			velX = 0;
			dIsDown = false;
		}
		
	}
	
	/**
	 * method to draw player at it's current (atm maybe updated) position
	 * @param g2d - Graphics2D
	 */
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getPlayerImage(), x, y, null);
	}
	
	/**
	 * accessor method to get player image
	 * @return i - Image
	 */
	public Image getPlayerImage()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		//Image scaled = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);

		return i.getImage();
	}
}
