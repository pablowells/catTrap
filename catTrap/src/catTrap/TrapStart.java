package catTrap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
 * Responsibilities of class: Accepts map settings and start game
 * 
 */

public class TrapStart extends JFrame {
	
	private JPanel beginPanel;
	private JPanel settingPanel;
	private JButton gameStart;
	private JPanel welcomePanel;
	private JLabel welcome;
	private JLabel mapSize;
	
	private TrapModel model;
	private JRadioButton[] radioButtonArray;
	
	/**
	 * Default Constructor
	 */
	public TrapStart() 
	{
		super("Trap Menu");
				
		setSize(400,200);
		setLayout(new BorderLayout());
				
		gameSettings();
		welcome();
		startGamePane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Welcome Panel that welcomes user
	 */
	private void welcome()
	{
		welcomePanel = new JPanel();
		
		welcome = new JLabel("WELCOME TO CAT TRAP");
		welcome.setForeground(Color.red);
		welcome.setFont(new Font("Serif", Font.BOLD, 20));
		
		welcomePanel.add(welcome);
		
		add(welcomePanel, BorderLayout.NORTH);
	}
	
	/**
	 * This is  a panel that displays buttons that change map size
	 */
	private void gameSettings()
	{
		settingPanel = new JPanel();

		mapSize = new JLabel("Select Map Size");
		
		ButtonGroup bg = new ButtonGroup();
		radioButtonArray = new JRadioButton[3];


		radioButtonArray[0] = new JRadioButton("SMALL");
		radioButtonArray[1] = new JRadioButton("MEDIUM");
		radioButtonArray[2] = new JRadioButton("BIG");
				
		RadioListener listenOne = new RadioListener(radioButtonArray[0], model, radioButtonArray);
		RadioListener listenTwo = new RadioListener(radioButtonArray[1], model, radioButtonArray);
		RadioListener listenThree = new RadioListener(radioButtonArray[2], model, radioButtonArray);

		
		radioButtonArray[0].addActionListener(listenOne);
		radioButtonArray[1].addActionListener(listenTwo);
		radioButtonArray[2].addActionListener(listenThree);
		
		bg.add(radioButtonArray[0]);
		bg.add(radioButtonArray[1]);
		bg.add(radioButtonArray[2]);

		settingPanel.add(mapSize,BorderLayout.PAGE_START);
		settingPanel.add(radioButtonArray[0], BorderLayout.LINE_START);
		settingPanel.add(radioButtonArray[1], BorderLayout.CENTER);
		settingPanel.add(radioButtonArray[2], BorderLayout.LINE_END);

		add(settingPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Radio Listener Class that allows for interaction with radio buttons
	 */
	private class RadioListener implements ActionListener {

		private JRadioButton rButton;
		private TrapModel model;
		private JRadioButton[] radioButtonArray;
		
		/**
		 * Constructor that initializes radio listener fields
		 * @param rButton thats assigned
		 * @param model that was declared in trapStart
		 * @param radioButtonArray that button is in
		 */
		RadioListener(JRadioButton rButton, TrapModel model, JRadioButton[] radioButtonArray)
		{
			this.rButton = rButton;
			this.model = model;
			this.radioButtonArray = radioButtonArray;
		}
		
		/**
		 * Creates differently sized maps depending on button selected
		 * @param ActionEvent e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(rButton == radioButtonArray[0])
			{
				model = new TrapModel(7, 4);
				setModel(model);
			}
			else if(rButton == radioButtonArray[1])
			{
				model = new TrapModel(9, 6);
				setModel(model);
			}
			else if(rButton == radioButtonArray[2])
			{
				model = new TrapModel(13, 8);
				setModel(model);
			}			
		}
	}
	
	/**
	 * sets model from instantiated from Radio Buttons
	 * @param model This instantiates the declared trapModel 
	 */
	private void setModel(TrapModel model)
	{
		this.model = model;
	}
	
	/*
	 * Start Game Panel that contains start button
	 */
	private void startGamePane()
	{
		beginPanel = new JPanel();
		gameStart = new JButton("START");
		
		gameStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(model == null)
				{
					JOptionPane.showMessageDialog(beginPanel, "A size must be selected to play!");
				}
				else 
				{
					TrapView gameStart = new TrapView(model);
				}
			}
		} );
		
		beginPanel.add(gameStart);
		
		add(beginPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * Launches program
	 * @param args This is unused
	 */
	public static void main(String[] args)
	{
		TrapStart menu = new TrapStart();
	}
}
