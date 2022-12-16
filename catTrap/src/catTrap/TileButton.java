package catTrap;

import java.awt.Color;

import javax.swing.JButton;

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
 * Responsibilities of class: Assigns buttons a design depending on model
 * 
 */

public class TileButton extends JButton {

	private int row;
	private int column;
	private TrapModel model;
	/**
	 * Constructor
	 * @param model This allows for checking where pieces are
	 * @param row	This allows for the button to know which row it is in
	 * @param column This allows for the button to know which column it is in
	 */
	public TileButton(TrapModel model, int row, int column)
	{
		super("...");
		this.model = model;
		this.row = row;
		this.column = column;
		checkPiece();
	}
	
	/**
	 * checks if button has been assigned a cat or barrier
	 */
	public void checkPiece()
	{
		if(model.catAt(this.getRow(), this.getCol()))
		{
			this.setText("R");
			this.setBackground(Color.red);
		}
		
		if(model.barrierAt(this.getRow(), this.getCol()))
		{
			this.setText("B");
			this.setBackground(Color.green);
		}
	}
	
	/**
	 * Return row
	 * @return row This is the row the button is
	 */
	public int getRow() 
	{
		return row;
	}
	
	/**
	 * Returns column
	 * @return column This is column the button is in
	 */
	public int getCol() 
	{
		return column;
	}
}
