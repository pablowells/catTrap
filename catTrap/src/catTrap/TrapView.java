package catTrap;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

import cisc191.sdmesa.edu.GoneFishingModel;
import cisc191.sdmesa.edu.GoneFishingView;

public class TrapView extends JFrame 
{
	private JPanel mainPanel;
	private JPanel leftPanel;
	private ButtonGroup players;
	private JSlider sizeSlider;
	private JRadioButton[] radioButtonArray;

	
	public TrapView() 
	{
		super("Cat Trap");
		createMainPanel();
		createLeftPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void createMainPanel() 
	{
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setSize(500,500);
		add(mainPanel);
	}
	
	public void createLeftPanel()
	{
		leftPanel = new JPanel(new BorderLayout());
		
		ButtonGroup bg = new ButtonGroup();
		radioButtonArray = new JRadioButton[2];

		for (int i = 0; i < radioButtonArray.length; i++)
		{
		   radioButtonArray[i] = new JRadioButton((i + 1) + " players");
		   bg.add(radioButtonArray[i]);
		}
		
		for(int i = 0; i < radioButtonArray.length; i++) {
			leftPanel.add(radioButtonArray[i]);
		}

		add(leftPanel);
	}
	public static void main(String[] args)
	{
		new TrapView();
	}
}
