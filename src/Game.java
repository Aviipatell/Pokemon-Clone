/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.io.*;
import sun.audio.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Game extends JPanel implements ActionListener{
	//class body
	
	//Declare somevariables ima need
	//Idk if i need this but until then, it'll stay here:
	private static final long serialVersionUID = 1L;
	private String background = "/images/MapRoute.png";
	
	Timer gameLoopTimer;
	public Player p;
	public static Trainer t1;
	public static Trainer t2;
	public static Trainer t3; 
	public static Trainer t4;
	public static Trainer t5;
	private int trainerNum = 1;
	
	/**
	 * Constructor for game
	 */
	public Game()
	{
		setFocusable(true);
		
		gameLoopTimer = new Timer(10, this);
		gameLoopTimer.start();
	
		p = new Player(748, 634);
		//b = new Bag(3,5,1);
		/*		
		trainers.add(new Trainer("Harteek"));
		trainers.add(new Trainer("Varun"));
		trainers.add(new Trainer("Andrick"));
		trainers.add(new Trainer("Vedant"));
		trainers.add(new Trainer("Hwang"));
		*/
		
		t1 = new Trainer("Harteek");
		t2 = new Trainer("Varun");
		t3 = new Trainer("Andrick");
		t4 = new Trainer("Vedant");
		t5 = new Trainer("Hwang");
		
		
		addKeyListener(new KeyInput(p));
		//addKeyListener(new KeyInput(b));
	}
	
	/**
	 * method to paint backgroundImage, trainers, and player onto the JFrame
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		Graphics2D h2d = (Graphics2D) g;
		Graphics2D j2d = (Graphics2D) g;
		Graphics2D k2d = (Graphics2D) g;
		Graphics2D l2d = (Graphics2D) g;
		Graphics2D m2d = (Graphics2D) g;
		
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		
		/*for (int i = 0; i < trainers.size(); i++)
		{
			trainers.get(i).draw(g2d);
		}*/
		
		t1.draw(g2d);
		t2.draw(g2d);
		t3.draw(g2d);
		t4.draw(g2d);
		t5.draw(g2d);
		
		p.draw(g2d);
		
	}
	
	/**
	 * Accessor method for backgroundImage
	 * @return Image
	 */
	public Image getBackgroundImage()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

	/**Method to help keep updating game frame every 10 ms
	 * @param e - ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//System.out.println("RUNNING GAME LOOP");
		try {
			p.update();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Calls the paint method every 10 miliseconds
		repaint();
	}	
	
	/**
	 * method to end game / set it to invisble or remove it
	 */
	public void endGame()
	{
		setVisible(false);
		remove(this);
	}
	
}
