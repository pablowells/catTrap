package catTrap;

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
 * Responsibilities of class: Contains barrier data
 * 
 */

public class Barrier extends PlayPiece {

	private TrapModel model;
	private int row;
	private int column;
	
	/**
	 * Constructor
	 * @param model This allows for finding row and column
	 */
	Barrier(TrapModel model) 
	{
		this.model = model;
	}
	
	/**
	 * Gets barriers row
	 * @return row This is the barriers row
	 */
	@Override
	public int getRow() 
	{
		for(int i = 0 ; i < model.getLength(); i++)
		{
			for(int j = 0; j < model.getLength(); j++)
			{
				if(model.grid[i][j] == this) 
				{
					row = i;
				}
			}
		}
		return row;
	}

	/**
	 * Gets barriers column
	 * @return column This is the barriers column
	 */
	@Override
	public int getCol() 
	{
		for(int i = 0 ; i < model.getLength(); i++)
		{
			for(int j = 0; j < model.getLength(); j++)
			{
				if(model.grid[i][j] == this) 
				{
					column = j;
				}
			}
		}
		return column;	
	}
	
//	Used for debugging	
//	public String toString()
//	{
//		return "BARR";
//	}
}
