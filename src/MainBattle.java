import javax.swing.JFrame;

public class MainBattle extends JFrame {
	
	public MainBattle(Trainer tr)
	{
		super("Helloloooo");
		
		pack();
		setSize(1020, 750);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Battle(tr));
		setVisible(true);
	}

}
