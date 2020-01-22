/**
 * @author avipatel
 * @version 1
 * @since 2019-01-18
 */

//imports
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class BackgroundPanel extends JPanel
{
	//class body
	
	//declare some variables ima need
	Image image;
	
	/**
	 * Constructor of BackgroundPanel -- choose a backgroundimage based on the number passed in
	 * @param i - int
	 */
	public BackgroundPanel(int i)
	{
		if (i == 1)
		{
			try
			{
    	      //image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Test.gif"), "Test.gif"));
				image = getBackgroundImage("/images/homeScreen.png");
    	    }
			catch (Exception e) { /*handled in paintComponent()*/ }
		}
	    else if (i == 2)
	    {
	    	try
		    {
		      //image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Test.gif"), "Test.gif"));
		    	image = getBackgroundImage("/images/optionScreen.png");
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    }
	    else if (i == 3)
	    {
	    	try
		    {
		      //image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Test.gif"), "Test.gif"));
		    	image = getBackgroundImage("/images/black.png");
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    }
	    else if (i == 4)
	    {
	    	try
		    {
		      //image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Test.gif"), "Test.gif"));
		    	image = getBackgroundImage("/images/black2.png");
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    }
	    else if (i == 5)
	    {
	    	try
		    {
		      //image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Test.gif"), "Test.gif"));
		    	image = getBackgroundImage("/images/bBattle.png");
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    }
	    else if (i == 6)
	    {
	    	try
		    {
		      //image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Test.gif"), "Test.gif"));
		    	image = getBackgroundImage("/images/gBattle.png");
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    } 
		  
	}
	
	/**
	 * Method to paint backgroundImage
	 * @param g - Graphics
	 */
	  @Override
	  protected void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	    if (image != null)
	      g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
	  }
	  
	  /**
	   * method to act as an accessor to background Image
	   * @param url - String
	   * @return i - Image
	   */
	  public Image getBackgroundImage(String url)
	  {
		  ImageIcon i = new ImageIcon(getClass().getResource(url));
		  return i.getImage();
	  }
}