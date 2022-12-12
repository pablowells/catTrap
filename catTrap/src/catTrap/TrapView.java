package catTrap;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JPanel rightPanel;
	private ButtonGroup players;
	private JSlider sizeSlider;
	private JRadioButton[] radioButtonArray;
	private JLabel barrierRef;
	private JLabel catRef;
	
	private TrapView view;
	private TrapModel model;
	
	private ArrayList<TileButton> tileArray = new ArrayList<TileButton>();
	private ArrayList<TileButtonListener> tblArray = new ArrayList<TileButtonListener>();
	
	public TrapView(TrapModel model) 
	{
		super("Cat Trap");
		
		view = this;
		this.model = model;
		
		setSize(500,500);
		setLayout(new BorderLayout());
		
		createLeftPanel();
		createCenterPanel();
		createRightPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	private void createCenterPanel() 
	{
		centerPanel = new JPanel(new GridLayout(10, 10, 5, 5));
		for(int row = 0; row < model.length; row++) 
		{ 
			for(int col = 0; col < model.length; col++)
			{
				TileButton tile = new TileButton(model, row, col);
				TileButtonListener tbl = new TileButtonListener(model, view, tile);
				tile.addActionListener(tbl);
				tileArray.add(tile);
				tblArray.add(tbl);
				centerPanel.add(tile);
			}
		}	
		add(centerPanel,BorderLayout.CENTER);
		
	}
	
	private void createRightPanel()
	{
		rightPanel = new JPanel();
		barrierRef = new JLabel("Barriers");
		barrierRef.setFont(new Font("Serif", Font.BOLD, 20));
		barrierRef.setForeground(Color.green);
		catRef = new JLabel("Cat: R");	
		catRef.setForeground(Color.red);
		catRef.setFont(new Font("Serif", Font.BOLD, 20));
		rightPanel.add(barrierRef);
		rightPanel.add(catRef);
		add(rightPanel,BorderLayout.EAST);
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
	
	public void updateUI()
	{
		model.toConsole();
		
		if(model.humanWin())
		{
			JOptionPane.showMessageDialog(this, "Game Over - Human Wins!");
			System.exit(0);
		}
		if(model.catWin())
		{
			JOptionPane.showMessageDialog(this, "Game Over - Cat Wins!");
			System.exit(0);
		}
		
		catMove(model.catRow(),model.catCol());
	}
	
	public void catMove(int row, int col)
	{
		for(int i = 0; i < tileArray.size(); i++)
		{
			if(tileArray.get(i).getCol() == col && tileArray.get(i).getRow() == row)
			{
				tileArray.get(i).setBackground(Color.red);
				tileArray.get(i).setText("R");
				tileArray.get(i-model.length).setBackground(null);
				tileArray.get(i-model.length).setText("null");
			}
		}
	}
	
	public static void main(String[] args)
	{
		new TrapView(new TrapModel());
		
	}
}
