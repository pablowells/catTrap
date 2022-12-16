package catTrap;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

/**
 * Lead Author(s): 
 * @author Pablo Wells
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 12/16/2022
 * 
 * Responsibilities of class: GUI that displays game state and instructions
 * 
 */

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
	private JButton instructions;
	
	private TrapView view;
	private TrapModel model;
	
	private ArrayList<TileButton> tileArray = new ArrayList<TileButton>();
	
	/**
	 * TrapView Constructor that accepts a model
	 */
	public TrapView(TrapModel model) 
	{
		super("Cat Trap");
		
		view = this;
		this.model = model;
		
		setSize(500,500);
		setLayout(new BorderLayout());
		
		createCenterPanel();
		createRightPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	/**
	 * creates Center Panel grid that contains buttons 
	 */
	private void createCenterPanel() 
	{
		centerPanel = new JPanel(new GridLayout(model.getLength(), model.getLength(), 5, 5));
		for(int row = 0; row < model.getLength(); row++) 
		{ 
			for(int col = 0; col < model.getLength(); col++)
			{
				TileButton tile = new TileButton(model, row, col);
				TileButtonListener tbl = new TileButtonListener(model, view, tile);
				tile.addActionListener(tbl);
				tileArray.add(tile);
				centerPanel.add(tile);
			}
		}	
		add(centerPanel,BorderLayout.CENTER);
		
	}
	
	/**
	 * Creates Right Panel container legend and instructions
	 */
	private void createRightPanel()
	{
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		
		barrierRef = new JLabel("BARRIERS: B");
		barrierRef.setFont(new Font("Serif", Font.BOLD, 20));
		barrierRef.setForeground(Color.green);
		
		catRef = new JLabel("CAT: R");	
		catRef.setForeground(Color.red);
		catRef.setFont(new Font("Serif", Font.BOLD, 20));
		
		instructions = new JButton("INSTRUCTIONS");
		instructions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(instructions, "How to Play:\n"
						+ "The player must capture the cat between 4 boxes - up, down, left, and right - before the cat escapes\n"
						+ "The cat controlled by an AI will attempt to reach the edges of the grid in order to escape.");
			}
			
		});
		
		rightPanel.add(barrierRef);
		rightPanel.add(catRef);
		rightPanel.add(instructions);
		
		add(rightPanel,BorderLayout.EAST);
	}
		
	/**
	 * Updates game state
	 */
	public void updateUI()
	{
//		model.toConsole();
		
		if(model.humanWin())
		{
			JOptionPane.showMessageDialog(this, "Game Over - Human Wins!");
			System.exit(0);
		}
		
		catMoveView(model.catRow(),model.catCol());
		
		if(model.catWin())
		{
			JOptionPane.showMessageDialog(this, "Game Over - Cat Wins!");
			System.exit(0);
		}
		
	}
	
	/**
	 * Makes button on the same row and column as the cat to display the cat
	 * @param row This is the cats row
	 * @param col This is the cats column
	 */
	private void catMoveView(int row, int col)
	{
		for(int i = 0; i < tileArray.size(); i++)
		{
			if(tileArray.get(i).getCol() == col && tileArray.get(i).getRow() == row)
			{
				tileArray.get(i).setBackground(Color.red);
				tileArray.get(i).setText("R");				
				removePrevCatButton(i);
			}
		}
	}
	
	/**
	 * Makes button that the cat was previously on to become an empty tile
	 * @param i This is the direction to the tile the cat was previously on
	 */
	private void removePrevCatButton(int i)
	{
		if(model.getPreviousCat() == 1 || model.getPreviousCat() == -1 || model.getPreviousCat() == model.getLength() 
				|| model.getPreviousCat() == -model.getLength())
		{
			tileArray.get(i + model.getPreviousCat()).setBackground(null);
			tileArray.get(i + model.getPreviousCat()).setText("...");
		}
	}
}
