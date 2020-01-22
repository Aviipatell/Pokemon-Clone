import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class HealthBar extends JPanel {
	
	public int curHealth;
	public int maxHealth;
	
	public HealthBar(int curHealth, int maxHealth)
	{
		this.curHealth = curHealth;
		this.maxHealth = maxHealth;
	}
	
	public void paint (Graphics g)
    { 
		super.paint(g); 
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.green); 
		g.drawOval(0,0, 20, 20); 
		g.setColor(Color.yellow); 
		g.fillOval(0, 0, 15, 15); 
    } 
	
	public void drawHealth (Graphics2D g2D, int i)
    { 
		if (i == 1)
		{
			g2D.drawRect(10, 10, 150, 20);
		}
		else 
		{
			g2D.drawRect(500, 200, 150, 20);
		}
	} 

}
