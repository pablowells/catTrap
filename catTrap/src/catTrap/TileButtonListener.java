package catTrap;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * Responsibilities of class: Listener to tile button
 * 
 */

public class TileButtonListener implements ActionListener {

	private TrapModel model;
	private TrapView view;
	private TileButton tile;
	
	/**
	 * Constructor for Tile Button Listener
	 * @param model This allows for cat updating
	 * @param view This allows for updating the GUI
	 * @param tb This allows to change buttons
	 */
	public TileButtonListener(TrapModel model, TrapView view,
			TileButton tb)
	{
		this.model = model;
		this.view = view;
		this.tile = tb;
	}

	/**
	 * Allows for interaction with user
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(!model.catAt(tile.getRow(), tile.getCol())) 
		{
			model.addBarrier(tile.getRow(),tile.getCol());
			tile.setBackground(Color.green);
			tile.setText("B");
		}
		
		model.updateCat();
		view.updateUI();
	}

}
