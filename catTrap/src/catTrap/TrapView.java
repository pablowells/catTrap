package catTrap;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

import cisc191.sdmesa.edu.FishingButton;
import cisc191.sdmesa.edu.FishingButtonListener;
import cisc191.sdmesa.edu.GoneFishingModel;
import cisc191.sdmesa.edu.GoneFishingView;

public class TrapView extends JFrame 
{
	private JPanel leftPanel;
	private JPanel centerPanel;
	private ButtonGroup players;
	private JSlider sizeSlider;
	private JRadioButton[] radioButtonArray;

	
	public TrapView() 
	{
		super("Cat Trap");
		setSize(350,350);
		setLayout(new BorderLayout());
		
		createLeftPanel();
		createCenterPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	private void createCenterPanel() 
	{
		centerPanel = new JPanel(new GridLayout(10, 10, 10, 10));
		for(int row = 0; row < 10; row++) 
		{ 
			for(int col = 0; col < 10; col++)
			{
				Button tile = new Button();
				centerPanel.add(tile);
			}
		}	
		add(centerPanel,BorderLayout.CENTER);
		
	}
	
	private void createRightPanel()
	{
		
	}
	
	private void createLeftPanel()
	{
		leftPanel = new JPanel();
		
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

		add(leftPanel, BorderLayout.LINE_START);
	}
	
	public static void main(String[] args)
	{
		new TrapView();
	}
}
